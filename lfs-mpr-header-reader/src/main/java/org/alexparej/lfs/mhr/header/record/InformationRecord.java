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
package org.alexparej.lfs.mhr.header.record;

/**
 *
 * @author Alex
 */
public enum InformationRecord implements Record{

    LFSMPR(0, Type.CHAR, 6),
    IMMEDIATE_START(9, Type.BYTE),
    RULES(9, Type.INT),
    FLAGS(16, Type.INT),
    LAPS_BYTE(20, Type.BYTE),
    SKILL(21, Type.BYTE),
    WIND(22, Type.BYTE),
    NUM_PLAYERS(23, Type.BYTE),
    LFS_VERSION(24, Type.CHAR, 8),
    SHORT_TRACK_NAME(32, Type.CHAR, 4),
    START_TIME(36, Type.INT),
    TRACK_NAME(40, Type.CHAR, 32),
    CONFIG(72, Type.BYTE),
    WEATHER(74, Type.BYTE);
    private int offset;
    private Type type;
    private int length;

    private InformationRecord(int offset, Type type) {
        this.offset = offset;
        this.type = type;
        this.length = 1;
    }

    private InformationRecord(int offset, Type type, int length) {
        this.offset = offset;
        this.type = type;
        this.length = length;
    }

    public int getOffset() {
        return offset;
    }

    public Type getType() {
        return type;
    }

    public int getLength() {
        return length;
    }
}
