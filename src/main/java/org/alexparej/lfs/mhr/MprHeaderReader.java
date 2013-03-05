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
package org.alexparej.lfs.mhr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.alexparej.lfs.mhr.mprelement.Player;
import org.alexparej.lfs.mhr.mprelement.RaceDuration;
import org.alexparej.lfs.mhr.mprelement.Skill;
import org.alexparej.lfs.mhr.mprelement.Track;
import org.alexparej.lfs.mhr.processor.MprBytesProcessor;

/**
 *
 * @author Alex
 */
public class MprHeaderReader {

    private boolean immediateStart;
    private Skill skill;
    private String lfsVersion;
    private Track track;
    private RaceDuration raceDuration;
    private List<Player> result;
    byte[] generalInformationsBytes;

    public MprHeaderReader(File file) throws FileNotFoundException, IllegalArgumentException, IOException {
        MprHeaderBytesReader mprHeaderBytesReader = new MprHeaderBytesReader(file);
        generalInformationsBytes = mprHeaderBytesReader.getGeneralInfos();
        byte[][] resultBytes = mprHeaderBytesReader.getResult();
        MprBytesProcessor processor = new MprBytesProcessor(generalInformationsBytes, resultBytes);
        System.out.println(processor.isImmediateStart());
        System.out.println(processor.getWeatherCondition().getWeatherCode());
        System.out.println(processor.getWeatherCondition().getWind());
        System.out.println(processor.getSkill());
        System.out.println(processor.getLfsVersion());
    }

    private void processGeneralInformations() {
    }

    public boolean isImmediateStart() {
        return immediateStart;
    }

    public Skill getSkill() {
        return skill;
    }

    public String getLfsVersion() {
        return lfsVersion;
    }

    public Track getTrack() {
        return track;
    }

    public RaceDuration getRaceDuration() {
        return raceDuration;
    }

    public List<Player> getResult() {
        return result;
    }
}
