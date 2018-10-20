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
package de.toabels.wmtipp.services.utils.impl;

import de.toabels.wmtipp.model.db.Competition;
import de.toabels.wmtipp.model.db.Group;
import de.toabels.wmtipp.model.dto.CompetitionDto;
import de.toabels.wmtipp.model.dto.GroupDto;

/**
 *
 * @author abels
 */
public class EntityMock {

    public static Group mockGroup() {
        Group mock = new Group();
        mock.setId(100L);
        mock.setName("TestGroup");
        mock.setSortOrder(10);
        mock.setCompetition(mockCompetition());
        return mock;
    }

    public static Competition mockCompetition() {
        Competition mock = new Competition();
        mock.setId(101L);
        mock.setName("Testcompetition");
        mock.setExternalId("R2D2");
        mock.setFlagsPath("/dev/nul");
        mock.setImagePath("/tmp");
        mock.setShortname("Testcomp");
        mock.setTitle("Testtitle");
        mock.setPointsDraw(1L);
        mock.setPointsWin(3L);
        return mock;
    }

}
