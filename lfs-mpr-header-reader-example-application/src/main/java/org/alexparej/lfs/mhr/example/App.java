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
package org.alexparej.lfs.mhr.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.alexparej.lfs.mhr.MprHeaderReader;
import org.alexparej.lfs.mhr.example.chooser.MprChooser;

public class App {

    public static void main(String[] args) {
        try {
            File mprFolder = new File("C:\\LFS\\data\\mpr\\");
            MprChooser chooser = new MprChooser(mprFolder);
            chooser.display();
            if (chooser.isThereAvailableMpr()) {
                File file = chooser.choose();
                MprHeaderReader reader = new MprHeaderReader(file);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readMprIndex() {
    }
}
