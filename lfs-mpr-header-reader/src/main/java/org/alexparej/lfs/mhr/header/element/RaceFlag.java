/*
 * Copyright Error: on line 4, column 29 in Templates/Licenses/license-apache20.txt
 Expecting a date here, found: 2013.03.06. Alex.
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
package org.alexparej.lfs.mhr.header.element;

/**
 *
 * @author Alex
 */
public enum RaceFlag {

    ALLOW_VOTE_KICK_BAN(1),
    ALLOW_GUESTS_TO_SELECT_TRACKS(2),
    ALLOW_MID_RACE_JOIN(32),
    PIT_STOP_REQUIRED(64),
    ALLOW_CAR_RESET(128),
    FORCE_COCKPIT_VIEW(256),
    CRUISE_WRONG_WAY_ALLOWED(512);
    int value;

    private RaceFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
