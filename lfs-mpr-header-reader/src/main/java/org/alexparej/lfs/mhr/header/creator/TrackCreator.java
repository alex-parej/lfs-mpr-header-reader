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
package org.alexparej.lfs.mhr.header.creator;

import org.alexparej.lfs.mhr.header.element.Track;
import org.alexparej.lfs.mhr.reader.ByteConverterUtil;

/**
 *
 * @author Alex
 */
public final class TrackCreator {

    private TrackCreator() {
    }

    public static Track create(byte[] shortNameBytes, byte[] nameBytes, byte configByte, byte reversedByte) {
        String shortName = ByteConverterUtil.bytesToString(shortNameBytes);
        String name = ByteConverterUtil.bytesToString(nameBytes);
        int config = ByteConverterUtil.byteToInt(configByte);
        boolean reversed = ByteConverterUtil.byteToBoolean(reversedByte);
        return new Track(shortName, name, config, reversed);
    }
}
