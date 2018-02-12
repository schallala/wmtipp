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
package de.toabels.wmtipp.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author abels
 */
public class FdoResult extends SimpleResult{

    @JsonProperty("halfTime")
    private SimpleResult halfTime;

    @JsonProperty("extraTime")
    private SimpleResult extraTime;

    @JsonProperty("penaltyShootout")
    private SimpleResult penaltyShootout;

    public SimpleResult getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(SimpleResult halfTime) {
        this.halfTime = halfTime;
    }

    public SimpleResult getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(SimpleResult extraTime) {
        this.extraTime = extraTime;
    }

    public SimpleResult getPenaltyShootout() {
        return penaltyShootout;
    }

    public void setPenaltyShootout(SimpleResult penaltyShootout) {
        this.penaltyShootout = penaltyShootout;
    }

}
