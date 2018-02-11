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

import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.external.FdoCompetition;
import de.toabels.wmtipp.model.external.FdoTeam;
import de.toabels.wmtipp.services.api.IMatchService;
import de.toabels.wmtipp.services.utiils.IResultService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;

@Controller("matchListCtrl")
@Scope("session")
public class MatchListController {

    private static final Logger logger = LoggerFactory.getLogger(MatchListController.class);

    private List<String> panels = new ArrayList<String>();

    private List<FdoCompetition> competitions;

    private List<FdoTeam> teams;

    private String selectedYear;

    @Autowired
    private IResultService resultService;

    @Autowired
    private IMatchService matchService;

    public List<MatchDto> getMatchList() {
        return matchService.listOrdered("startDate");
    }

    public List<String> getPanels() {
        panels.add("Panel1");
        panels.add("Panel2");
        panels.add("Panel3");
        return panels;
    }

    public void setPanels(List<String> panels) {
        this.panels = panels;
    }

    public List<FdoCompetition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<FdoCompetition> competitions) {
        this.competitions = competitions;
    }

    public List<FdoTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<FdoTeam> teams) {
        this.teams = teams;
    }

    public String getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }

    public void testFootballData() {
        competitions = resultService.findCompetitionsByYear(selectedYear);
        teams = resultService.findTeamsByCompetition(competitions.get(0).getId().toString());
        resultService.findFixturesByCompetition("452");
    }
}
