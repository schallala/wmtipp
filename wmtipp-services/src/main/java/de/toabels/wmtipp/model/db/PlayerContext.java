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

import de.toabels.wmtipp.model.types.UserRoleType;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "player_context")
@XmlRootElement
public class PlayerContext implements IEntityBase<PlayerContext>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "player_id")
    private Player player;
    
    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;
    
    @ManyToOne
    @JoinColumn(name = "predicted_champion")
    private Team predictedChampion;

    @Column(name = "fee_paid")
    private Boolean feePaid;

    @Column(name = "score")
    private Integer score;

    @Column(name = "correct_tips")
    private Integer correctTips;

    @Column(name = "correct_trends")
    private Integer correctTrends;

    @Basic(optional = false)
    @Column(name = "tips_visible")
    private Boolean tipsVisible;

    @Basic(optional = false)
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRoleType userRole;

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

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Team getPredictedChampion() {
        return predictedChampion;
    }

    public void setPredictedChampion(Team predictedChampion) {
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
        if (!(object instanceof PlayerContext)) {
            return false;
        }
        PlayerContext other = (PlayerContext) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.toabels.wmtipp.model.db.Group[ id=" + id + " ]";
    }

}
