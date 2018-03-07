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
import de.toabels.wmtipp.model.dto.CompetitionDto;
import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.RoundDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.services.api.ICommunityService;
import de.toabels.wmtipp.services.api.ICompetitionService;
import de.toabels.wmtipp.services.api.IGroupService;
import de.toabels.wmtipp.services.api.IMatchService;
import de.toabels.wmtipp.services.api.IPlayerService;
import de.toabels.wmtipp.services.api.IRoundService;
import de.toabels.wmtipp.services.api.ITeamService;
import de.toabels.wmtipp.web.infrastructure.UserSessionController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract base conroller class
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 */
public abstract class AbstractObjectController extends AbstractBaseController {

    private static final Logger logger = LoggerFactory.getLogger(AbstractObjectController.class);

    private ResourceBundle messageBundle;

    /* define lookup services for listboces in central spot */
    @Autowired
    private UserSessionController userSessionController;

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

    @Autowired
    private ICompetitionService competitionService;

    @Autowired
    private ICommunityService communityService;


    /* Subject specific selection lists */
    /**
     * List of matches for select box
     *
     * @return team list
     */
    public List<MatchDto> getMatchList() {
        return matchService.filterCompetition(matchService.listOrdered("startDate"), getCompetitionId());
    }

    /**
     * List of groups for select box
     *
     * @return team list
     */
    public List<GroupDto> getGroupList() {
        return groupService.filterCompetition(groupService.listOrdered("sortOrder"), getCompetitionId());
    }

    /**
     * List of rounds for select box
     *
     * @return team list
     */
    public List<RoundDto> getRoundList() {
        return roundService.filterCompetition(roundService.listOrdered("sortOrder nulls last"), getCompetitionId());
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
     * List of players for select box
     *
     * @param order - order of returned player list
     * @return player list
     */
    public List<PlayerDto> getPlayerListOrdered(String... order) {
        return playerService.listOrdered(order);
    }

    /**
     * List of teams for select box
     *
     * @return team list
     */
    public List<TeamDto> getTeamList() {
        return teamService.listOrdered("name");
    }

    /**
     * List of competitions for select box
     *
     * @return competition list
     */
    public List<CompetitionDto> getCompetitionList() {
        return competitionService.listOrdered("name");
    }

    /**
     * List of communities for select box
     *
     * @return community list
     */
    public List<CommunityDto> getCommunityList() {
        return communityService.listOrdered("name");
    }

    private Long getCompetitionId() {
        return userSessionController.getCurrentCompetition() != null 
            ? userSessionController.getCurrentCompetition().getId() : null;
    }

    private Long getCommunityId() {
        return userSessionController.getCurrentCommunity() != null 
            ? userSessionController.getCurrentCommunity().getId() : null;
    }

}
