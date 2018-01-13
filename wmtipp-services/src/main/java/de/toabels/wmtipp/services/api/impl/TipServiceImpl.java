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
package de.toabels.wmtipp.services.api.impl;

import de.toabels.wmtipp.model.db.Tip;
import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.TipDto;
import de.toabels.wmtipp.services.api.IMatchService;
import de.toabels.wmtipp.services.api.ITipService;
import de.toabels.wmtipp.services.dao.ITipDao;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abels
 */
@Service
@Transactional
public class TipServiceImpl extends GenericBaseServiceImpl<TipDto, Tip> implements ITipService {

  ITipDao tipDao;

  @Autowired
  IMatchService matchService;
  
  @Inject
  public TipServiceImpl(ITipDao dao) {
    super(dao);
    tipDao = dao;
  }

  @Override
  public TipDto getNewObjectInstance() {
    TipDto object = new TipDto();
    object.setMatch(new MatchDto());
    object.setPlayer(new PlayerDto());
    return object;
  }

//  @Cacheable(value = "lists", key = "#root.target.class.name + 'findByPlayerId' + #playerId")
  @Override
  public List<TipDto> findByPlayerId(Long playerId){
    List<TipDto> tipList = tipDao.findByPlayerId(playerId).stream().map(p -> mapper.map(p)).collect(Collectors.toList());
    List<MatchDto> matchList = matchService.list();
    // insert missing tips
    Map<Long, TipDto> matchTipMap = tipList.stream().collect(Collectors.toMap(p -> p.getMatch().getId(), p -> p));
    for(MatchDto match : matchList){
      if(matchTipMap.get(match.getId()) == null){
        TipDto newTip = getNewObjectInstance();
        newTip.getPlayer().setId(playerId);
        newTip.getMatch().setId(match.getId());
        tipList.add(newTip);
      }
    }

    return tipList;
  }
}
