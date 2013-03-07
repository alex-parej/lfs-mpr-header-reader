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
public enum PlayerRecord implements Record {

    PLAYER_NAME(0, Type.CHAR, 24),
    NUMBER_PLATE(24, Type.CHAR, 8),
    SHORT_CAR_NAME(32, Type.CHAR, 4),
    LFS_USER_NAME(36, Type.CHAR, 24),
    LAPS_DONE(60, Type.WORD),
    PLAYER_FLAGS(62, Type.WORD),
    CONFIRM_FLAGS(64, Type.BYTE),
    NUMBER_OF_STOPS(65, Type.BYTE),
    PENALTY_SECONDS(66, Type.WORD),
    OVERALL_TIME(68, Type.INT),
    BEST_LAP_TIME(72, Type.INT),
    START_POSITION(77, Type.BYTE),
    HANDICAP_MASS(78, Type.BYTE),
    INTAKE_RESTRICTION(79, Type.BYTE);
    private int offset;
    private Type type;
    private int length;

    private PlayerRecord(int offset, Type type) {
        this.offset = offset;
        this.type = type;
        this.length = 1;
    }

    private PlayerRecord(int offset, Type type, int length) {
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
