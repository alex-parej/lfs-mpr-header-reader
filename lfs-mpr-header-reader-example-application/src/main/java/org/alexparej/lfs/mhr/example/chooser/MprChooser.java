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
package org.alexparej.lfs.mhr.example.chooser;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class MprChooser {

    private File baseDir;
    private File[] mprs;
    private String menu;

    public MprChooser(File baseDir) {
        this.baseDir = baseDir;
        readMprFiles();
        buildMenu();
    }

    private void readMprFiles() {
        mprs = baseDir.listFiles(new MprFileNameFilter());
    }

    private void buildMenu() {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(baseDir.getAbsoluteFile());
        sb.append(File.separatorChar);
        sb.append("...");
        sb.append(getSystemLineSeparator());
        if (mprs.length < 1) {
            sb.append("There aren't any MPR files here!");
        } else {
            for (File file : mprs) {
                sb.append("[");
                sb.append(i++);
                sb.append("] ");
                sb.append(file.getName());
                sb.append(getSystemLineSeparator());
            }
        }
        menu = sb.toString();
    }

    private String getSystemLineSeparator() {
        return System.getProperty("line.separator");
    }

    public void rescan() {
        readMprFiles();
        buildMenu();
    }

    public void display() {
        System.out.println(menu);
    }

    public File choose() {
        if (!isThereAvailableMpr()) {
            throw new IllegalStateException("There isn't available MPR file!");
        }
        int index = 0;
        do {
            index = readInt();
        } while (index < 1 || index > mprs.length);
        return mprs[index - 1];
    }

    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    public boolean isThereAvailableMpr() {
        return mprs.length > 0;
    }
}
