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
import java.util.List;
import org.alexparej.lfs.mhr.header.element.Player;
import org.alexparej.lfs.mhr.header.element.RaceDuration;
import org.alexparej.lfs.mhr.header.element.Skill;
import org.alexparej.lfs.mhr.header.element.Track;
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
        generalInformationsBytes = mprHeaderBytesReader.getReplayDescription();
        byte[][] resultBytes = mprHeaderBytesReader.getResult();
        MprBytesProcessor processor = new MprBytesProcessor(generalInformationsBytes, resultBytes);
        System.out.println(processor.isImmediateStart());
        System.out.println(processor.getWeatherCondition().getWeatherCode());
        System.out.println(processor.getWeatherCondition().getWind());
        System.out.println(processor.getSkill());
        System.out.println(processor.getLfsVersion());
        System.out.println("TRACK INFOS:");
        System.out.println(processor.getTrack().getShortName());
        System.out.println(processor.getTrack().getName());
        System.out.println(processor.getTrack().getConfig());
        System.out.println(processor.getTrack().isReversed());
        System.out.println("DURATION: ");
        System.out.println(processor.getRaceDuration().getStartTime());
        System.out.println(processor.getRaceDuration().getHours());
        System.out.println(processor.getRaceDuration().getLaps());
        System.out.println(processor.getRaceDuration().isPractice());
        System.out.println(processor.getRaceFlags());
        System.out.println(processor.getAllowedCars());
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
