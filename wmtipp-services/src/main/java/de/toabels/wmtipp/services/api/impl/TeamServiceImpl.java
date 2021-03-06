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

import de.toabels.wmtipp.model.db.Team;
import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.services.api.ITeamService;
import de.toabels.wmtipp.services.dao.ITeamDao;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abels
 */
@Service
@Transactional
public class TeamServiceImpl extends GenericBaseServiceImpl<TeamDto, Team> implements ITeamService {

  ITeamDao teamDao;
  
  @Inject
  public TeamServiceImpl(ITeamDao dao) {
    super(dao);
    teamDao = dao;
  }

  @Override
  public TeamDto getNewObjectInstance() {
    TeamDto object = new TeamDto();
    // add needed child objects
    object.setGroup(new GroupDto());

    return object;
  }


}
