/*
 * Copyright (C) 2018 Torsten Abels <torsten.abels@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package de.toabels.wmtipp.services.utiils;

import de.toabels.wmtipp.model.db.IEntityBase;
import de.toabels.wmtipp.model.dto.AbstractBaseDto;

/**
 * Interface for mapping services between DTO and entity objects
 * 
 * @author abels
 * @param <D> DTO object
 * @param <E> entity object
 */
public interface IMappingService<D extends AbstractBaseDto, E extends IEntityBase<E>> {

  /**
   * Dispatcher method to invoke specific mapper method of entity object to DTO object
   *
   * @param entity - database object
   * @return DTO object
   */
  D map(E entity);

  /**
   * Dispatcher method to invoke specific mapper method of DTO object to entity object
   *
   * @param dto
   * @return
   */
  E map(D dto);
  
}
