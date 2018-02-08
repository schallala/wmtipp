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
package de.toabels.wmtipp.services.api;

import de.toabels.wmtipp.model.db.Tip;
import de.toabels.wmtipp.model.dto.TipDto;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class offering tip related funtionality
 * 
 * @author abels
 */
@Service
@Transactional
public interface ITipService extends IGenericBaseService<TipDto, Tip> {

  List<TipDto> saveList(List<TipDto> dtoList);

  List<TipDto> findByPlayerId(Long playerId);
}
