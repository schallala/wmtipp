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

import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.types.UserRoleType;
import de.toabels.wmtipp.services.api.IPlayerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

/**
 * Controller class to manage CRUD operations on player objects
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 */
@Controller("playerEditCtrl")
public class PlayerEditController extends AbstractEditController<PlayerDto> {

  @Autowired
  private IPlayerService playerService;

  private static final Logger logger = LoggerFactory.getLogger(PlayerEditController.class);

  /* Following methods should be implemented in a similar way by all child classes of AbstractEditController */
 /* Concrete implementation may vary depending on the subject of the edit page                              */
  /**
   * Init method calls super.init with specific service instance
   */
  @PostConstruct
  public void init() {
    super.init(playerService);
  }

  /**
   * This getter serves as wrapper for the current subject object of the abstract controller class
   *
   * @return current player dto
   */
  public PlayerDto getCurrentPlayer() {
    return super.getCurrentSubject();
  }

  /**
   * This getter serves as wrapper for the list selection of the abstract controller class
   *
   * @return ordered list of players
   */
  public List<PlayerDto> getSelectionList() {
    return getSubjectList("name", "firstName");
  }

  /* Subject specific selection lists */
  /**
   * Array of user roles known by the system
   *
   * @return array of roles
   */
  public UserRoleType[] getUserRoles() {
    return UserRoleType.values();
  }

}
