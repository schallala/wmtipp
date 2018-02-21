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
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO class representing a view object of player entity
 *
 * @author abels
 */
@XmlRootElement
public class PlayerDto extends AbstractBaseDto {

    private String name;

    private String firstName;

    private String phone;

    private String email;

    private String password;

    private String login;

    private Date lastActivity;

    private List<PlayerContextDto> playerContext;

    public PlayerDto() {
    }

    public PlayerDto(Long id) {
        this();
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    /**
     * Convenience method to obtain context with given community
     * If communityId is null the first context is returned
     * @param communityId
     * @return player context in relation to community
     */
    public PlayerContextDto getPlayerContext(Long communityId) {
        for(PlayerContextDto context : getPlayerContext()){
            if(communityId == null ||  communityId.equals(context.getCommunity().getId())){
                return context;
            }
        }
        return null;
    }

    public List<PlayerContextDto> getPlayerContext() {
        return playerContext;
    }

    public void setPlayerContext(List<PlayerContextDto> playerContext) {
        this.playerContext = playerContext;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerDto)) {
            return false;
        }
        PlayerDto other = (PlayerDto) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "de.toabels.wmtipp.model.db.PlayerDto[  id=" + id + " ]";
    }

}
