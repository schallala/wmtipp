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
package de.toabels.wmtipp.web.controllers.masterdata;

import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.dto.TipDto;
import de.toabels.wmtipp.services.api.ITipService;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Controller class to manage CRUD operations on round objects
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 */
@Controller("tipEditCtrl")
@Scope("session")
public class TipEditController extends AbstractEditController<TipDto> {

  @Autowired
  ITipService tipService;

  List<TipDto> tipList;

  private Map<Long, MatchDto> matchMap;

  private static final Logger logger = LoggerFactory.getLogger(TipEditController.class);

  /* Following methods should be implemented in a similar way by all child classes of AbstractEditController */
 /* Concrete implementation may vary depending on the subject of the edit page                              */
  /**
   * Init method calls super.init with specific service instance
   */
  @PostConstruct
  public void init() {
    super.init(tipService);
  }

  public List<TipDto> getTipList() {
    tipList = tipService.list();
    return tipList;
  }

  public List<TipDto> getFilteredTipList(Long roundId, Long groupId) {
    List<TipDto> result = new ArrayList();
    tipList.forEach((tip) -> {
      MatchDto match = mapMatch(tip.getMatch().getId());
      if (match == null || match.getRound() == null || match.getGroup() == null) {
        logger.info("Ahllo!");
      }
      if (match.getRound().getId().equals(roundId)
              && match.getGroup().getId() == null && (groupId == null || match.getGroup().getId().equals(groupId))) {
        result.add(tip);
      } else {
      }
    });
    return result;
  }

  public MatchDto mapMatch(Long id) {
    if (matchMap == null) {
      matchMap = super.getMatchList().stream().collect(Collectors.toMap(MatchDto::getId, p -> p));
    }
    return matchMap.get(id);
  }
}
