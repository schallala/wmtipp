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
import de.toabels.wmtipp.model.external.FdoFixture;
import de.toabels.wmtipp.model.external.FdoFixtureList;
import de.toabels.wmtipp.model.external.FdoTeam;
import de.toabels.wmtipp.model.external.FdoTeamList;
import de.toabels.wmtipp.services.utiils.IResultService;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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

    private Client getClient() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        client.register(JacksonJsonProvider.class);
        return client;
    }

    @Override
    public List<FdoCompetition> findCompetitionsByYear(String selectedYear) {
        Client client = getClient();
        Response response = client.target(getBaseURI()).
                path(COMPETITIONS_SERVICE).
                queryParam("season", selectedYear).
                request().
                header("Authorization", authToken).
                header("X-Response-Control", "minified").
                accept(MediaType.APPLICATION_JSON).
                get();
        List<FdoCompetition> result = Arrays.asList(response.readEntity(FdoCompetition[].class));
        response.close();
        client.close();
        return result;
    }

    @Override
    public List<FdoTeam> findTeamsByCompetition(String id) {
        Client client = getClient();
        Response response = client.target(getBaseURI()).
                path(COMPETITIONS_SERVICE).path(id).path("/teams").
                request().
                header("X-Auth-Token", authToken).
                header("X-Response-Control", "minified").
                accept(MediaType.APPLICATION_JSON).
                get();
        FdoTeamList teams = response.readEntity(FdoTeamList.class);
        response.close();
        client.close();
        return teams.getTeams();
    }

    @Override
    public List<FdoFixture> findFixturesByCompetition(String id) {
        Client client = getClient();
        Response response = client.target(getBaseURI()).
                path(COMPETITIONS_SERVICE).path(id).path("/fixtures").
                request().
                header("X-Auth-Token", authToken).
                header("X-Response-Control", "minified").
                accept(MediaType.APPLICATION_JSON).
                get();
        FdoFixtureList fixtures = response.readEntity(FdoFixtureList.class);
        response.close();
        client.close();
        return fixtures.getFixtures();
    }

}
