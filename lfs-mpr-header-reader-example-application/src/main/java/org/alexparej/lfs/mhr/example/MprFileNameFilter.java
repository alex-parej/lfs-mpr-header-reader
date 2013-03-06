/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alexparej.lfs.mhr.example;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Alex
 */
public class MprFileNameFilter implements FilenameFilter {

    private static final String EXTENSION = ".mpr";

    public boolean accept(File dir, String name) {
        return !new File(dir, name).isDirectory() && name.toLowerCase().endsWith(EXTENSION);
    }
}
