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
package org.alexparej.lfs.mhr.header.element;

/**
 *
 * @author Alex
 */
public class Track {

    private String shortName;
    private String name;
    private int config;
    private boolean reversed;

    public Track(String shortName, String name, int config, boolean reversed) {
        this.shortName = shortName;
        this.name = name;
        this.config = config;
        this.reversed = reversed;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }

    public int getConfig() {
        return config;
    }

    public boolean isReversed() {
        return reversed;
    }

    @Override
    public String toString() {
        return "Track{" + "shortName=" + shortName + ", name=" + name + ", config=" + config + ", reversed=" + reversed + '}';
    }
}
