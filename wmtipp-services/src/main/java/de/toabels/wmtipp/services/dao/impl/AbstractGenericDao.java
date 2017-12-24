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
package de.toabels.wmtipp.services.dao.impl;

import de.toabels.wmtipp.model.db.IEntityBase;
import de.toabels.wmtipp.services.dao.IGenericDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractGenericDao< T extends IEntityBase<T>> implements IGenericDao<T> {

  private Class< T> clazz;

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public final void setClazz(Class< T> clazzToSet) {
    this.clazz = clazzToSet;
  }

  @Override
  public T findOne(long id) {
    return (T) entityManager.find(clazz, id);
  }

  @Override
  public List< T> findAll() {
    return entityManager.createQuery("from " + clazz.getName()).getResultList();
  }

  @Override
  public List< T> findAllOrdered(String ... orderBy) {
    String orderByString = null;
    for(String str : orderBy){
      orderByString = (orderByString == null) ? " order by " + str : orderByString + ", " + str;
    }
    return entityManager.createQuery("from " + clazz.getName() + orderByString).getResultList();
  }

  @Override
  public void create(T entity) {
    entityManager.persist(entity);
    entityManager.flush();
  }

  @Override
  public void update(T entity) {
    entityManager.merge(entity);
  }

  @Override
  public void delete(T entity) {
    entityManager.remove(entity);
  }

  @Override
  public void deleteById(long entityId) {
    T entity = findOne(entityId);
    delete(entity);
  }

}
