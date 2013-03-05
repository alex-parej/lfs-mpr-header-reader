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

import org.alexparej.lfs.mhr.mprelement.Skill;
import org.alexparej.lfs.mhr.mprelement.WeatherCondition;
import org.alexparej.lfs.mhr.mprelement.Wind;

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
    private static final int LENGTH_LFS_VERSION = 8;
    private boolean immediateStart;
    private String lfsVersion;
    private Skill skill;
    private WeatherCondition weatherCondition;
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
}
