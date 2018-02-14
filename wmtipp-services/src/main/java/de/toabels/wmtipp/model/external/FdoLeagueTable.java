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
public class FdoLeagueTable {

    @JsonProperty("position")
    private Integer position;

    @JsonProperty("teamName")
    private String teamName;

    @JsonProperty("crestURI")
    private String crestURI;

    @JsonProperty("playedGames")
    private Integer playedGames;

    @JsonProperty("points")
    private Integer points;
 
    @JsonProperty("goals")
    private Integer goals;

    @JsonProperty("goalsAgainst")
    private Integer goalsAgainst;

    @JsonProperty("goalDifference")
    private Integer goalDifference;

    @JsonProperty("wins")
    private Integer wins;

    @JsonProperty("draws")
    private Integer draws;

    @JsonProperty("losses")
    private Integer losses;

//    @JsonProperty("home")
//    private Object home;
//    
//    @JsonProperty("away")
//    private Object away;

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

//    public Object getHome() {
//        return home;
//    }
//
//    public void setHome(Object home) {
//        this.home = home;
//    }
//
//    public Object getAway() {
//        return away;
//    }
//
//    public void setAway(Object away) {
//        this.away = away;
//    }


}
