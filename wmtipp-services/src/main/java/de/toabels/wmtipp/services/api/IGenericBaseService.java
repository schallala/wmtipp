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
package de.toabels.wmtipp.services.api;

import de.toabels.wmtipp.model.dto.AbstractBaseDto;
import de.toabels.wmtipp.model.db.IEntityBase;
import java.util.List;

/**
 * Generic DAO interfacre of common persistence tasks
 *
 * All methods are working on DTO objects and never directly return entity objects to calling methods. Mapping between
 * DTO and entity objects is done by a generic mapping servicee, where mapping rules are specified.
 *
 * @author abels
 * @param <D> - DTO object
 * @param <E> - ntity object
 */
public interface IGenericBaseService<D extends AbstractBaseDto, E extends IEntityBase<E>> {

  /**
   * Factory method to create new DTO objects
   * 
   * @return DTO instance
   */
  D getNewObjectInstance();
  
  /**
   * Persist a DTO object to the database.
   * This methods handles creating objects as well as updates.
   * 
   * @param dto - DTO object
   * 
   * @return updated dto object after persisting
   */
  D save(D dto);

  /**
   * Deleting a DTO object from database
   * 
   * @param dto - DTO object
   */
  void delete(D dto);

  /**
   * Get a list of all DTO objects which entities are stored in database
   * 
   * @return unordered list of all objects
   */
  List<D> list();

  /**
   * Get an ordered list of all DTO objects which entities are stored in database
     * 
   * @param order - array of strings (JPA syntax) defining the sort order of list 
   * @return ordered list of all objects
   */
  List<D> listOrdered(String... order);

  /**
   * Get a DTO object with specified ID
   * 
   * @param id - identifier (database ID) of object to find
   * @return object with specified ID
   */
  D findById(int id);
  
}
