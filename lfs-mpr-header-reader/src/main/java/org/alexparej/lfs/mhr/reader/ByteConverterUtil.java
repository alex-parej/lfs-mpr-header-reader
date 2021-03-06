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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Alex
 */
public final class ByteConverterUtil {

    private ByteConverterUtil() {
    }

    public static String bytesToString(byte[] bytes) {
        return new String(bytes).trim();
    }

    public static int byteToInt(byte b) {
        return b & 0xFF;
    }

    public static int bytesToInt(byte[] b) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(b);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getInt();
    }

    public static boolean byteToBoolean(byte b) {
        return b != 0;
    }
}
