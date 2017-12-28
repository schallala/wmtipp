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
package de.toabels.wmtipp.web.controllers;

import de.toabels.wmtipp.model.db.Team;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import de.toabels.wmtipp.services.dao.ITeamDao;
import org.springframework.stereotype.Controller;

@Controller("teamListCtrl")
@Scope("request")
public class TeamListController {

  private static final Logger logger = LoggerFactory.getLogger(TeamListController.class);

  private List<Team> teamList;

  @Autowired
  private ITeamDao teamDao;

  private void invalidateTeamList() {
    teamList = null;
  }

  public List<Team> getTeamList() {
    if (teamList == null) {
      teamList = teamDao.findAll();
    }
    return teamList;

  }
}
