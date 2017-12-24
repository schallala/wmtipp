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
package de.toabels.wmtipp.model.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abels
 */
@Entity
@Table(name = "team")
@XmlRootElement
public class Team implements IEntityBase<Team>, Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
  @ManyToOne
  @JoinColumn(name = "group_fk")
  private Group group;
  @Column(name = "matches_finished")
  private Integer matchesFinished;
  @Column(name = "points")
  private Integer points;
  @Column(name = "goals_scored")
  private Integer goalsScored;
  @Column(name = "goals_conceeded")
  private Integer goalsConceeded;
  @Column(name = "goal_difference")
  private Integer goalDifference;
  @Column(name = "url_info")
  private String urlInfo;
  @Column(name = "t_state")
  private Integer tournamentState;
  @Basic(optional = false)
  @Column(name = "t_won")
  private Boolean tournamentWon;
  @Column(name = "url_flag_image")
  private String urlFlagImage;
  @Basic(optional = false)
  @Column(name = "IS_NULL")
  private Boolean isNull;

  public Team() {
  }

  public Team(Long id) {
    this.id = id;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
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

  public Integer getTState() {
    return tournamentState;
  }

  public void setTState(Integer tState) {
    this.tournamentState = tState;
  }

  public Boolean getTWon() {
    return tournamentWon;
  }

  public void setTWon(Boolean tWon) {
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
    if (!(object instanceof Team)) {
      return false;
    }
    Team other = (Team) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.toabels.wmtipp.model.db.Team[ id=" + id + " ]";
  }
  
}
