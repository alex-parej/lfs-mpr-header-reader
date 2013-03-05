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
package org.alexparej.lfs.mhr.processor;

import java.util.Arrays;
import org.alexparej.lfs.mhr.mprelement.Skill;
import org.alexparej.lfs.mhr.mprelement.Track;
import org.alexparej.lfs.mhr.mprelement.WeatherCondition;

/**
 *
 * @author Alex
 */
public class MprBytesProcessor {

    private static final int OFFSET_IMMEDIATE_START = 9;
    private static final int OFFSET_SKILL = 21;
    private static final int OFFSET_WIND = 22;
    private static final int OFFSET_LFS_VERSION = 24;
    private static final int OFFSET_WEATHER = 74;
    private static final int OFFSET_SHORT_TRACK_NAME = 32;
    private static final int OFFSET_TRACK_NAME = 40;
    private static final int OFFSET_CONFIG = 72;
    private static final int OFFSET_REVERSED = 73;
    private static final int LENGTH_LFS_VERSION = 8;
    private static final int LENGTH_SHORT_TRACK_NAME = 4;
    private static final int LENGTH_TRACK_NAME = 32;
    private boolean immediateStart;
    private String lfsVersion;
    private Skill skill;
    private WeatherCondition weatherCondition;
    private Track track;
    private byte[] generalInformationsBytes;
    private byte[][] resultBytes;

    public MprBytesProcessor(byte[] generalInformationsBytes, byte[][] resultBytes) {
        this.generalInformationsBytes = generalInformationsBytes;
        this.resultBytes = resultBytes;
        immediateStart = ProcessorUtil.byteToBoolean(generalInformationsBytes[OFFSET_IMMEDIATE_START]);
        skill = Skill.values()[generalInformationsBytes[OFFSET_SKILL]];
        lfsVersion = ProcessorUtil.bytesToString(generalInformationsBytes, OFFSET_LFS_VERSION, LENGTH_LFS_VERSION);
        WeatherConditionProcessor weatherConditionProcessor = new WeatherConditionProcessor(generalInformationsBytes[OFFSET_WIND], generalInformationsBytes[OFFSET_WEATHER]);
        weatherCondition = weatherConditionProcessor.getWeatherCondition();
        TrackProcessor trackProcessor = new TrackProcessor(Arrays.copyOfRange(generalInformationsBytes, OFFSET_SHORT_TRACK_NAME, OFFSET_SHORT_TRACK_NAME+LENGTH_SHORT_TRACK_NAME), Arrays.copyOfRange(generalInformationsBytes, OFFSET_TRACK_NAME, OFFSET_TRACK_NAME+LENGTH_TRACK_NAME), generalInformationsBytes[OFFSET_CONFIG], generalInformationsBytes[OFFSET_REVERSED]);
        track = trackProcessor.getTrack();
        System.out.println("track: "+track);
    }

    public boolean isImmediateStart() {
        return immediateStart;
    }

    public Skill getSkill() {
        return skill;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public String getLfsVersion() {
        return lfsVersion;
    }

    public Track getTrack() {
        return track;
    }
    
    
}
