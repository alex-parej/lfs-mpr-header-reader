/*
 * Copyright 2013 Alex.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.alexparej.lfs.mhr.header.element;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class RaceDuration {

    private Date startTime;
    private int laps;
    private int hours;

    public RaceDuration(Date startTime, int laps, int hours) {
        this.startTime = startTime;
        this.laps = laps;
        this.hours = hours;
    }

    public Date getStartTime() {
        return startTime;
    }

    public boolean isPractice() {
        return laps == 0 && hours == 0;
    }

    public int getLaps() {
        return laps;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "RaceDuration{" + "startTime=" + startTime + ", laps=" + laps + ", hours=" + hours + '}';
    }
}
