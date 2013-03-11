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

import java.util.EnumSet;

/**
 *
 * @author Alex
 */
public class Header {

    private EnumSet<Car> allowedCars;
    private EnumSet<RaceFlag> raceFlags;
    private RaceDuration raceDuration;
    private Skill skill;
    private Wind wind;
    private int playersStart;
    private String lfsVersion;
    private Track track;
    private WeatherCondition weatherCondition;

    public Header(EnumSet<Car> allowedCars, EnumSet<RaceFlag> raceFlags, RaceDuration raceDuration, Skill skill, Wind wind, int playersStart, String lfsVersion, Track track, WeatherCondition weatherCondition) {
        this.allowedCars = allowedCars;
        this.raceFlags = raceFlags;
        this.raceDuration = raceDuration;
        this.skill = skill;
        this.wind = wind;
        this.playersStart = playersStart;
        this.lfsVersion = lfsVersion;
        this.track = track;
        this.weatherCondition = weatherCondition;
    }

    public EnumSet<Car> getAllowedCars() {
        return allowedCars;
    }

    public EnumSet<RaceFlag> getRaceFlags() {
        return raceFlags;
    }

    public RaceDuration getRaceDuration() {
        return raceDuration;
    }

    public Skill getSkill() {
        return skill;
    }

    public Wind getWind() {
        return wind;
    }

    public int getPlayersStart() {
        return playersStart;
    }

    public String getLfsVersion() {
        return lfsVersion;
    }

    public Track getTrack() {
        return track;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }
}
