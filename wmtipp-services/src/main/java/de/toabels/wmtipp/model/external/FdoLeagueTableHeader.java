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
import java.util.Map;

/**
 *
 * @author abels
 */
public class FdoLeagueTableHeader {

    @JsonProperty("leagueCaption")
    private String leagueCaption;

    @JsonProperty("matchday")
    private Integer matchday;

    @JsonProperty("standings")
    private List<Object> standings;

    @JsonProperty("standing")
    private List<FdoLeagueTable> standing;

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public List<Object> getStandings() {
        return standings;
    }

    public void setStandings(List<Object> standings) {
        this.standings = standings;
    }

    public List<FdoLeagueTable> getStanding() {
        return standing;
    }

    public void setStanding(List<FdoLeagueTable> standing) {
        this.standing = standing;
    }

}
