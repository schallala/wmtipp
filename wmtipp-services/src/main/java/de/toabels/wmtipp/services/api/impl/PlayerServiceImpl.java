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

import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.model.db.Player;
import de.toabels.wmtipp.services.api.ICommunityService;
import de.toabels.wmtipp.services.api.IPlayerContextService;
import de.toabels.wmtipp.services.api.IPlayerService;
import de.toabels.wmtipp.services.dao.IPlayerDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abels
 */
@Service
@Transactional
public class PlayerServiceImpl extends GenericBaseServiceImpl<PlayerDto, Player> implements IPlayerService {

    IPlayerDao playerDao;

    @Autowired
    IPlayerContextService playerContextService;

    @Inject
    public PlayerServiceImpl(IPlayerDao dao) {
        super(dao);
        playerDao = dao;
    }

    @Override
    public PlayerDto getNewObjectInstance() {
        PlayerDto object = new PlayerDto();
        // add needed child objects
        object.setPlayerContext(new ArrayList<>());
        object.getPlayerContext().add(playerContextService.getNewObjectInstance());
        return object;
    }

    @Override
    public PlayerDto loginUser(String login, String password) {
        Player result = playerDao.findByLoginAndPassword(login, password);
        if (result != null) {
            return mapper.map(result);
        }
        return null;
    }

    @Override
    public List<PlayerDto> getLoggedInUsers(PlayerDto player) {
        // set last activity of calling user
        player.setLastActivity(new Date());
        super.save(player);
        return super.listOrdered("lastActivity desc");
    }
}
