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

import de.toabels.wmtipp.model.dto.CommunityDto;
import de.toabels.wmtipp.model.dto.PlayerContextDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.types.UserRoleType;
import de.toabels.wmtipp.services.api.ICommunityService;
import de.toabels.wmtipp.services.api.IPlayerContextService;
import de.toabels.wmtipp.services.api.IPlayerService;
import de.toabels.wmtipp.services.utiils.ISecurityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Controller class to manage CRUD operations on player objects
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 */
@Controller("playerEditCtrl")
@Scope("session")
public class PlayerEditController extends AbstractEditController<PlayerDto> {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private IPlayerService playerService;

    @Autowired
    private IPlayerContextService playerContextService;

    @Autowired
    private ICommunityService communityService;
    
    PlayerContextDto currentPlayerContext;

    private static final Logger logger = LoggerFactory.getLogger(PlayerEditController.class);

    /* Following methods should be implemented in a similar way by all child classes of AbstractEditController */
 /* Concrete implementation may vary depending on the subject of the edit page                              */
    /**
     * Init method calls super.init with specific service instance
     */
    @PostConstruct
    public void init() {
        super.init(playerService);
        currentPlayerContext = playerContextService.getNewObjectInstance();
    }

    /**
     * This getter serves as wrapper for the current subject object of the
     * abstract controller class
     *
     * @return current player dto
     */
    public PlayerDto getCurrentPlayer() {
        return super.getCurrentSubject();
    }

    /**
     * This getter serves as wrapper for the list selection of the abstract
     * controller class
     *
     * @return ordered list of players
     */
    public List<PlayerDto> getSelectionList() {
        return getSubjectList("name", "firstName");
    }

    @Override
    public void save() {
        if (currentSubject != null) {
            currentSubject.setPassword(securityService.getSaltedPassword(currentSubject.getPassword()));
            currentSubject = playerService.save(currentSubject);
            currentPlayerContext.setPlayer(currentSubject);
            playerContextService.save(currentPlayerContext);
            editMode = false;
            growlSuccess(getMessage("global_save_success"), getMessage("global_save_success_detail"));
        }
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

    public PlayerContextDto getCurrentPlayerContext() {
        return currentPlayerContext;
    }

    @Override
    public void clear(){
        super.clear();
        currentPlayerContext = playerContextService.getNewObjectInstance();
    }
    @Override
    protected void onCurrentSubjectChanged(){
        // refresh child context object when selected subject has changed
        if(currentSubject.getPlayerContext(null) != null){
            currentPlayerContext = currentSubject.getPlayerContext(null);
            currentPlayerContext = playerContextService.findById(currentPlayerContext.getId().intValue());
        }else{
            currentPlayerContext = playerContextService.getNewObjectInstance();
        }
    }
            
    public void setCurrentPlayerContext(PlayerContextDto currentPlayerContext) {
        this.currentPlayerContext = currentPlayerContext;
    }

    public List<CommunityDto> getComunities() {
        return communityService.listOrdered("name");
    }
}
