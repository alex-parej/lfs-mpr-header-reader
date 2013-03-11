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

import org.alexparej.lfs.mhr.header.element.WeatherCondition;
import org.alexparej.lfs.mhr.header.element.Wind;
import org.alexparej.lfs.mhr.reader.ByteConverterUtil;

/**
 *
 * @author Alex
 */
public final class WeatherConditionCreator {

    private WeatherConditionCreator() {
    }

    public static WeatherCondition create(byte windByte, byte weatherByte) {
        Wind wind = Wind.values()[ByteConverterUtil.byteToInt(windByte)];
        return new WeatherCondition(wind, ByteConverterUtil.byteToInt(weatherByte));
    }
}
