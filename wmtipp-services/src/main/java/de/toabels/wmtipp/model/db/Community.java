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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abels
 */
@Entity
@Table(name = "community")
@XmlRootElement
public class Community implements IEntityBase<Community>, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "shortname")
    private String shortname;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @Column(name = "score_correct_winner")
    private Long scoreCorrectWinner;
    @Basic(optional = false)
    @Column(name = "score_correct_tip")
    private Long scoreCorrectTip;
    @Basic(optional = false)
    @Column(name = "score_correct_trend")
    private Long scoreCorrectTrend;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "community_player", joinColumns = {
        @JoinColumn(name = "COMMUNITY_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "PLAYER_ID",
                        nullable = false, updatable = false)})
    List<Player> playerList = new ArrayList<Player>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "community_competition", joinColumns = {
        @JoinColumn(name = "COMMUNITY_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "COMPETITION_ID",
                        nullable = false, updatable = false)})
    List<Competition> competitionList = new ArrayList<Competition>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getScoreCorrectWinner() {
        return scoreCorrectWinner;
    }

    public void setScoreCorrectWinner(Long scoreCorrectWinner) {
        this.scoreCorrectWinner = scoreCorrectWinner;
    }

    public Long getScoreCorrectTip() {
        return scoreCorrectTip;
    }

    public void setScoreCorrectTip(Long scoreCorrectTip) {
        this.scoreCorrectTip = scoreCorrectTip;
    }

    public Long getScoreCorrectTrend() {
        return scoreCorrectTrend;
    }

    public void setScoreCorrectTrend(Long scoreCorrectTrend) {
        this.scoreCorrectTrend = scoreCorrectTrend;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }

    public void setCompetitionList(List<Competition> competitionList) {
        this.competitionList = competitionList;
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
        if (!(object instanceof Community)) {
            return false;
        }
        Community other = (Community) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.toabels.wmtipp.model.db.BettingCommunity[ id=" + id + " ]";
    }

}
