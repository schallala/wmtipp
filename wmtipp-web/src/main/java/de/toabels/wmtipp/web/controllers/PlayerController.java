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
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.springframework.stereotype.Controller;

@Controller("playerCtrl")
@Scope("request")
public class PlayerController {

  @Autowired
  private IPlayerService playerService;

  private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

  private Map<Long, PlayerDto> playerMap;

  private PlayerDto currentPlayer;

  private Date date;
  
  private boolean editMode;

  @PostConstruct
  public void init() {
    if (currentPlayer == null) {
      currentPlayer = new PlayerDto();
      currentPlayer.setPredictedChampion(new TeamDto());
   }
  }

  public Collection<PlayerDto> getPlayerList() {
    if (playerMap == null) {
      playerMap = playerService.list().stream().collect(Collectors.toMap(PlayerDto::getId, p -> p));
    }
    return playerMap.values();
  }

  public PlayerDto getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(PlayerDto currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public boolean isEditMode() {
    return editMode;
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

  public void testSave() {
    PlayerDto dto = new PlayerDto();
    dto.setName("Egal");
    dto.setFirstName("Horst");
    dto.setLogin("login");
    dto.setEmail("a@bc.de");
    dto.setPassword("abc123");
    dto.setUserRole(UserRoleType.ADMIN);
    dto.setTipsVisible(true);
    TeamDto predictedChampion = new TeamDto();
    predictedChampion.setId(50L);
    predictedChampion.setTournamentWon(true);
    predictedChampion.setIsNull(true);
    dto.setPredictedChampion(predictedChampion);
    PlayerDto result = playerService.save(dto);
  }

  public void checkDate() {
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Successful", "Your Date is: " + getDate()));
  }
}
