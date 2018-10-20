/*
 * Copyright (C) 2018 abels
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
package de.toabels.wmtipp.services.utils.impl;

import de.toabels.wmtipp.model.dto.CommunityDto;
import de.toabels.wmtipp.model.dto.CompetitionDto;
import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.MessageDto;
import de.toabels.wmtipp.model.dto.NewsDto;
import de.toabels.wmtipp.model.dto.PlayerContextDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.RoundDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.model.dto.TipDto;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author abels
 */
public class DtoMock {

    public static GroupDto mockGroupDto(Long id, String name) {
        GroupDto mock = new GroupDto();
        mock.setId(id);
        mock.setName(name);
        mock.setSortOrder(10);
        mock.setCompetition(mockCompetitionDto(id + 1000, "Competition" + name));
        return mock;
    }

    public static CompetitionDto mockCompetitionDto(Long id, String name) {
        CompetitionDto mock = new CompetitionDto();
        mock.setId(id);
        mock.setName(name);
        mock.setExternalId("R2D2");
        mock.setFlagsPath("/dev/nul");
        mock.setImagePath("/tmp");
        mock.setShortname("Testcomp");
        mock.setTitle("Testtitle");
        mock.setPointsDraw(1L);
        mock.setPointsWin(3L);
        //TODO: 
//        mock.setCommunityList(communityList);
        return mock;
    }

    public static CommunityDto mockCommunityDto(Long id, String name) {
        CommunityDto mock = new CommunityDto();
        mock.setId(id);
        mock.setName(name);
        mock.setShortname("TestCom");
        mock.setTitle("TestComTitle");
        mock.setAutoGenerateMatches(Boolean.TRUE);
        mock.setAutoReleaseRounds(Boolean.TRUE);
        mock.setScoreCorrectTip(9L);
        mock.setScoreCorrectTrend(3L);
        mock.setScoreCorrectWinner(6L);
        // TODO: mock competition list
        // mock.setCompetitionList(competitionList);
        return mock;
    }

    public static RoundDto mockRoundDto(Long id, String name) {
        RoundDto mock = new RoundDto();
        mock.setId(id);
        mock.setName(name);
        mock.setSortOrder(11L);
        mock.setApproved(Boolean.TRUE);
        mock.setCompetition(mockCompetitionDto(id + 1000, "Competition" + name));
        return mock;
    }

    public static MessageDto mockMessageDto(Long id) {
        MessageDto mock = new MessageDto();
        mock.setId(id);
        Date now = new Date();
        mock.setCreatedAt(now);
        mock.setMessageRead(Boolean.TRUE);
        mock.setRecipient(mockPlayerDto(id + 1000, "Recipient"));
        mock.setSender(mockPlayerDto(id + 2000, "Sender"));
        mock.setSubject("My message subject");
        mock.setText("some message text");
        return mock;
    }

    public static PlayerDto mockPlayerDto(Long id, String name) {
        PlayerDto mock = new PlayerDto();
        mock.setId(id);
        mock.setFirstName("Ted");
        mock.setName(name);
        mock.setEmail("ted.tester@test.org");
        mock.setLogin("ted");
        mock.setPassword("password");
        mock.setPhone("+494931234567");
        mock.setPlayerContext(Arrays.asList(mockPlayerContext(id + 4000)));
        return mock;
    }

    public static PlayerContextDto mockPlayerContext(Long id) {
        PlayerContextDto mock = new PlayerContextDto();
        mock.setId(id);
        mock.setCommunity(mockCommunityDto(id + 3000, "Community"));
        mock.setCorrectTips(11);
        mock.setCorrectTrends(33);
        mock.setFeePaid(Boolean.FALSE);
        mock.setPredictedChampion(mockTeamDto(id + 4000, "Winner"));
//        mock.setPlayer(mockPlayerDto());
        return mock;
    }

    public static NewsDto mockNewsDto(Long id) {
        NewsDto mock = new NewsDto();
        mock.setId(id);
        mock.setCommunity(mockCommunityDto(id + 5000, "Community"));
        mock.setCreatedAt(new Date());
        mock.setSubject("My news subject");
        mock.setText("some news text");
        return mock;
    }

    public static TeamDto mockTeamDto(Long id, String name) {
        TeamDto mock = new TeamDto();
        mock.setId(id);
        mock.setName(name);
        mock.setGroup(mockGroupDto(id + 1000, "Group"));
        mock.setGoalDifference(6);
        mock.setGoalsConceeded(20);
        mock.setGoalsScored(26);
        mock.setMatchesFinished(12);
        mock.setPoints(18);
        mock.setTournamentWon(Boolean.FALSE);
        mock.setTournamentState(1);
        mock.setIsNull(Boolean.FALSE);
        mock.setUrlFlagImage("url/flags");
        mock.setUrlInfo("urls/info");
        return mock;
    }

    public static TipDto mockTipDto(Long id) {
        TipDto mock = new TipDto();
        mock.setId(id);
        mock.setCreatedAt(new Date());
        mock.setMatch(mockMatchDto(10L, "Some match"));
        mock.setPlayerContext(mockPlayerContext(100L));
        mock.setPlayerScore(3);
        mock.setTrend(1);
        mock.setUpdatedAt(new Date());
        mock.setGoalsTeamOne(2);
        mock.setGoalsTeamTwo(1);
        return mock;
    }

    public static MatchDto mockMatchDto(Long id, String name) {
        MatchDto mock = new MatchDto();
        mock.setId(id);
        mock.setName(name);
        mock.setTeamOne(mockTeamDto(1L, "One"));
        mock.setTeamTwo(mockTeamDto(2L, "Two"));
        mock.setCompetition(mockCompetitionDto(id + 6000, "Competition"));
        mock.setExternalId("1103L");
        mock.setGroup(mockGroupDto(id + 7000, "Group"));
        mock.setDescription("match description");
        mock.setRound(mockRoundDto(id + 8000, "Round"));
        mock.setAutoKnockoutGroupPosTeamOne(1L);
        mock.setAutoKnockoutGroupPosTeamTwo(2L);
        mock.setAutoKnockoutGroupTeamOne(10L);
        mock.setAutoKnockoutGroupTeamTwo(20L);
        mock.setAutoKnockoutMatchTeamOne(1000L);
        mock.setAutoKnockoutMatchTeamTwo(1001L);
        return mock;
    }

}
