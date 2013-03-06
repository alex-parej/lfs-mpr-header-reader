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

import org.alexparej.lfs.mhr.header.element.Track;

/**
 *
 * @author Alex
 */
public class TrackProcessor {

    private Track track;

    public TrackProcessor(byte[] shortNameBytes, byte[] nameBytes, byte configByte, byte reversedByte) {
        String shortName = ProcessorUtil.bytesToString(shortNameBytes);
        String name = ProcessorUtil.bytesToString(nameBytes);
        boolean reversed = ProcessorUtil.byteToBoolean(reversedByte);
        track = new Track(shortName, name, configByte, reversed);
    }

    public Track getTrack() {
        return track;
    }
}
