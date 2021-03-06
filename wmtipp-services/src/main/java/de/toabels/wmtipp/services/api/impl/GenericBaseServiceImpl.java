/* 
 * Copyright (C) 2017 Torsten Abels <torsten.abels@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.toabels.wmtipp.services.api.impl;

import de.toabels.wmtipp.model.dto.ICompetitionAware;
import de.toabels.wmtipp.model.db.IEntityBase;
import de.toabels.wmtipp.model.dto.AbstractBaseDto;
import de.toabels.wmtipp.model.dto.CompetitionDto;
import de.toabels.wmtipp.services.api.IGenericBaseService;
import de.toabels.wmtipp.services.dao.IGenericDao;
import de.toabels.wmtipp.services.utiils.IMappingService;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Generic DAO implementation of common persistence tasks
 *
 * All methods are working on DTO objects and never directly return entity
 * objects to calling methods. Mapping between DTO and entity objects is done by
 * a generic mapping servicee, where mapping rules are specified.
 *
 * @author abels
 * @param <D> - DTO object
 * @param <E> - ntity object
 */
@Service
@Transactional
public abstract class GenericBaseServiceImpl<D extends AbstractBaseDto, E extends IEntityBase<E>> implements IGenericBaseService<D, E> {

    private static final Logger logger = LoggerFactory.getLogger(GenericBaseServiceImpl.class);

    private IGenericDao<E> dao;

    /*
   * Child classes get direct access to the mapper in order to implement offer additional methods with mapping.
     */
    @Inject
    protected IMappingService<D, E> mapper;

    public GenericBaseServiceImpl() {
    }

    /**
     * Each child class has to define its associated DAO class to perform
     * concrete task on database
     *
     * @param dao
     */
    public GenericBaseServiceImpl(IGenericDao<E> dao) {
        logger.info("GenericBaseServiceImpl initialized with DAO " + dao.getClass().getSimpleName());
        this.dao = dao;
    }

    @Override
    public abstract D getNewObjectInstance();

    @Caching(evict = {
        @CacheEvict(value = "lists", allEntries = true)
        , 
        @CacheEvict(value = "entities", key = "#root.target.class.simpleName + #result.id")
    })
    @Override
    public D save(D dto) {
        E entity = mapper.map(dto);
        if (entity == null) {
            return null;
        }
        if (entity.getId() != null) {
            dao.update(entity);
        } else {
            dao.create(entity);
        }
        return mapper.map(entity);
    }

    @Override
    public List<D> saveList(List<D> dtoList) {
        if (dtoList == null) {
            return dtoList;
        }
        List<D> newList = new ArrayList<>();
        dtoList.forEach((dto) -> {
            newList.add(save(dto));
        });
        return newList;
    }

    @Caching(evict = {
        @CacheEvict(value = "lists", allEntries = true)
        , 
        @CacheEvict(value = "entities", key = "#root.target.class.simpleName + #dto.id")
    })
    @Override
    public void delete(D dto) {
        dao.deleteById(dto.getId());
    }

    @Override
    public void deleteList(List<D> dtoList) {
        dtoList.forEach((dto) -> {
            delete(dto);
        });
    }

    @Cacheable(value = "lists", key = "#root.target.class.simpleName + 'list'")
    @Override
    public List<D> list() {
        return dao.findAll().stream().map(p -> mapper.map(p)).collect(Collectors.toList());
    }

    @Override
    public List<D> filterCompetition(List<D> list, Long competitionId) {
        if (competitionId == null) {
            return list;
        }

        List<D> result = new ArrayList<>();
        for (D dto : list) {
            if (competitionId.equals(
                    ((ICompetitionAware) dto).getCompetition().getId())) {
                result.add(dto);
            }
        }
        return result;
    }

    @Override
    public List<D> filterCommunity(List<D> list, Long communityId) {
        if (communityId == null) {
            return list;
        }
        List<D> result = new ArrayList<>();
        for (D dto : list) {
            if (communityId.equals(
                    ((ICompetitionAware) dto).getCompetition().getId())) {
                result.add(dto);
            }
        }
        return result;
    }

    // only one ordered list per target class will be cached 
    @Cacheable(value = "lists", key = "#root.target.class.simpleName + 'listOrdered'")
    @Override
    public List<D> listOrdered(String... order) {
        List<E> liste = dao.findAllOrdered(order);
        return liste.stream().map(p -> mapper.map(p)).collect(Collectors.toList());
    }

    @Cacheable(value = "entities", key = "#root.target.class.simpleName + #id")
    @Override
    public D findById(int id) {
        return mapper.map(dao.findOne(id));
    }
}
