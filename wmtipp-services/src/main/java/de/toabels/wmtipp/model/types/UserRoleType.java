/*
 * Copyright (C) 2017 Torsten Abels <torsten.abels@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package de.toabels.wmtipp.model.types;

/**
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 */
public enum UserRoleType {
  SYSTEM_ADMIN("Sytemadministrator"),
  ADMIN("Administrator"),
  TIPPER("Tipper"),
  USER("User");
  
  private String label;

  UserRoleType(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

}
