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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author abels
 */
public class MappingServiceImplTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of map method, of class MappingServiceImpl.
     */
    @Test
    @Ignore
    public void testMap_GroupToDto() {
        System.out.println("map group to dto");
        Group entity = EntityMock.mockGroup();
        MappingServiceImpl instance = new MappingServiceImpl();
        GroupDto expResult = DtoMock.mockGroupDto(100L, "Test group");
        GroupDto result = (GroupDto) instance.map(entity);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getSortOrder(), result.getSortOrder());
        assertNotNull(result.getCompetition());
        assertEquals(expResult.getCompetition().getId(), result.getCompetition().getId());
    }

    @Test
    @Ignore
    public void testMap_DtoToGroup() {
        System.out.println("map dto to group");
        GroupDto dto = DtoMock.mockGroupDto(200L, "Test group 2");
        MappingServiceImpl instance = new MappingServiceImpl();
        Group expResult = EntityMock.mockGroup();
        Group result = (Group) instance.map(dto);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getSortOrder(), result.getSortOrder());
        assertNotNull(result.getCompetition());
        assertEquals(expResult.getCompetition().getId(), result.getCompetition().getId());
    }

}
