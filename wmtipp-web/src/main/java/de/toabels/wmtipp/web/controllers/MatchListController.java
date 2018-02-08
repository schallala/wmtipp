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
package de.toabels.wmtipp.web.controllers;

import de.toabels.wmtipp.model.dto.MatchDto;
import de.toabels.wmtipp.model.external.FdoCompetition;
import de.toabels.wmtipp.services.api.IMatchService;
import java.net.URI;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.stereotype.Controller;

@Controller("matchListCtrl")
@Scope("request")
public class MatchListController {

    private static final Logger logger = LoggerFactory.getLogger(MatchListController.class);

    private List<String> panels = new ArrayList<String>();

    private List<FdoCompetition> competitions = new ArrayList<>();
    
    private String selectedYear;

    @Autowired
    private IMatchService matchService;

    public List<MatchDto> getMatchList() {
        return matchService.listOrdered("startDate");
    }

    public List<String> getPanels() {
        panels.add("Panel1");
        panels.add("Panel2");
        panels.add("Panel3");
        return panels;
    }

    public void setPanels(List<String> panels) {
        this.panels = panels;
    }

    public List<FdoCompetition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<FdoCompetition> competitions) {
        this.competitions = competitions;
    }

    public String getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }

    
    public void testFootballData() {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);
        client.register(JacksonJsonProvider.class);
        WebTarget target = client.target(getBaseURI());

        Response response = target.path("v1").
                path("competitions").queryParam("season", selectedYear).
                request().
                //                header("Authorization", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").
                accept(MediaType.APPLICATION_JSON).
                get();

        FdoCompetition[] result = response.readEntity(FdoCompetition[].class);
        this.competitions.clear();
        for(FdoCompetition comp : result){
            this.competitions.add(comp);
        }
        
        response.close();
        client.close();

    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://api.football-data.org/").build();
    }

}
