/*
 * Copyright (C) 2018 abels
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
package de.toabels.wmtipp.services.utiils;

import de.toabels.wmtipp.model.external.FdoCompetition;
import de.toabels.wmtipp.model.external.FdoFixture;
import de.toabels.wmtipp.model.external.FdoLeagueTable;
import de.toabels.wmtipp.model.external.FdoTeam;
import java.util.List;

/**
 *
 * @author abels
 */
public interface IResultService {

    List<FdoCompetition> findCompetitionsByYear(String selectedYear);    
    
    List<FdoTeam> findTeamsByCompetition(String id);
    
    List<FdoFixture> findFixturesByCompetition(String id);
    
    List<FdoLeagueTable> findLeagueTable(String id);
}
