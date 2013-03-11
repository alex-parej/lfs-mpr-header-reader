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

import java.util.BitSet;
import java.util.EnumSet;
import org.alexparej.lfs.mhr.header.element.Car;

/**
 *
 * @author Alex
 */
public final class AllowedCarsCreator {

    private AllowedCarsCreator() {
    }

    public static EnumSet<Car> create(byte[] allowedCarsBytes) {
        EnumSet<Car> allowedCars = EnumSet.noneOf(Car.class);
        BitSet bitSet = BitSet.valueOf(allowedCarsBytes);
        for (Car car : Car.values()) {
            if (bitSet.get(Integer.numberOfTrailingZeros(car.getValue()))) {
                allowedCars.add(car);
            }
        }
        return allowedCars;
    }
}
