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
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.springframework.stereotype.Controller;

@Controller("playerCtrl")
public class PlayerController {

  @Autowired
  private IPlayerService playerService;

  @Autowired
  private ITeamService teamService;

  private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

  private Map<Long, PlayerDto> playerMap;

  private List<PlayerDto> playerList;

  private List<TeamDto> teamList;

  private PlayerDto currentPlayer;

  private boolean editMode;

  private boolean newMode;

  @PostConstruct
  public void init() {
    if (currentPlayer == null) {
      currentPlayer = new PlayerDto();
      currentPlayer.setPredictedChampion(new TeamDto());
    }
  }

  public List<PlayerDto> getPlayerList() {
    if (playerMap == null) {
      playerList = playerService.listOrdered("name", "firstName");
      playerMap = playerList.stream().collect(Collectors.toMap(PlayerDto::getId, p -> p));
    }
    return playerList;
  }

  public List<TeamDto> getTeamList() {
    if (teamList == null) {
      teamList = teamService.listOrdered("name");
    }
    return teamList;
  }

  public PlayerDto getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(PlayerDto currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public boolean isNewMode() {
    return newMode;
  }

  public void save() {
    if (currentPlayer != null) {
      PlayerDto result = playerService.save(currentPlayer);
      playerMap = null;
      editMode = false;
      growlSuccess("Your Dto is: " + result);
    }
  }

  public void delete() {
    if (currentPlayer != null) {
      playerService.delete(currentPlayer);
      playerMap = null;
      growlSuccess("Deleted!");
    }
  }

  public void playerChangeListener(ValueChangeEvent event) {
    Long id = (Long) event.getNewValue();
    if (null != id && null != currentPlayer && !id.equals(currentPlayer.getId())) {
      currentPlayer = playerMap.get(id);
    }
  }

  public void edit() {
    editMode = true;
  }

  public void clear() {
    currentPlayer = null;
    init();
    editMode = true;
  }

  public UserRoleType[] getUserRoles() {
    return UserRoleType.values();
  }

  private void growlSuccess(String message) {
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Successful", message));
  }

}
