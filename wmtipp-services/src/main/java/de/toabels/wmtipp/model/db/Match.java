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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abels
 */
@Entity
@Table(name = "t_match")
@XmlRootElement
public class Match implements IEntityBase<Match>, Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
  @ManyToOne
  @JoinColumn(name = "round_fk")
  private Round round;
  @ManyToOne
  @JoinColumn(name = "group_fk")
  private Group group;
  @ManyToOne
  @JoinColumn(name = "team_one_fk")
  private Team teamOne;
  @Column(name = "goals_team_one")
  private Integer goalsTeamOne;
  @ManyToOne
  @JoinColumn(name = "team_two_fk")
  private Team teamTwo;
  @Column(name = "goals_team_two")
  private Integer goalsTeamTwo;
  @Column(name = "trend")
  private Integer trend;
  @Basic(optional = false)
  @Column(name = "Status")
  private short status;
  @Column(name = "auto_knockout_team_one_fk")
  private Long autoKnockoutMatchTeamOne;
  @Column(name = "auto_knockout_team_two_fk")
  private Long autoKnockoutMatchTeamTwo;
  @Column(name = "auto_knockout_group_team_one_fk")
  private Long autoKnockoutGroupTeamOne;
  @Column(name = "auto_knockout_group_team_two_fk")
  private Long autoKnockoutGroupTeamTwo;
  @Column(name = "auto_knockout_pos_team_one_fk")
  private Long autoKnockoutGroupPosTeamOne;
  @Column(name = "auto_knockout_pos_team_two_fk")
  private Long autoKnockoutGroupPosTeamTwo;
  @Column(name = "ticker_url")
  private String tickerUrl;
  @Column(name = "ticker_match_id")
  private String tickerMatchId;
  @Column(name = "description")
  private String description;
  @Basic(optional = false)
  @Column(name = "start_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date startDate;

  public Match() {
  }

  public Match(Long id) {
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

  public Round getRound() {
    return round;
  }

  public void setRound(Round round) {
    this.round = round;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Team getTeamOne() {
    return teamOne;
  }

  public void setTeamOne(Team teamOne) {
    this.teamOne = teamOne;
  }

  public Integer getGoalsTeamOne() {
    return goalsTeamOne;
  }

  public void setGoalsTeamOne(Integer goalsTeamOne) {
    this.goalsTeamOne = goalsTeamOne;
  }

  public Team getTeamTwo() {
    return teamTwo;
  }

  public void setTeamTwo(Team teamTwo) {
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Match)) {
      return false;
    }
    Match other = (Match) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.toabels.wmtipp.model.db.Match[ id=" + id + " ]";
  }
  
}
