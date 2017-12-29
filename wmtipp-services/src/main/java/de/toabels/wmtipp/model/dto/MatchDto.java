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
 * DTO class representing a view object of match entity
 *
 * @author abels
 */
@XmlRootElement
public class MatchDto extends AbstractBaseDto {

  private String name;

  private RoundDto round;

  private GroupDto group;

  private TeamDto teamOne;

  private Integer goalsTeamOne;

  private TeamDto teamTwo;

  private Integer goalsTeamTwo;

  private Integer trend;

  private short status;

  private Long autoKnockoutMatchTeamOne;

  private Long autoKnockoutMatchTeamTwo;

  private Long autoKnockoutGroupTeamOne;

  private Long autoKnockoutGroupTeamTwo;

  private Long autoKnockoutGroupPosTeamOne;

  private Long autoKnockoutGroupPosTeamTwo;

  private String tickerUrl;

  private String tickerMatchId;

  private String description;

  private Date startDate;
  
  public MatchDto() {
  }

  public RoundDto getRound() {
    return round;
  }

  public void setRound(RoundDto round) {
    this.round = round;
  }

  public GroupDto getGroup() {
    return group;
  }

  public void setGroup(GroupDto group) {
    this.group = group;
  }

  public TeamDto getTeamOne() {
    return teamOne;
  }

  public void setTeamOne(TeamDto teamOne) {
    this.teamOne = teamOne;
  }

  public Integer getGoalsTeamOne() {
    return goalsTeamOne;
  }

  public void setGoalsTeamOne(Integer goalsTeamOne) {
    this.goalsTeamOne = goalsTeamOne;
  }

  public TeamDto getTeamTwo() {
    return teamTwo;
  }

  public void setTeamTwo(TeamDto teamTwo) {
    this.teamTwo = teamTwo;
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

  public short getStatus() {
    return status;
  }

  public void setStatus(short status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getAutoKnockoutMatchTeamOne() {
    return autoKnockoutMatchTeamOne;
  }

  public void setAutoKnockoutMatchTeamOne(Long autoKnockoutMatchTeamOne) {
    this.autoKnockoutMatchTeamOne = autoKnockoutMatchTeamOne;
  }

  public Long getAutoKnockoutMatchTeamTwo() {
    return autoKnockoutMatchTeamTwo;
  }

  public void setAutoKnockoutMatchTeamTwo(Long autoKnockoutMatchTeamTwo) {
    this.autoKnockoutMatchTeamTwo = autoKnockoutMatchTeamTwo;
  }

  public Long getAutoKnockoutGroupTeamOne() {
    return autoKnockoutGroupTeamOne;
  }

  public void setAutoKnockoutGroupTeamOne(Long autoKnockoutGroupTeamOne) {
    this.autoKnockoutGroupTeamOne = autoKnockoutGroupTeamOne;
  }

  public Long getAutoKnockoutGroupTeamTwo() {
    return autoKnockoutGroupTeamTwo;
  }

  public void setAutoKnockoutGroupTeamTwo(Long autoKnockoutGroupTeamTwo) {
    this.autoKnockoutGroupTeamTwo = autoKnockoutGroupTeamTwo;
  }

  public Long getAutoKnockoutGroupPosTeamOne() {
    return autoKnockoutGroupPosTeamOne;
  }

  public void setAutoKnockoutGroupPosTeamOne(Long autoKnockoutGroupPosTeamOne) {
    this.autoKnockoutGroupPosTeamOne = autoKnockoutGroupPosTeamOne;
  }

  public Long getAutoKnockoutGroupPosTeamTwo() {
    return autoKnockoutGroupPosTeamTwo;
  }

  public void setAutoKnockoutGroupPosTeamTwo(Long autoKnockoutGroupPosTeamTwo) {
    this.autoKnockoutGroupPosTeamTwo = autoKnockoutGroupPosTeamTwo;
  }

  public String getTickerUrl() {
    return tickerUrl;
  }

  public void setTickerUrl(String tickerUrl) {
    this.tickerUrl = tickerUrl;
  }

  public String getTickerMatchId() {
    return tickerMatchId;
  }

  public void setTickerMatchId(String tickerMatchId) {
    this.tickerMatchId = tickerMatchId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Boolean getAutoConfiguration() {
    return this.autoKnockoutGroupTeamOne != null || this.autoKnockoutMatchTeamOne != null
            || this.autoKnockoutGroupTeamOne != null || this.autoKnockoutMatchTeamOne != null;
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
    if (!(object instanceof MatchDto)) {
      return false;
    }
    MatchDto other = (MatchDto) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.toabels.wmtipp.model.db.MatchDto[ id=" + id + " ]";
  }
  
}
