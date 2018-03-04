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
package de.toabels.wmtipp.services.utiils.impl;

import de.toabels.wmtipp.model.db.Community;
import de.toabels.wmtipp.model.db.Competition;
import de.toabels.wmtipp.model.dto.AbstractBaseDto;
import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.db.Group;
import de.toabels.wmtipp.model.db.IEntityBase;
import de.toabels.wmtipp.model.db.Match;
import de.toabels.wmtipp.model.db.Message;
import de.toabels.wmtipp.model.db.News;
import de.toabels.wmtipp.model.db.Player;
import de.toabels.wmtipp.model.db.PlayerContext;
import de.toabels.wmtipp.model.db.Round;
import de.toabels.wmtipp.model.db.Team;
import de.toabels.wmtipp.model.db.Tip;
import de.toabels.wmtipp.model.dto.CommunityDto;
import de.toabels.wmtipp.model.dto.CompetitionDto;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.MessageDto;
import de.toabels.wmtipp.model.dto.NewsDto;
import de.toabels.wmtipp.model.dto.PlayerContextDto;
import de.toabels.wmtipp.model.dto.RoundDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.model.dto.TipDto;
import de.toabels.wmtipp.services.utiils.IMappingService;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author abels
 * @param <D>
 * @param <E>
 */
@Service
public class MappingServiceImpl<D extends AbstractBaseDto, E extends IEntityBase<E>> implements IMappingService<D, E> {

    /**
     * Dispatcher method to invoke specific mapper method of entity object to
     * DTO object
     *
     * @param entity - database object
     * @return DTO object
     */
    @Override
    public D map(E entity) {
        if (entity == null) {
            return null;
        }
        if (entity instanceof Competition) {
            return (D) map((Competition) entity);
        }
        if (entity instanceof Community) {
            return (D) map((Community) entity);
        }
        if (entity instanceof PlayerContext) {
            return (D) map((PlayerContext) entity);
        }
        if (entity instanceof Player) {
            return (D) map((Player) entity);
        }
        if (entity instanceof Match) {
            return (D) map((Match) entity);
        }
        if (entity instanceof Group) {
            return (D) map((Group) entity);
        }
        if (entity instanceof Message) {
            return (D) map((Message) entity);
        }
        if (entity instanceof News) {
            return (D) map((News) entity);
        }
        if (entity instanceof Round) {
            return (D) map((Round) entity);
        }
        if (entity instanceof Team) {
            return (D) map((Team) entity);
        }
        if (entity instanceof Tip) {
            return (D) map((Tip) entity);
        }
        return null;
    }

    /**
     * Dispatcher method to invoke specific mapper method of DTO object to
     * entity object
     *
     * @param dto
     * @return
     */
    @Override
    public E map(D dto) {
        if (dto == null) {
            return null;
        }
        if (dto instanceof CompetitionDto) {
            return (E) map((CompetitionDto) dto);
        }
        if (dto instanceof CommunityDto) {
            return (E) map((CommunityDto) dto);
        }
        if (dto instanceof PlayerContextDto) {
            return (E) map((PlayerContextDto) dto);
        }
        if (dto instanceof PlayerDto) {
            return (E) map((PlayerDto) dto);
        }
        if (dto instanceof GroupDto) {
            return (E) map((GroupDto) dto);
        }
        if (dto instanceof MatchDto) {
            return (E) map((MatchDto) dto);
        }
        if (dto instanceof MessageDto) {
            return (E) map((MessageDto) dto);
        }
        if (dto instanceof NewsDto) {
            return (E) map((NewsDto) dto);
        }
        if (dto instanceof RoundDto) {
            return (E) map((RoundDto) dto);
        }
        if (dto instanceof TeamDto) {
            return (E) map((TeamDto) dto);
        }
        if (dto instanceof TipDto) {
            return (E) map((TipDto) dto);
        }
        return null;
    }

    /* Individual implementation of DTO/entity mappings
     */
    /**
     * Map Competition entity -> Competition DTO
     *
     * @param competition - entity
     * @return Competition DTO
     */
    private CompetitionDto map(Competition competition) {
        CompetitionDto dto = new CompetitionDto();
        if (competition == null) {
            return dto;
        }
        dto.setId(competition.getId());
        dto.setExternalId(competition.getExternalId());
        dto.setName(competition.getName());
        dto.setShortname(competition.getShortname());
        dto.setTitle(competition.getTitle());
        dto.setImagePath(competition.getImagePath());
        dto.setFlagsPath(competition.getFlagsPath());
        dto.setPointsWin(competition.getPointsWin());
        dto.setPointsDraw(competition.getPointsDraw());
        dto.setSortOrder(competition.getSortOrder());
//        if(competition.getCommunityList() != null && !competition.getCommunityList().isEmpty()){
//            dto.setCommunityList(new ArrayList<>());
//            for(Community community : competition.getCommunityList()){
//                dto.getCommunityList().add(mapReference(community));
//            }
//        }
        return dto;
    }

    private CompetitionDto mapReference(Competition competition) {
        CompetitionDto dto = new CompetitionDto();
        if (competition == null) {
            return dto;
        }
        dto.setId(competition.getId());
        return dto;
    }
    
    /**
     * Map Competition DTO -> Competition entity
     *
     * @param dto - competition dto
     * @return Competition entity
     */
    private Competition map(CompetitionDto dto) {
        if (dto == null) {
            return null;
        }
        Competition competition = new Competition();
        competition.setId(dto.getId());
        competition.setExternalId(dto.getExternalId());
        competition.setName(dto.getName());
        competition.setShortname(dto.getShortname());
        competition.setTitle(dto.getTitle());
        competition.setImagePath(dto.getImagePath());
        competition.setFlagsPath(dto.getFlagsPath());
        competition.setPointsWin(dto.getPointsWin());
        competition.setPointsDraw(dto.getPointsDraw());
        competition.setSortOrder(dto.getSortOrder());
//        competition.setSortOrder(dto.getSortOrder());
//        if (dto.getCommunityList() != null && !dto.getCommunityList().isEmpty()) {
//            competition.setCommunityList(new ArrayList<>());
//            for (CommunityDto community : dto.getCommunityList()) {
//                competition.getCommunityList().add(mapReference(community));
//            }
//        }
        return competition;
    }
    
    private Competition mapReference(CompetitionDto dto) {
        if (dto == null) {
            return null;
        }
        Competition competition = new Competition();
        competition.setId(dto.getId());
        return competition;
    }

    /**
     * Map Community entity -> Community DTO
     *
     * @param community - entity
     * @return Community DTO
     */
    private CommunityDto map(Community community) {
        CommunityDto dto = new CommunityDto();
        if (community == null) {
            return dto;
        }
        dto.setId(community.getId());
        dto.setName(community.getName());
        dto.setShortname(community.getShortname());
        dto.setTitle(community.getTitle());
        dto.setScoreCorrectWinner(community.getScoreCorrectWinner());
        dto.setScoreCorrectTip(community.getScoreCorrectTip());
        dto.setScoreCorrectTrend(community.getScoreCorrectTrend());
        dto.setAutoGenerateMatches(community.getAutoGenerateMatches());
        dto.setAutoReleaseRounds(community.getAutoReleaseRounds());        
        if(community.getCompetitionList() != null && !community.getCompetitionList().isEmpty()){
            dto.setCompetitionList(new ArrayList<>());
            for(Competition competition : community.getCompetitionList()){
                dto.getCompetitionList().add(mapReference(competition));
            }
        }
        return dto;
    }

    /**
     * Map Community entity -> Community DTO
     *
     * @param community - entity
     * @return Community DTO
     */
    private CommunityDto mapReference(Community community) {
        CommunityDto dto = new CommunityDto();
        if (community == null) {
            return dto;
        }
        dto.setId(community.getId());
        return dto;
    }

    /**
     * Map Community DTO -> Community entity
     *
     * @param dto - community dto
     * @return Community entity
     */
    private Community map(CommunityDto dto) {
        if (dto == null) {
            return null;
        }
        Community community = new Community();
        community.setId(dto.getId());
        community.setName(dto.getName());
        community.setShortname(dto.getShortname());
        community.setTitle(dto.getTitle());
        community.setScoreCorrectWinner(dto.getScoreCorrectWinner());
        community.setScoreCorrectTip(dto.getScoreCorrectTip());
        community.setScoreCorrectTrend(dto.getScoreCorrectTrend());
        community.setAutoGenerateMatches(dto.getAutoGenerateMatches());
        community.setAutoReleaseRounds(dto.getAutoReleaseRounds());
        if (dto.getCompetitionList() != null && !dto.getCompetitionList().isEmpty()) {
            community.setCompetitionList(new ArrayList<>());
            for (CompetitionDto competition : dto.getCompetitionList()) {
                community.getCompetitionList().add(mapReference(competition));
            }
        }
        return community;
    }

    /**
     * Map Community DTO -> Community entity
     *
     * @param dto - community dto
     * @return Community entity
     */
    private Community mapReference(CommunityDto dto) {
        if (dto == null) {
            return null;
        }
        Community community = new Community();
        community.setId(dto.getId());
        return community;
    }
        
        /**
     * Map PlayerContext entity -> PlayerContext DTO
     *
     * @param playerContext - entity
     * @return PlayerContext DTO
     */
    private PlayerContextDto map(PlayerContext playerContext) {
        PlayerContextDto dto = new PlayerContextDto();
        if (playerContext == null) {
            return dto;
        }
        dto.setId(playerContext.getId());
        dto.setPlayer(mapReference(playerContext.getPlayer()));
        dto.setCommunity(mapReference(playerContext.getCommunity()));
        dto.setCorrectTips(playerContext.getCorrectTips());
        dto.setCorrectTrends(playerContext.getCorrectTrends());
        dto.setFeePaid(playerContext.getFeePaid());
        dto.setScore(playerContext.getScore());
        dto.setTipsVisible(playerContext.getTipsVisible());
        dto.setUserRole(playerContext.getUserRole());
        dto.setPredictedChampion(map(playerContext.getPredictedChampion()));
        return dto;
    }

    private PlayerContextDto mapReference(PlayerContext playerContext) {
        PlayerContextDto dto = new PlayerContextDto();
        if (playerContext == null) {
            return dto;
        }
        dto.setId(playerContext.getId());
        return dto;
    }

    /**
     * Map reference PlayerContext DTO -> PlayerContext entity
     *
     * @param dto - playerContext dto
     * @return PlayerContext entity
     */
    private PlayerContext map(PlayerContextDto dto) {
        if (dto == null) {
            return null;
        }
        PlayerContext playerContext = new PlayerContext();
        playerContext.setId(dto.getId());
        playerContext.setPlayer(map(dto.getPlayer()));
        playerContext.setCommunity(map(dto.getCommunity()));
        playerContext.setCorrectTips(dto.getCorrectTips());
        playerContext.setCorrectTrends(dto.getCorrectTrends());
        playerContext.setFeePaid(dto.getFeePaid());
        playerContext.setScore(dto.getScore());
        playerContext.setTipsVisible(dto.getTipsVisible());
        playerContext.setUserRole(dto.getUserRole());
        playerContext.setPredictedChampion(map(dto.getPredictedChampion()));
        return playerContext;
    }

    /**
     * Map Group entity -> Group DTO
     *
     * @param group - entity
     * @return Group DTO
     */
    private GroupDto map(Group group) {
        GroupDto dto = new GroupDto();
        if (group == null) {
            return dto;
        }
        dto.setId(group.getId());
        dto.setCompetition(mapReference(group.getCompetition()));
        dto.setName(group.getName());
        dto.setSortOrder(group.getSortOrder());
        return dto;
    }

    /**
     * Map Group DTO -> Group entity
     *
     * @param dto - group dto
     * @return Group entity
     */
    private Group map(GroupDto dto) {
        if (dto == null) {
            return null;
        }
        Group group = new Group();
        group.setId(dto.getId());
        group.setCompetition(mapReference(dto.getCompetition()));
        group.setName(dto.getName());
        group.setSortOrder(dto.getSortOrder());
        return group;
    }

    /**
     * Map reference Group DTO -> Group entity
     *
     * @param dto - group dto
     * @return Group entity
     */
    private Group mapReference(GroupDto dto) {
        if (dto == null || dto.getId() == null) {
            return null;
        }
        Group group = new Group();
        group.setId(dto.getId());
        group.setName(dto.getName());
        group.setSortOrder(dto.getSortOrder());
        return group;
    }

    /**
     * Map Round entity -> Round DTO
     *
     * @param round - entity
     * @return Round DTO
     */
    private RoundDto map(Round round) {
        RoundDto dto = new RoundDto();
        if (round == null) {
            return dto;
        }
        dto.setId(round.getId());
        dto.setCompetition(mapReference(round.getCompetition()));
        dto.setName(round.getName());
        dto.setSortOrder(round.getSortOrder());
        dto.setApproved(round.getApproved());
        return dto;
    }

    /**
     * Map Round DTo -> Round entity
     *
     * @param dto - round dto
     * @return Round entity
     */
    private Round map(RoundDto dto) {
        if (dto == null) {
            return null;
        }
        Round round = new Round();
        round.setId(dto.getId());
        round.setCompetition(mapReference(dto.getCompetition()));
        round.setName(dto.getName());
        round.setSortOrder(dto.getSortOrder());
        round.setApproved(dto.getApproved());
        return round;
    }

    /**
     * Map reference Round DTO -> Round entity
     *
     * @param dto - round dto
     * @return Round entity
     */
    private Round mapReference(RoundDto dto) {
        if (dto == null || dto.getId() == null) {
            return null;
        }
        Round round = new Round();
        round.setId(dto.getId());
        round.setName(dto.getName());
        round.setSortOrder(dto.getSortOrder());
        round.setApproved(dto.getApproved());
        return round;
    }

    /**
     * Map News entity -> News DTO
     *
     * @param news - entity
     * @return News DTO
     */
    private NewsDto map(News news) {
        NewsDto dto = new NewsDto();
        if (news == null) {
            return dto;
        }
        dto.setId(news.getId());
        dto.setSubject(news.getSubject());
        dto.setText(news.getText());
        dto.setCommunity(map(news.getCommunity()));
        dto.setCreatedAt(news.getCreatedAt());
        return dto;
    }

    /**
     * Map News DTO -> News entity
     *
     * @param dto - news dto
     * @return News entity
     */
    private News map(NewsDto dto) {
        if (dto == null) {
            return null;
        }
        News news = new News();
        news.setId(dto.getId());
        news.setSubject(dto.getSubject());
        news.setText(dto.getText());
        news.setCommunity(map(dto.getCommunity()));
        news.setCreatedAt(dto.getCreatedAt());
        return news;
    }

    /**
     * Map Message entity -> Message DTO
     *
     * @param message - entity
     * @return Message dto
     */
    private MessageDto map(Message message) {
        if (message == null) {
            return null;
        }
        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setCreatedAt(message.getCreatedAt());
        dto.setMessageRead(message.getMessageRead());
        dto.setRecipient(new PlayerDto(message.getRecipient().getId()));
        dto.setSender(new PlayerDto(message.getSender().getId()));
        dto.setText(message.getText());
        dto.setSubject(message.getSubject());
        return dto;
    }

    /**
     * Map Message DTO -> Message entity
     *
     * @param dto - message dto
     * @return Message entity
     */
    private Message map(MessageDto dto) {
        if (dto == null) {
            return null;
        }
        Message message = new Message();
        message.setId(dto.getId());
        message.setCreatedAt(dto.getCreatedAt());
        message.setMessageRead(dto.getMessageRead());
        message.setRecipient(mapReference(dto.getRecipient()));
        message.setSender(mapReference(dto.getSender()));
        message.setText(dto.getText());
        message.setSubject(dto.getSubject());
        return message;
    }

    /**
     * Map Match entity -> Match DTO
     *
     * @param match - entity
     * @return Match DTO
     */
    private MatchDto map(Match match) {
        if (match == null) {
            return null;
        }
        MatchDto dto = mapCore(match);
        dto.setTeamOne(mapReference(match.getTeamOne()));
        dto.setTeamTwo(mapReference(match.getTeamTwo()));
        return dto;
    }

    private MatchDto mapReference(Match match) {
        if (match == null) {
            return new MatchDto();
        }
        return mapCore(match);
    }

    private MatchDto mapCore(Match match) {
        MatchDto dto = new MatchDto();
        dto.setId(match.getId());
        dto.setExternalId(match.getExternalId());
        dto.setCompetition(map(match.getCompetition()));
        dto.setName(match.getName());
        dto.setDescription(match.getDescription());
        dto.setGoalsTeamOne(match.getGoalsTeamOne());
        dto.setGoalsTeamTwo(match.getGoalsTeamTwo());
        dto.setGroup(map(match.getGroup()));
        dto.setRound(map(match.getRound()));
        dto.setStartDate(match.getStartDate());
        dto.setStatus(match.getStatus());
        dto.setTickerMatchId(match.getTickerMatchId());
        dto.setTickerUrl(match.getTickerUrl());
        dto.setAutoKnockoutGroupTeamOne(match.getAutoKnockoutGroupTeamOne());
        dto.setAutoKnockoutGroupTeamTwo(match.getAutoKnockoutGroupTeamTwo());
        dto.setAutoKnockoutGroupPosTeamOne(match.getAutoKnockoutGroupPosTeamOne());
        dto.setAutoKnockoutGroupPosTeamTwo(match.getAutoKnockoutGroupPosTeamTwo());
        dto.setAutoKnockoutMatchTeamOne(match.getAutoKnockoutMatchTeamOne());
        dto.setAutoKnockoutMatchTeamTwo(match.getAutoKnockoutMatchTeamTwo());
        dto.setTeamOne(mapReference(match.getTeamOne()));
        dto.setTeamTwo(mapReference(match.getTeamTwo()));
        return dto;
    }

    /**
     * Map Match DTO -> Match entity
     *
     * @param dto - match DTO
     * @return match entity
     */
    private Match map(MatchDto dto) {
        if (dto == null) {
            return null;
        }
        Match match = new Match();
        match.setId(dto.getId());
        match.setExternalId(dto.getExternalId());
        match.setCompetition(map(dto.getCompetition()));
        match.setName(dto.getName());
        match.setDescription(dto.getDescription());
        match.setGoalsTeamOne(dto.getGoalsTeamOne());
        match.setGoalsTeamTwo(dto.getGoalsTeamTwo());
        match.setGroup(mapReference(dto.getGroup()));
        match.setRound(mapReference(dto.getRound()));
        match.setStartDate(dto.getStartDate());
        match.setStatus(dto.getStatus());
        match.setTickerMatchId(dto.getTickerMatchId());
        match.setTickerUrl(dto.getTickerUrl());
        match.setTeamOne(mapReference(dto.getTeamOne()));
        match.setTeamTwo(mapReference(dto.getTeamTwo()));
        match.setAutoKnockoutGroupTeamOne(dto.getAutoKnockoutGroupTeamOne());
        match.setAutoKnockoutGroupTeamTwo(dto.getAutoKnockoutGroupTeamTwo());
        match.setAutoKnockoutGroupPosTeamOne(dto.getAutoKnockoutGroupPosTeamOne());
        match.setAutoKnockoutGroupPosTeamTwo(dto.getAutoKnockoutGroupPosTeamTwo());
        match.setAutoKnockoutMatchTeamOne(dto.getAutoKnockoutMatchTeamOne());
        match.setAutoKnockoutMatchTeamTwo(dto.getAutoKnockoutMatchTeamTwo());
        return match;
    }

    /**
     * Map reference Match DTO -> Match entity
     *
     * @param dto - match DTO
     * @return match entity
     */
    private Match mapReference(MatchDto dto) {
        if (dto == null || dto.getId() == null) {
            return null;
        }
        Match match = new Match();
        match.setId(dto.getId());
        return match;
    }

    /**
     * Map Player entity -> Player DTO
     *
     * @param player - entity
     * @return Player DTO
     */
    private PlayerDto map(Player player) {
        if (player == null) {
            return null;
        }
        PlayerDto dto = mapCore(player);
        dto.setPlayerContext(new ArrayList<>());
        for (PlayerContext context : player.getPlayerContext()) {
            dto.getPlayerContext().add(map(context));
        }
        return dto;
    }

    private PlayerDto mapReference(Player player) {
        if (player == null) {
            return new PlayerDto();
        }
        return mapCore(player);
    }

    private PlayerDto mapCore(Player player) {
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setFirstName(player.getFirstName());
        dto.setEmail(player.getEmail());
        dto.setLogin(player.getLogin());
        dto.setLastActivity(player.getLastActivity());
        dto.setPassword(player.getPassword());
        dto.setPhone(player.getPhone());
         return dto;
    }

    /**
     * Map Player DTO -> Player entity
     *
     * @param dto - player DTO
     * @return Player entity
     */
    private Player map(PlayerDto dto) {
        if (dto == null) {
            return null;
        }
        Player player = new Player();
        player.setId(dto.getId());
        player.setName(dto.getName());
        player.setFirstName(dto.getFirstName());
        player.setEmail(dto.getEmail());
        player.setLogin(dto.getLogin());
        player.setLastActivity(dto.getLastActivity());
        player.setPassword(dto.getPassword());
        player.setPhone(dto.getPhone());
        player.setPlayerContext(new ArrayList<>());
//        for(PlayerContextDto context : dto.getPlayerContext()){
//            PlayerContext newContext = map(context);
//            newContext.setPlayer(player);
//            player.getPlayerContext().add(newContext);
//        }
        return player;
    }

    /**
     * Map reference Player DTO -> Player entity
     *
     * @param dto - player DTO
     * @return Player entity
     */
    private Player mapReference(PlayerDto dto) {
        if (dto == null || dto.getId() == null) {
            return null;
        }
        Player player = new Player();
        player.setId(dto.getId());
        return player;
    }

    /**
     * Map Team entity -> Team DTO
     *
     * @param team - entity
     * @return Team DTO
     */
    private TeamDto map(Team team) {
        if (team == null) {
            return null;
        }
        TeamDto dto = mapCore(team);
        return dto;
    }

    private TeamDto mapReference(Team team) {
        if (team == null) {
            return new TeamDto();
        }
        return mapCore(team);
    }

    private TeamDto mapCore(Team team) {
        TeamDto dto = new TeamDto();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setGroup(map(team.getGroup()));
        dto.setGoalsScored(team.getGoalsScored());
        dto.setGoalsConceeded(team.getGoalsConceeded());
        dto.setGoalDifference(team.getGoalDifference());
        dto.setMatchesFinished(team.getMatchesFinished());
        dto.setPoints(team.getPoints());
        dto.setTournamentState(team.getTState());
        dto.setUrlFlagImage(team.getUrlFlagImage());
        dto.setUrlInfo(team.getUrlInfo());
        dto.setTournamentWon(team.getTWon());
        dto.setIsNull(team.getIsNull());
        return dto;
    }

    /**
     * Map Team DTO -> Team entity
     *
     * @param dto - team DTO
     * @return team entity
     */
    private Team map(TeamDto dto) {
        if (dto == null) {
            return null;
        }
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setGroup(mapReference(dto.getGroup()));
        team.setGoalsScored(dto.getGoalsScored());
        team.setGoalsConceeded(dto.getGoalsConceeded());
        team.setGoalDifference(dto.getGoalDifference());
        team.setMatchesFinished(dto.getMatchesFinished());
        team.setPoints(dto.getPoints());
        team.setTState(dto.getTournamentState());
        team.setUrlFlagImage(dto.getUrlFlagImage());
        team.setUrlInfo(dto.getUrlInfo());
        team.setIsNull(dto.getIsNull());
        team.setTWon(dto.getTournamentWon());
        return team;
    }

    /**
     * Map reference Team DTO -> Team entity
     *
     * @param dto - team DTO
     * @return team entity
     */
    private Team mapReference(TeamDto dto) {
        if (dto == null || dto.getId() == null) {
            return null;
        }
        Team team = new Team();
        team.setId(dto.getId());
        return team;
    }

    /**
     * Map Team DTO -> Team entity
     *
     * @param dto - team DTO
     * @return team entity
     */
    private Tip map(TipDto dto) {
        if (dto == null) {
            return null;
        }
        Tip tip = new Tip();
        tip.setId(dto.getId());
        tip.setMatch(mapReference(dto.getMatch()));
        tip.setPlayer(map(dto.getPlayerContext()));
        tip.setGoalsTeamOne(dto.getGoalsTeamOne());
        tip.setGoalsTeamTwo(dto.getGoalsTeamTwo());
        tip.setTrend(dto.getTrend());
        tip.setPlayerScore(dto.getPlayerScore());
        tip.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : new Date());
        tip.setUpdatedAt(new Date());
        return tip;
    }

    private TipDto map(Tip tip) {
        if (tip == null) {
            return null;
        }
        TipDto dto = mapCore(tip);
        return dto;
    }

    private TipDto mapCore(Tip tip) {
        TipDto dto = new TipDto();
        dto.setId(tip.getId());
        dto.setMatch(mapReference(tip.getMatch()));
        dto.setPlayerContext(map(tip.getPlayerContext()));
        dto.setGoalsTeamOne(tip.getGoalsTeamOne());
        dto.setGoalsTeamTwo(tip.getGoalsTeamTwo());
        dto.setTrend(tip.getTrend());
        dto.setPlayerScore(tip.getPlayerScore());
        dto.setCreatedAt(tip.getCreatedAt());
        dto.setUpdatedAt(tip.getUpdatedAt());
        return dto;
    }

}
