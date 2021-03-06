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
package de.toabels.wmtipp.model.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO class representing a view object of message entity
 *
 * @author abels
 */
@XmlRootElement
public class MessageDto extends AbstractBaseDto {

  private PlayerDto sender;

  private PlayerDto recipient;

  private String subject;

  private String text;

  private Date createdAt;

  private Boolean messageRead;

  public MessageDto() {
    this.sender = new PlayerDto();
    this.recipient = new PlayerDto();
  }

  public PlayerDto getSender() {
    return sender;
  }

  public void setSender(PlayerDto sender) {
    this.sender = sender;
  }

  public PlayerDto getRecipient() {
    return recipient;
  }

  public void setRecipient(PlayerDto recipient) {
    this.recipient = recipient;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Boolean getMessageRead() {
    return messageRead;
  }

  public void setMessageRead(Boolean messageRead) {
    this.messageRead = messageRead;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MessageDto)) {
      return false;
    }
    MessageDto other = (MessageDto) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.toabels.wmtipp.model.db.MessageDto[ id=" + id + " ]";
  }

}
