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

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO class representing a view object of tip entity
 *
 * @author abels
 */
@XmlRootElement
public class TipDto extends AbstractBaseDto {

  private PlayerDto player;

  private MatchDto match;

  private Integer goalsTeamOne;

  private Integer goalsTeamTwo;

  private Integer trend;

  private Integer playerScore;

  private Date createdAt;

  private Date updatedAt;

  public TipDto() {
  }

  public PlayerDto getPlayer() {
    return player;
  }

  public void setPlayer(PlayerDto player) {
    this.player = player;
  }

  public MatchDto getMatch() {
    return match;
  }

  public void setMatch(MatchDto match) {
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
    if (!(object instanceof TipDto)) {
      return false;
    }
    TipDto other = (TipDto) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.toabels.wmtipp.model.api.TipDto[ id=" + id + " ]";
  }
  
}
