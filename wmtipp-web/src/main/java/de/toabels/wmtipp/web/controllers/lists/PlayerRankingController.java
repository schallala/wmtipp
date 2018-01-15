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
package de.toabels.wmtipp.web.controllers.lists;

import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.web.controllers.masterdata.AbstractController;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("playerRankingCtrl")
@Scope("session")
public class PlayerRankingController extends AbstractController {

  private static final Logger logger = LoggerFactory.getLogger(PlayerRankingController.class);

  public List<PlayerDto> getRanking() {
    return getPlayerListOrdered("score desc nulls last", "correctTips desc", "name", "firstName");
  }
}
