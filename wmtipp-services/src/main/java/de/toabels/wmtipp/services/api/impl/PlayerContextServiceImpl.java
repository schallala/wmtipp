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

import de.toabels.wmtipp.model.db.PlayerContext;
import de.toabels.wmtipp.model.dto.CommunityDto;
import de.toabels.wmtipp.model.dto.PlayerContextDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.dto.TeamDto;
import de.toabels.wmtipp.services.api.IPlayerContextService;
import de.toabels.wmtipp.services.dao.IPlayerContextDao;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abels
 */
@Service
@Transactional
public class PlayerContextServiceImpl extends GenericBaseServiceImpl<PlayerContextDto, PlayerContext> implements IPlayerContextService {

    IPlayerContextDao playerContextDao;

    @Inject
    public PlayerContextServiceImpl(IPlayerContextDao dao) {
        super(dao);
        playerContextDao = dao;
    }

    @Override
    public PlayerContextDto getNewObjectInstance() {
        PlayerContextDto object = new PlayerContextDto();
        object.setPlayer(new PlayerDto());
        object.setCommunity(new CommunityDto());
        object.setPredictedChampion(new TeamDto());
        return object;
    }
}
