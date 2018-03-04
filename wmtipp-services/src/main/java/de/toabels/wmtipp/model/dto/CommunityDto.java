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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO class representing a view object of group entity
 *
 * @author abels
 */
@XmlRootElement
public class CommunityDto extends AbstractBaseDto {

    private String name;

    private String shortname;

    private String title;

    private Long scoreCorrectWinner;

    private Long scoreCorrectTip;

    private Long scoreCorrectTrend;
    
    private List<CompetitionDto> competitionList = new ArrayList<>();
    
    private Boolean autoGenerateMatches;

    private Boolean autoReleaseRounds;

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

    public List<CompetitionDto> getCompetitionList() {
        return competitionList;
    }

    public void setCompetitionList(List<CompetitionDto> competitionList) {
        this.competitionList = competitionList;
    }

    public Boolean getAutoGenerateMatches() {
        return autoGenerateMatches;
    }

    public void setAutoGenerateMatches(Boolean autoGenerateMatches) {
        this.autoGenerateMatches = autoGenerateMatches;
    }

    public Boolean getAutoReleaseRounds() {
        return autoReleaseRounds;
    }

    public void setAutoReleaseRounds(Boolean autoReleaseRounds) {
        this.autoReleaseRounds = autoReleaseRounds;
    }

    @Override
    public String toString() {
        return "de.toabels.wmtipp.model.api.CommunityDto[ id=" + id + " ]";
    }

}
