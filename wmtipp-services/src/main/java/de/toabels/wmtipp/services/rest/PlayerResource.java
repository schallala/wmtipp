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
package de.toabels.wmtipp.services.rest;

import de.toabels.wmtipp.model.dto.PlayerDto;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.process.internal.RequestScoped;

/**
 *
 * @author abels
 */
@Path("/player")
@RequestScoped
public class PlayerResource {

  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public PlayerDto getPlayer(@PathParam("id") int id) {
    return new PlayerDto("Mustermann", "Martin", "0190696969", "abels@nix.de", null, true, 4, 5, 6, "password", true, 
            null, "login");
  }

}
