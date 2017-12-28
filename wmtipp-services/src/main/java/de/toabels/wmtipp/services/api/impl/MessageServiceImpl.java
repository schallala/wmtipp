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

import de.toabels.wmtipp.model.db.Message;
import de.toabels.wmtipp.model.dto.MessageDto;
import de.toabels.wmtipp.model.dto.PlayerDto;
import de.toabels.wmtipp.services.api.IMessageService;
import de.toabels.wmtipp.services.dao.IMessageDao;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abels
 */
@Service
@Transactional
public class MessageServiceImpl extends GenericBaseServiceImpl<MessageDto, Message> implements IMessageService {

  IMessageDao playerDao;
  
  @Inject
  public MessageServiceImpl(IMessageDao dao) {
    super(dao);
    playerDao = dao;
  }

  @Override
  public MessageDto getNewObjectInstance() {
    MessageDto object = new MessageDto();
    object.setRecipient(new PlayerDto());
    object.setSender(new PlayerDto());
    return object;
  }
}
