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

import de.toabels.wmtipp.model.db.IEntityBase;
import de.toabels.wmtipp.model.dto.AbstractBaseDto;
import de.toabels.wmtipp.services.api.IGenericBaseService;
import de.toabels.wmtipp.services.dao.IGenericDao;
import de.toabels.wmtipp.services.utiils.MappingServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abels
 * @param <D>
 * @param <E>
 */
@Service
@Transactional
public class GenericBaseServiceImpl<D extends AbstractBaseDto, E extends IEntityBase<E>> implements IGenericBaseService<D, E> {

  private IGenericDao<E> dao;

  @Inject
  private MappingServiceImpl<D, E> mapper;

  public GenericBaseServiceImpl() {

  }

  public GenericBaseServiceImpl(IGenericDao<E> dao) {
    this.dao = dao;
  }

  @Override
  public D save(D dto) {
    E entity = mapper.map(dto);
    if (entity.getId() != null) {
      dao.update(entity);
    } else {
      dao.create(entity);
    }
    return mapper.map(entity);
  }

  @Override
  public void delete(D dto) {
    dao.deleteById(dto.getId());
  }

  @Override
  public List<D> list() {
    return dao.findAll().stream().map(p -> mapper.map(p)).collect(Collectors.toList());
  }

  @Override
  public D findById(int id) {
    return mapper.map(dao.findOne(id));
  }
}
