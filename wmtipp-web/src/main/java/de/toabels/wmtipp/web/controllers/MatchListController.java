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

import de.toabels.wmtipp.model.db.Match;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import java.util.ArrayList;
import de.toabels.wmtipp.services.dao.IMatchDao;
import org.springframework.stereotype.Controller;

@Controller("matchListCtrl")
@Scope("request")
public class MatchListController {

	private static final Logger logger = LoggerFactory.getLogger(MatchListController.class);

	private List<Match> matchList;
    private List<String> panels = new ArrayList<String>();

	@Autowired
	private IMatchDao matchDao;

	
	public List<Match> getMatchList() {
		if (matchList == null) {
			matchList = matchDao.findAll();
		}
		return matchList;
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
    
    
}
