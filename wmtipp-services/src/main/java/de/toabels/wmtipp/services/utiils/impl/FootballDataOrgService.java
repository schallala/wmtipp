/*
 * Copyright (C) 2018 abels
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
package de.toabels.wmtipp.services.utiils.impl;

import de.toabels.wmtipp.model.external.FdoCompetition;
import de.toabels.wmtipp.model.external.FdoTeam;
import de.toabels.wmtipp.services.utiils.IResultService;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author abels
 */
@Service
public class FootballDataOrgService implements IResultService {

    private static final String SERVICE_BASE_URL = "http://api.football-data.org/";
    private static final String COMPETITIONS_SERVICE = "v1/competitions";

    private @Value("${app.apiAuthToken}")
    String authToken;

    private static URI getBaseURI() {
        return UriBuilder.fromUri(SERVICE_BASE_URL).build();
    }

    private WebTarget getTarget(String path) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        client.register(JacksonJsonProvider.class);
        WebTarget target = client.target(getBaseURI()).path(path);
        return target;
    }

    @Override
    public List<FdoCompetition> findCompetitionsByYear(String selectedYear) {
        Response response = getTarget(COMPETITIONS_SERVICE).
                queryParam("season", selectedYear).
                request().
                header("Authorization", authToken).
                accept(MediaType.APPLICATION_JSON).
                get();
        return Arrays.asList(response.readEntity(FdoCompetition[].class));
    }

    @Override
    public List<FdoTeam> findTeamsByCompetition(String id) {
        Response response = getTarget(COMPETITIONS_SERVICE).path(id).path("/teams").
                request().
                header("Authorization", authToken).
                accept(MediaType.APPLICATION_JSON).
                get();
        return Arrays.asList(response.readEntity(FdoTeam[].class));
    }

}
