package org.alexparej.lfs.mhr.example;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        File mprFolder = new File("C:\\LFS\\data\\mpr\\");
        File[] listFiles = mprFolder.listFiles(new MprFileNameFilter());
        int i = 1;
        for (File file : listFiles) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(i++);
            sb.append("] ");
            sb.append(file.getName());
            System.out.println(sb);
        }
    }
}
