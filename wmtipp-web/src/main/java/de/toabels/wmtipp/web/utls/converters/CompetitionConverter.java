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
package de.toabels.wmtipp.web.utls.converters;

import de.toabels.wmtipp.model.dto.CompetitionDto;
import de.toabels.wmtipp.services.api.ICompetitionService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("competitionConverter")
public class CompetitionConverter implements Converter {

    @Autowired
    ICompetitionService competitionService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return competitionService.findById((Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                throw new ConverterException("Not a valid competition.");
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object != null) {
            return String.valueOf(((CompetitionDto) object).getId());
        } else {
            return null;
        }
    }
}
