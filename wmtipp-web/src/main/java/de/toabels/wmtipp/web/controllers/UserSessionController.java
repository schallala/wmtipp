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
import de.toabels.wmtipp.services.api.IPlayerService;
import de.toabels.wmtipp.services.utiils.ISecurityService;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("userSessionCtrl")
@Scope("session")
public class UserSessionController {

  @Autowired
  private IPlayerService playerService;

  @Autowired
  private ISecurityService securityService;

  private static final Logger logger = LoggerFactory.getLogger(UserSessionController.class);

  private String login;

  private String password;

  private PlayerDto currentUser;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public PlayerDto getCurrentUser() {
    return currentUser;
  }

  public String validateAndlogin() {
    currentUser = playerService.loginUser(login, securityService.getSaltedPassword(password));
    return "";
  }

  public String invalidateLogin() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    session.invalidate();
    currentUser = null;
    return "";
  }

}
