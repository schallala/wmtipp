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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abels
 */
@Entity
@Table(name = "tip")
@XmlRootElement
public class Tip implements IEntityBase<Tip>, Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Long id;
  @Basic(optional = false)
  @Column(name = "player_fk")
  private Player player;
  @Basic(optional = false)
  @Column(name = "match_fk")
  private Match match;
  @Column(name = "goals_teame_one")
  private Integer goalsTeamOne;
  @Column(name = "goals_team_two")
  private Integer goalsTeamTwo;
  @Column(name = "trend")
  private Integer trend;
  @Column(name = "player_score")
  private Integer playerScore;
  @Basic(optional = false)
  @Column(name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  @Basic(optional = false)
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  public Tip() {
  }

  public Tip(Long id) {
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

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Match getMatch() {
    return match;
  }

  public void setMatch(Match match) {
    this.match = match;
  }

  public Integer getGoalsTeamOne() {
    return goalsTeamOne;
  }

  public void setGoalsTeamOne(Integer goalsTeamOne) {
    this.goalsTeamOne = goalsTeamOne;
  }

  public Integer getGoalsTeamTwo() {
    return goalsTeamTwo;
  }

  public void setGoalsTeamTwo(Integer goalsTeamTwo) {
    this.goalsTeamTwo = goalsTeamTwo;
  }

  public Integer getTrend() {
    return trend;
  }

  public void setTrend(Integer trend) {
    this.trend = trend;
  }

  public Integer getPlayerScore() {
    return playerScore;
  }

  public void setPlayerScore(Integer playerScore) {
    this.playerScore = playerScore;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
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
    if (!(object instanceof Tip)) {
      return false;
    }
    Tip other = (Tip) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.toabels.wmtipp.model.db.Tip[ id=" + id + " ]";
  }
  
}
