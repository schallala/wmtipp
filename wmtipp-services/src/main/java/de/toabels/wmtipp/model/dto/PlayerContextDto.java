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

import de.toabels.wmtipp.model.types.UserRoleType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO class representing a view object of group entity
 *
 * @author abels
 */
@XmlRootElement
public class PlayerContextDto extends AbstractBaseDto {

    private PlayerDto player;

    private CommunityDto community;

    private CompetitionDto competition;

    private TeamDto predictedChampion;

    private Boolean feePaid;

    private Integer score;

    private Integer correctTips;

    private Integer correctTrends;

    private Boolean tipsVisible;

    private UserRoleType userRole;

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }

    public CommunityDto getCommunity() {
        return community;
    }

    public void setCommunity(CommunityDto community) {
        this.community = community;
    }

    public CompetitionDto getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionDto competition) {
        this.competition = competition;
    }

    public TeamDto getPredictedChampion() {
        return predictedChampion;
    }

    public void setPredictedChampion(TeamDto predictedChampion) {
        this.predictedChampion = predictedChampion;
    }

    public Boolean getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(Boolean feePaid) {
        this.feePaid = feePaid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCorrectTips() {
        return correctTips;
    }

    public void setCorrectTips(Integer correctTips) {
        this.correctTips = correctTips;
    }

    public Integer getCorrectTrends() {
        return correctTrends;
    }

    public void setCorrectTrends(Integer correctTrends) {
        this.correctTrends = correctTrends;
    }

    public Boolean getTipsVisible() {
        return tipsVisible;
    }

    public void setTipsVisible(Boolean tipsVisible) {
        this.tipsVisible = tipsVisible;
    }

    public UserRoleType getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleType userRole) {
        this.userRole = userRole;
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
        if (!(object instanceof PlayerContextDto)) {
            return false;
        }
        PlayerContextDto other = (PlayerContextDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.toabels.wmtipp.model.api.GroupDto[ id=" + id + " ]";
    }

}
