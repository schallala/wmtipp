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

/**
 *
 * @author abels
 */
public class FdoCompetition {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("caption")
    private String caption;

    @JsonProperty("league")
    private String league;

    @JsonProperty("year")
    private Long year;

    @JsonProperty("currentMatchday")
    private Long currentMatchday;

    @JsonProperty("numberOfMatchdays")
    private Long numberOfMatchdays;

    @JsonProperty("numberOfTeams")
    private Long numberOfTeams;

    @JsonProperty("numberOfGames")
    private Long numberOfGames;

    @JsonProperty("lastUpdated")
    private String lastUpdated;

    public FdoCompetition clone() {
        FdoCompetition target = new FdoCompetition();
        target.caption = this.caption;
        target.currentMatchday = this.currentMatchday;
        target.id = this.id;
        target.lastUpdated = this.lastUpdated;
        target.league = this.league;
        target.numberOfGames = this.numberOfGames;
        target.numberOfMatchdays = this.numberOfMatchdays;
        target.numberOfTeams = this.numberOfTeams;
        target.year = this.year;
        return target;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(Long currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public Long getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public void setNumberOfMatchdays(Long numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
    }

    public Long getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(Long numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public Long getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(Long numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
