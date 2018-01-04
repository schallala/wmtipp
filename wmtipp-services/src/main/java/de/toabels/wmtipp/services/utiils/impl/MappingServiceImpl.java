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

import de.toabels.wmtipp.model.dto.AbstractBaseDto;
import de.toabels.wmtipp.model.dto.GroupDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.db.Group;
import de.toabels.wmtipp.model.db.IEntityBase;
import de.toabels.wmtipp.model.db.Match;
import de.toabels.wmtipp.model.db.Message;
import de.toabels.wmtipp.model.db.News;
import de.toabels.wmtipp.model.db.Player;
import de.toabels.wmtipp.model.db.Round;
import de.toabels.wmtipp.model.db.Team;
import de.toabels.wmtipp.model.db.Tip;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.MessageDto;
import de.toabels.wmtipp.model.dto.NewsDto;
import de.toabels.wmtipp.model.dto.RoundDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.model.dto.TipDto;
import de.toabels.wmtipp.services.utiils.IMappingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author abels
 * @param <D>
 * @param <E>
 */
@Component
public class MappingServiceImpl<D extends AbstractBaseDto, E extends IEntityBase<E>> implements IMappingService<D, E> {

  /**
   * Dispatcher method to invoke specific mapper method of entity object to DTO object
   *
   * @param entity - database object
   * @return DTO object
   */
  @Override
  public D map(E entity) {
    if (entity == null) {
      return null;
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
   * Dispatcher method to invoke specific mapper method of DTO object to entity object
   *
   * @param dto
   * @return 
   */
  @Override
  public E map(D dto) {
    if (dto == null) {
      return null;
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
   * Map Group entity -> Group DTO
   *
   * @param group - entity
   * @return Group DTO
   */
  private GroupDto map(Group group) {
    GroupDto dto = new GroupDto();
    // TAKE CARE: group is not mandatory
    if (group == null) {
      return dto;
    }
    dto.setId(group.getId());
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
    // TAKE CARE: group is not mandatory
    if (dto == null){// || dto.getId() == null) {
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
    if (round == null) {
      return null;
    }
    RoundDto dto = new RoundDto();
    dto.setId(round.getId());
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
    if (news == null) {
      return null;
    }
    NewsDto dto = new NewsDto();
    dto.setId(news.getId());
    dto.setSubject(news.getSubject());
    dto.setText(news.getText());
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
    dto.setRecipient(mapCore(message.getRecipient()));
    dto.setSender(mapCore(message.getSender()));
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
    message.setRecipient(mapCore(dto.getRecipient()));
    message.setSender(mapCore(dto.getSender()));
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
    dto.setTeamOne(mapCore(match.getTeamOne()));
    dto.setTeamTwo(mapCore(match.getTeamTwo()));
    dto.setAutoKnockoutGroupTeamOne(match.getAutoKnockoutGroupTeamOne());
    dto.setAutoKnockoutGroupTeamTwo(match.getAutoKnockoutGroupTeamTwo());
    dto.setAutoKnockoutGroupPosTeamOne(match.getAutoKnockoutGroupPosTeamOne());
    dto.setAutoKnockoutGroupPosTeamTwo(match.getAutoKnockoutGroupPosTeamTwo());
    dto.setAutoKnockoutMatchTeamOne(match.getAutoKnockoutMatchTeamOne());
    dto.setAutoKnockoutMatchTeamTwo(match.getAutoKnockoutMatchTeamTwo());
    return dto;
  }

  private MatchDto mapCore(Match match) {
    if (match == null) {
      return null;
    }
    MatchDto dto = new MatchDto();
    dto.setId(match.getId());
    dto.setStartDate(match.getStartDate());
    dto.setGoalsTeamOne(match.getGoalsTeamOne());
    dto.setGoalsTeamTwo(match.getGoalsTeamTwo());
    return dto;
  }

  private Match map(MatchDto dto) {
    if (dto == null) {
      return null;
    }
    Match match = mapCore(dto);
    match.setName(dto.getName());
    match.setDescription(dto.getDescription());
    match.setGoalsTeamOne(dto.getGoalsTeamOne());
    match.setGoalsTeamTwo(dto.getGoalsTeamTwo());
    match.setGroup(map(dto.getGroup()));
    match.setRound(map(dto.getRound()));
    match.setStartDate(dto.getStartDate());
    match.setStatus(dto.getStatus());
    match.setTickerMatchId(dto.getTickerMatchId());
    match.setTickerUrl(dto.getTickerUrl());
    match.setTeamOne(mapCore(dto.getTeamOne()));
    match.setTeamTwo(mapCore(dto.getTeamTwo()));
    match.setAutoKnockoutGroupTeamOne(dto.getAutoKnockoutGroupTeamOne());
    match.setAutoKnockoutGroupTeamTwo(dto.getAutoKnockoutGroupTeamTwo());
    match.setAutoKnockoutGroupPosTeamOne(dto.getAutoKnockoutGroupPosTeamOne());
    match.setAutoKnockoutGroupPosTeamTwo(dto.getAutoKnockoutGroupPosTeamTwo());
    match.setAutoKnockoutMatchTeamOne(dto.getAutoKnockoutMatchTeamOne());
    match.setAutoKnockoutMatchTeamTwo(dto.getAutoKnockoutMatchTeamTwo());
    return match;
  }

  private Match mapCore(MatchDto dto) {
    if (dto == null) {
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
    dto.setEmail(player.getEmail());
    dto.setLogin(player.getLogin());
    dto.setUserRole(player.getUserRole());
    dto.setTipsVisible(player.getTipsVisible());
    dto.setPassword(player.getPassword());
    dto.setPhone(player.getPhone());
    dto.setPredictedChampion(mapCore(player.getPredictedChampion()));
    dto.setCorrectTips(player.getCorrectTips());
    dto.setCorrectTrends(player.getCorrectTrends());
    dto.setFeePaid(player.getFeePaid());
    dto.setScore(player.getScore());
    return dto;
  }

  private PlayerDto mapCore(Player player) {
    if (player == null) {
      return null;
    }
    PlayerDto dto = new PlayerDto();
    dto.setId(player.getId());
    dto.setName(player.getName());
    dto.setFirstName(player.getFirstName());
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
    Player player = mapCore(dto);
    player.setEmail(dto.getEmail());
    player.setLogin(dto.getLogin());
    player.setUserRole(dto.getUserRole());
    player.setTipsVisible(dto.getTipsVisible());
    player.setPassword(dto.getPassword());
    player.setPhone(dto.getPhone());
    player.setPredictedChampion(mapCore(dto.getPredictedChampion()));
    player.setCorrectTips(dto.getCorrectTips());
    player.setCorrectTrends(dto.getCorrectTrends());
    player.setFeePaid(dto.getFeePaid());
    player.setScore(dto.getScore());
    return player;
  }

  private Player mapCore(PlayerDto dto) {
    if (dto == null) {
      return null;
    }
    Player player = new Player();
    player.setId(dto.getId());
    player.setName(dto.getName());
    player.setFirstName(dto.getFirstName());
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

  private TeamDto mapCore(Team team) {
    if (team == null) {
      return null;
    }
    TeamDto dto = new TeamDto();
    dto.setId(team.getId());
    dto.setName(team.getName());
    dto.setGroup(map(team.getGroup()));
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
    Team team = mapCore(dto);
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

  private Team mapCore(TeamDto dto) {
    if (dto == null) {
      return null;
    }
    Team team = new Team();
    team.setId(dto.getId());
    team.setName(dto.getName());
    team.setGroup(map(dto.getGroup()));
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
    tip.setMatch(mapCore(dto.getMatch()));
    tip.setPlayer(mapCore(dto.getPlayer()));
    tip.setGoalsTeamOne(dto.getGoalsTeamOne());
    tip.setGoalsTeamTwo(dto.getGoalsTeamTwo());
    tip.setTrend(dto.getTrend());
    tip.setPlayerScore(dto.getPlayerScore());
    tip.setCreatedAt(dto.getCreatedAt());
    tip.setUpdatedAt(dto.getUpdatedAt());
    return tip;
  }

  private TipDto map(Tip tip) {
    if (tip == null) {
      return null;
    }
    TipDto dto = new TipDto();
    dto.setId(tip.getId());
    dto.setMatch(mapCore(tip.getMatch()));
    dto.setPlayer(mapCore(tip.getPlayer()));
    dto.setGoalsTeamOne(tip.getGoalsTeamOne());
    dto.setGoalsTeamTwo(tip.getGoalsTeamTwo());
    dto.setTrend(tip.getTrend());
    dto.setPlayerScore(tip.getPlayerScore());
    dto.setCreatedAt(tip.getCreatedAt());
    dto.setUpdatedAt(tip.getUpdatedAt());
    return dto;
  }

}
