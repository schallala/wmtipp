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
package de.toabels.wmtipp.model.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO class representing a view object of team entity
 *
 * @author abels
 */
@XmlRootElement
public class TeamDto extends AbstractBaseDto {

  private String name;

  private GroupDto group;

  private Integer matchesFinished;

  private Integer points;

  private Integer goalsScored;

  private Integer goalsConceeded;

  private Integer goalDifference;

  private String urlInfo;

  private Integer tournamentState;

  private Boolean tournamentWon;

  private String urlFlagImage;

  private Boolean isNull;

  public TeamDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GroupDto getGroup() {
    return group;
  }

  public void setGroup(GroupDto group) {
    this.group = group;
  }

  public Integer getMatchesFinished() {
    return matchesFinished;
  }

  public void setMatchesFinished(Integer matchesFinished) {
    this.matchesFinished = matchesFinished;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public Integer getGoalsScored() {
    return goalsScored;
  }

  public void setGoalsScored(Integer goalsScored) {
    this.goalsScored = goalsScored;
  }

  public Integer getGoalsConceeded() {
    return goalsConceeded;
  }

  public void setGoalsConceeded(Integer goalsConceeded) {
    this.goalsConceeded = goalsConceeded;
  }

  public Integer getGoalDifference() {
    return goalDifference;
  }

  public void setGoalDifference(Integer goalDifference) {
    this.goalDifference = goalDifference;
  }

  public String getUrlInfo() {
    return urlInfo;
  }

  public void setUrlInfo(String urlInfo) {
    this.urlInfo = urlInfo;
  }

  public Integer getTournamentState() {
    return tournamentState;
  }

  public void setTournamentState(Integer tState) {
    this.tournamentState = tState;
  }

  public Boolean getTournamentWon() {
    return tournamentWon;
  }

  public void setTournamentWon(Boolean tWon) {
    this.tournamentWon = tWon;
  }

  public String getUrlFlagImage() {
    return urlFlagImage;
  }

  public void setUrlFlagImage(String urlFlagImage) {
    this.urlFlagImage = urlFlagImage;
  }

  public Boolean getIsNull() {
    return isNull;
  }

  public void setIsNull(Boolean isNull) {
    this.isNull = isNull;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TeamDto)) {
      return false;
    }
    TeamDto other = (TeamDto) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.toabels.wmtipp.model.db.TeamDto[ id=" + id + " ]";
  }

}
