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

import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.TipDto;
import de.toabels.wmtipp.services.api.ITipService;
import de.toabels.wmtipp.web.infrastructure.UserSessionController;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Controller class to manage CRUD operations on round objects
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 */
@Controller("tipEditCtrl")
@Scope("session")
public class TipEditController extends AbstractEditController<TipDto> {

    @Autowired
    ITipService tipService;

    @Autowired
    UserSessionController userSession;

    List<TipDto> tipList;

    Long selectedPlayerId;

    private final Map<Long, List<MatchDto>> roundMatchListMap = new HashMap<>();

    private final Map<Long, List<GroupDto>> roundGroupListMap = new HashMap<>();

    private final Map<Long, List<MatchDto>> groupMatchListMap = new HashMap<>();

    private Map<Long, TipDto> matchTipMap = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(TipEditController.class);

    /* Following methods should be implemented in a similar way by all child classes of AbstractEditController */
 /* Concrete implementation may vary depending on the subject of the edit page                              */
    /**
     * Init method calls super.init with specific service instance
     */
    @PostConstruct
    public void init() {
        super.init(tipService);
    }

    private void initMaps() {
        List<GroupDto> roundGroupList;

        // init mapping of groups to rounds, matches to group, matches to round
        for (MatchDto match : getMatchList()) {
            if (match.getGroup().getId() != null) {
                roundGroupListMap.put(match.getRound().getId(), new ArrayList<>());
                groupMatchListMap.put(match.getGroup().getId(), new ArrayList<>());
            } else {
                roundMatchListMap.put(match.getRound().getId(), new ArrayList<>());
            }
        }

        for (MatchDto match : getMatchList()) {
            if (match.getGroup().getId() != null) {
                roundGroupList = roundGroupListMap.get(match.getRound().getId());
                if (!roundGroupList.contains(match.getGroup())) {
                    roundGroupListMap.get(match.getRound().getId()).add(match.getGroup());
                }
                groupMatchListMap.get(match.getGroup().getId()).add(match);
            } else {
                roundMatchListMap.get(match.getRound().getId()).add(match);
            }
        }
        tipList = tipService.findByPlayerId(selectedPlayerId);
        matchTipMap = tipList.stream().collect(Collectors.toMap(p -> p.getMatch().getId(), p -> p));
        logger.info("Maps initialized!");
    }

    public Map<Long, List<GroupDto>> getRoundGroupListMap() {
        return roundGroupListMap;
    }

    public Map<Long, List<MatchDto>> getGroupMatchListMap() {
        return groupMatchListMap;
    }

    public Map<Long, List<MatchDto>> getRoundMatchListMap() {
        return roundMatchListMap;
    }

    public Map<Long, TipDto> getMatchTipMap() {
        return matchTipMap;
    }

    public List<TipDto> getTipList() {
        tipList = tipService.findByPlayerId(selectedPlayerId);
        matchTipMap = tipList.stream().collect(Collectors.toMap(p -> p.getMatch().getId(), p -> p));
        logger.info("Maps initialized!");
        return tipList;
    }

    /* Player selection stuff */
    public Long getSelectedPlayerId() {
        // preselect logged in user
        if (selectedPlayerId == null && userSession.getCurrentUser() != null) {
            selectedPlayerId = userSession.getCurrentUser().getId();
            onPlayerSelected();
        }
        return selectedPlayerId;
    }

    public void setSelectedPlayerId(Long selectedPlayerId) {
        this.selectedPlayerId = selectedPlayerId;
    }

    public void onPlayerSelected() {
        initMaps();
        logger.info("New player selected: " + getSelectedPlayer());
    }

    public PlayerDto getSelectedPlayer() {
        return getPlayerList().stream().collect(Collectors.toMap(PlayerDto::getId, p -> p)).get(selectedPlayerId);
    }

    @Override
    public void saveList() {
        logger.info("Save tip list ...");
        setSubjectList(tipList);
        tipService.saveList(tipList);
    }

}
