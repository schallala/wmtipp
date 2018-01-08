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
package de.toabels.wmtipp.web.controllers.masterdata;

import de.toabels.wmtipp.model.dto.AbstractBaseDto;
import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.RoundDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.services.api.IGenericBaseService;
import de.toabels.wmtipp.services.api.IGroupService;
import de.toabels.wmtipp.services.api.IMatchService;
import de.toabels.wmtipp.services.api.IPlayerService;
import de.toabels.wmtipp.services.api.IRoundService;
import de.toabels.wmtipp.services.api.ITeamService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract base class to manage CRUD operations on master data objects
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 * @param <D> - DTO class of page subject
 */
public abstract class AbstractEditController<D extends AbstractBaseDto> {

  private IGenericBaseService subjectService;

  private static final Logger logger = LoggerFactory.getLogger(AbstractEditController.class);

  private ResourceBundle messageBundle;

  protected Map<Long, D> subjectMap;

  protected List<D> subjectList;

  protected D currentSubject;

  protected boolean editMode;

  /* define lookup services for listboces in central spot */
  @Autowired
  private IMatchService matchService;

  @Autowired
  private IGroupService groupService;

  @Autowired
  private IRoundService roundService;

  @Autowired
  private ITeamService teamService;

  @Autowired
  private IPlayerService playerService;

  /* first initialization steps */
  public void init(IGenericBaseService service) {
    if (this.subjectService == null) {
      this.subjectService = service;
    }
  }

  /* subject list for selection */
  protected List<D> getSubjectList(String... order) {
    subjectList = subjectService.listOrdered(order);
    subjectMap = subjectList.stream().collect(Collectors.toMap(AbstractBaseDto::getId, p -> p));
    return subjectList;
  }


  /* edit mode flag */
  public boolean isEditMode() {
    return editMode;
  }

  /* current subject of crud operations */
  public D getCurrentSubject() {
    if(currentSubject == null){
      setNewSubjectInstance();
    }
    return currentSubject;
  }

  public void setCurrentSubject(D subject) {
    this.currentSubject = subject;
  }

  public void save() {
    if (currentSubject != null) {
      D result = (D) subjectService.save(currentSubject);
      editMode = false;
      growlSuccess(getMessage("global_save_success"), getMessage("global_save_success_detail"));
    }
  }

  public void saveList() {
    if (subjectList != null) {
      subjectService.saveList(subjectList);
      editMode = false;
      growlSuccess(getMessage("global_save_success"), getMessage("global_save_success_detail"));
    }
  }

  public void delete() {
    if (currentSubject != null) {
      subjectService.delete(currentSubject);
      growlSuccess(getMessage("global_delete_success"), getMessage("global_delete_success_detail"));
    }
  }

  public void edit() {
    editMode = true;
  }

  public void clear() {
    currentSubject = null;
    setNewSubjectInstance();
    editMode = true;
  }

  public void cancel() {
    currentSubject = null;
    setNewSubjectInstance();
    editMode = false;
  }

  private void setNewSubjectInstance() {
    if (currentSubject == null) {
      currentSubject = (D) subjectService.getNewObjectInstance();
    }

  }

  /* List change listener */
  public void subjectChangeListener(ValueChangeEvent event) {
    Long id = (Long) event.getNewValue();
    if (null != id && null != currentSubject && !id.equals(currentSubject.getId())) {
      currentSubject = subjectMap.get(id);
    }
  }

  /* Subject specific selection lists */
  /**
   * List of matches for select box
   *
   * @return team list
   */
  public List<MatchDto> getMatchList() {
      return matchService.listOrdered("startDate");
  }

  /**
   * List of groups for select box
   *
   * @return team list
   */
  public List<GroupDto> getGroupList() {
      return groupService.listOrdered("sortOrder");
  }

  /**
   * List of rounds for select box
   *
   * @return team list
   */
  public List<RoundDto> getRoundList() {
    return roundService.listOrdered("sortOrder nulls last");
  }

  /**
   * List of players for select box
   *
   * @return player list
   */
  public List<PlayerDto> getPlayerList() {
    return playerService.listOrdered("name");
  }

  /**
   * List of teams for select box
   *
   * @return team list
   */
  public List<TeamDto> getTeamList() {
      return teamService.listOrdered("name");
  }
  
  public TeamDto mapTeam(Long id) {
    for (TeamDto dto : getTeamList()) {
      if (id.equals(dto.getId())) {
        return dto;
      }
    }
    return null;
  }

  /* Feedback popups */
  private void growlSuccess(String summary, String detail) {
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
  }

  private void growlFailure(String summary, String detail) {
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
  }

  private String getMessage(String key) {
    if (messageBundle == null) {
      messageBundle = ResourceBundle.getBundle("messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
    }
    return messageBundle.getString(key);
  }

}
