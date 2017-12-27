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

import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.model.types.UserRoleType;
import de.toabels.wmtipp.services.api.IPlayerService;
import de.toabels.wmtipp.services.api.ITeamService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

@Controller("playerCtrl")
public class PlayerEditController extends AbstractEditController<PlayerDto> {

  @Autowired
  private IPlayerService playerService;

  @Autowired
  private ITeamService teamService;

  private static final Logger logger = LoggerFactory.getLogger(PlayerEditController.class);

  private List<TeamDto> teamList;

  /* first initialization steps */
  @PostConstruct
  public void init() {
    super.init(playerService);
  }

  public PlayerDto getCurrentPlayer() {
    return super.getCurrentSubject();
  }

  public List<PlayerDto> getPlayerList() {
    return getSubjectList("name", "firstName");
  }

  /* Subject specific selection lists */
  public List<TeamDto> getTeamList() {
    if (teamList == null) {
      teamList = teamService.listOrdered("name");
    }
    return teamList;
  }

  public UserRoleType[] getUserRoles() {
    return UserRoleType.values();
  }

}
