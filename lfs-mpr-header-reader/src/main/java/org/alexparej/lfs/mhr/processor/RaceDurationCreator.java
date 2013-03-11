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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import org.alexparej.lfs.mhr.header.element.RaceDuration;
import org.alexparej.lfs.mhr.reader.ByteConverterUtil;

/**
 *
 * @author Alex
 */
public final class RaceDurationCreator {

    private static int calculateLaps(int lapsByte) {
        if (!isPractice(lapsByte) && lapsByte <= 190) {
            if (lapsByte < 100) {
                return lapsByte;
            } else {
                return (lapsByte - 100) * 10 + 100;
            }
        }
        return 0;
    }

    private static int calculateHours(int lapsByte) {
        if (!isPractice(lapsByte) && lapsByte > 190) {
            return lapsByte - 190;
        }
        return 0;
    }

    private static boolean isPractice(int lapsByte) {
        return lapsByte == 0;
    }

    public static RaceDuration create(byte[] startTimeBytes, byte lapsByte) {
        ByteBuffer startTimeByteBuffer = ByteBuffer.wrap(startTimeBytes);
        startTimeByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long startTime = startTimeByteBuffer.getInt() * 1000l;
        int lapsByteInt = ByteConverterUtil.byteToInt(lapsByte);
        return new RaceDuration(new Date(startTime), calculateLaps(lapsByteInt), calculateHours(lapsByteInt));
    }
}
