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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.alexparej.lfs.mhr.header.record.HeaderRecord;

/**
 *
 * @author Alex
 */
public final class MprHeaderBytesReader {

    private static final String LFSMPR = "LFSMPR";
    private static final int SIZE_GENERAL_INFOS = 80;
    private static final int SIZE_FINISHED_PLAYER = 80;
    private static final int OFFSET_FINISHED_PLAYER = 75;
    private byte replayDescription[] = new byte[SIZE_GENERAL_INFOS];
    private byte result[][];

    private MprHeaderBytesReader() {
    }

    public MprHeaderBytesReader(File mprFile) throws FileNotFoundException, IOException, IllegalArgumentException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(mprFile));
        readReplayDescription(inputStream);
        if (!isValidMpr()) {
            throw new IllegalArgumentException("Not a valid MPR file!");
        }
        readResult(inputStream);
        inputStream.close();
    }

    private boolean isValidMpr() {
        byte[] testLfsMpr = Arrays.copyOfRange(replayDescription, 0, LFSMPR.length());
        return LFSMPR.equals(new String(testLfsMpr));
    }

    private void readReplayDescription(BufferedInputStream inputStream) throws IOException {
        inputStream.read(replayDescription);
    }

    private void readResult(BufferedInputStream inputStream) throws IOException {
        short finishedPlayers = replayDescription[OFFSET_FINISHED_PLAYER];
        result = new byte[finishedPlayers][SIZE_FINISHED_PLAYER];
        for (int i = 0; i < finishedPlayers; i++) {
            byte[] player = new byte[SIZE_FINISHED_PLAYER];
            inputStream.read(player);
            result[i] = player;
        }
    }

    public byte[] get(HeaderRecord record) {
        return Arrays.copyOfRange(replayDescription, record.getOffset(), record.getOffset() + (record.getLength() * record.getType().getSize()));
    }
    
}
