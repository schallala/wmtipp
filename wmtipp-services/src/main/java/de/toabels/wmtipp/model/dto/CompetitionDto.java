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
 * DTO class representing a view object of group entity
 *
 * @author abels
 */
@XmlRootElement
public class CompetitionDto extends AbstractBaseDto {

    private String externalId;
    private String name;
    private String shortname;
    private String title;
    private String imagePath;
    private String flagsPath;

    private Long pointsWin;
    private Long pointsDraw;

    private Integer sortOrder;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFlagsPath() {
        return flagsPath;
    }

    public void setFlagsPath(String flagsPath) {
        this.flagsPath = flagsPath;
    }

    public Long getPointsWin() {
        return pointsWin;
    }

    public void setPointsWin(Long pointsWin) {
        this.pointsWin = pointsWin;
    }

    public Long getPointsDraw() {
        return pointsDraw;
    }

    public void setPointsDraw(Long pointsDraw) {
        this.pointsDraw = pointsDraw;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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
        if (!(object instanceof CompetitionDto)) {
            return false;
        }
        CompetitionDto other = (CompetitionDto) object;
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
