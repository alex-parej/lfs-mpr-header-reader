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
package org.alexparej.lfs.mhr.mprelement;

/**
 *
 * @author Alex
 */
public enum Car {
     XFG(1),
     XRG(2),
     XRT(4),
     RB4(8),
     FXO(16),
     LX4(32),
     LX6(64),
     MRT(128),
     UF1(256),
     RAC(512),
     FZ5(1024),
     FOX(2048),
     XFR(4096),
     UFR(8192),
     F08(16384),
     FXR(32768),
     XRR(65536),
     FZR(131072),
     BF1(262144),
     FBM(524288);

    int value;

    private Car(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
