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
import de.toabels.wmtipp.services.api.IGenericBaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

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

  /* first initialization steps */
  public void init(IGenericBaseService service) {
    if (this.subjectService == null) {
      this.subjectService = service;
    }
    setNewSubjectInstance();
  }

  /* subject list for selection */
  protected List<D> getSubjectList(String... order) {
    if (subjectMap == null) {
      subjectList = subjectService.listOrdered(order);
      subjectMap = subjectList.stream().collect(Collectors.toMap(AbstractBaseDto::getId, p -> p));
    }
    return subjectList;
  }


  /* edit mode flag */
  public boolean isEditMode() {
    return editMode;
  }

  /* current subject of crod operations */
  public D getCurrentSubject() {
    return currentSubject;
  }

  public void setCurrentSubject(D subject) {
    this.currentSubject = subject;
  }

  /* CRUD actions */
  public void save() {
    if (currentSubject != null) {
      D result = (D) subjectService.save(currentSubject);
      subjectMap = null;
      editMode = false;
      growlSuccess(getMessage("global_save_success"), getMessage("global_save_success_detail"));
    }
  }

  public void delete() {
    if (currentSubject != null) {
      subjectService.delete(currentSubject);
      subjectMap = null;
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
