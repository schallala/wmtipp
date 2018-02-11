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
package de.toabels.wmtipp.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author abels
 */
public class FdoTeamList {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("teams")
    private List<FdoTeam> teams;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<FdoTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<FdoTeam> teams) {
        this.teams = teams;
    }

}
