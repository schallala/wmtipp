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

import de.toabels.wmtipp.model.db.Group;
import de.toabels.wmtipp.services.dao.IGroupDao;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl extends AbstractGenericDao<Group> implements IGroupDao {


  public GroupDaoImpl(){
    super();
    setClazz(Group.class);
  }
  
}
