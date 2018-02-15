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

import de.toabels.wmtipp.model.external.FdoCompetition;
import de.toabels.wmtipp.model.external.FdoFixture;
import de.toabels.wmtipp.model.external.FdoLeagueTable;
import de.toabels.wmtipp.services.utiils.IResultService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("footballDataListCtrl")
@Scope("session")
public class FootballDataListController {

    private static final Logger logger = LoggerFactory.getLogger(FootballDataListController.class);

    private List<FdoCompetition> competitions;

    private List<FdoFixture> fixtures;

    private List<FdoLeagueTable> teamTable;

    private String selectedYear;

    private String selectedCompetitionId;

    @Autowired
    private IResultService resultService;

    public List<FdoCompetition> getCompetitions() {
        return competitions;
    }

    public List<FdoFixture> getFixtures() {
        return fixtures;
    }

    public List<FdoLeagueTable> getTeamTable() {
        return teamTable;
    }

    public void setTeamTable(List<FdoLeagueTable> teamTable) {
        this.teamTable = teamTable;
    }

    
    public String getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }

    public String getSelectedCompetitionId() {
        return selectedCompetitionId;
    }

    public void setSelectedCompetitionId(String selectedCompetitionId) {
        this.selectedCompetitionId = selectedCompetitionId;
    }

    public void queryCompetitions() {
        if (selectedYear != null) {
            competitions = resultService.findCompetitionsByYear(selectedYear);
        }
    }

    public void queryFixtures() {
//        teams = resultService.findTeamsByCompetition(competitions.get(0).getId().toString());
        if (selectedCompetitionId != null) {
            logger.info("Query fixtures for competition " + selectedCompetitionId);
            fixtures = resultService.findFixturesByCompetition(selectedCompetitionId);
            logger.info("Query fixtures for competition " + selectedCompetitionId);
            teamTable = resultService.findLeagueTable(selectedCompetitionId);
            logger.info("Finished successfully!");
        }
    }
}
