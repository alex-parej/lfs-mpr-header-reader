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
package org.alexparej.lfs.mhr.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import org.alexparej.lfs.mhr.header.element.Car;
import org.alexparej.lfs.mhr.header.element.RaceDuration;
import org.alexparej.lfs.mhr.header.element.RaceFlag;
import org.alexparej.lfs.mhr.header.element.Skill;
import org.alexparej.lfs.mhr.header.element.Track;
import org.alexparej.lfs.mhr.header.element.WeatherCondition;
import org.alexparej.lfs.mhr.header.element.Wind;
import org.alexparej.lfs.mhr.header.record.HeaderRecord;
import org.alexparej.lfs.mhr.header.creator.AllowedCarsCreator;
import org.alexparej.lfs.mhr.header.creator.RaceDurationCreator;
import org.alexparej.lfs.mhr.header.creator.RaceFlagsCreator;
import org.alexparej.lfs.mhr.header.creator.TrackCreator;
import org.alexparej.lfs.mhr.header.creator.WeatherConditionCreator;

/**
 *
 * @author Alex
 */
public class MprHeaderReader {

    private final MprHeaderBytesReader mprHeaderBytesReader;

    public MprHeaderReader(File file) throws FileNotFoundException, IllegalArgumentException, IOException {
        mprHeaderBytesReader = new MprHeaderBytesReader(file);
        boolean immediateStart = ByteConverterUtil.byteToBoolean(mprHeaderBytesReader.get(HeaderRecord.IMMEDIATE_START)[0]);
        EnumSet<Car> allowedCars = AllowedCarsCreator.create(mprHeaderBytesReader.get(HeaderRecord.RULES));
        EnumSet<RaceFlag> raceFlags = RaceFlagsCreator.create(mprHeaderBytesReader.get(HeaderRecord.FLAGS));
        RaceDuration raceDuration = RaceDurationCreator.create(mprHeaderBytesReader.get(HeaderRecord.START_TIME), mprHeaderBytesReader.get(HeaderRecord.LAPS_BYTE)[0]);
        Skill skill = Skill.values()[ByteConverterUtil.byteToInt(mprHeaderBytesReader.get(HeaderRecord.SKILL)[0])];
        Wind wind = Wind.values()[ByteConverterUtil.byteToInt(mprHeaderBytesReader.get(HeaderRecord.WIND)[0])];
        int playersStart = ByteConverterUtil.byteToInt(mprHeaderBytesReader.get(HeaderRecord.NUM_PLAYERS)[0]);
        String lfsVersion = ByteConverterUtil.bytesToString(mprHeaderBytesReader.get(HeaderRecord.LFS_VERSION));
        Track track = TrackCreator.create(mprHeaderBytesReader.get(HeaderRecord.SHORT_TRACK_NAME), mprHeaderBytesReader.get(HeaderRecord.TRACK_NAME), mprHeaderBytesReader.get(HeaderRecord.CONFIG)[0], mprHeaderBytesReader.get(HeaderRecord.REVERSED)[0]);
        WeatherCondition weatherCondition = WeatherConditionCreator.create(mprHeaderBytesReader.get(HeaderRecord.WIND)[0], mprHeaderBytesReader.get(HeaderRecord.WEATHER)[0]);
    }

    private void processGeneralInformations() {
    }
}
