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

import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.RoundDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.services.api.IMatchService;
import de.toabels.wmtipp.services.api.IPlayerService;
import de.toabels.wmtipp.services.api.IRoundService;
import de.toabels.wmtipp.services.api.ITeamService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("playerListCtrl")
@Scope("request")
public class PlayerListController {

  private static final Logger logger = LoggerFactory.getLogger(PlayerListController.class);

  private List<PlayerDto> playerList;

  private List<TeamDto> teamList;

  private List<GroupDto> groupList;

  private List<MatchDto> matchList;

  private List<RoundDto> roundList;

  @Autowired
  private IPlayerService playerService;

  @Autowired
  private ITeamService teamService;

  @Autowired
  private IMatchService matchService;

  @Autowired
  private IRoundService roundService;

  private void invalidatePlayerList() {
    playerList = null;
  }

  public List<PlayerDto> getPlayerList() {
    if (playerList == null) {
      playerList = playerService.list();
    }
    return playerList;
  }

  public List<TeamDto> getTeamList() {
    if (teamList == null) {
      teamList = teamService.list();
    }
    return teamList;
  }

  public List<MatchDto> getMatchList() {
    if (matchList == null) {
      matchList = matchService.list();
    }
    return matchList;
  }

  public List<RoundDto> getRoundList() {
    if (roundList == null) {
      roundList = roundService.list();
    }
    return roundList;
  }

  
}
