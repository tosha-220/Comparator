package com.netcracker2.comparator;

import com.netcracker2.corparatorExceptions.IncorrectArgsException;
import java.io.*;
import java.util.zip.ZipInputStream;


public class InputPath {

    private ZipInputStream zis;
    private File file;

    public ZipInputStream pathIsFile(String pathToArc) throws IncorrectArgsException, FileNotFoundException, NullPointerException {

        file = new File(pathToArc);

        if (file.exists()) {
            pathToZis(file);

        } else {
            throw new IncorrectArgsException();
        }

        return zis;
    }

    private void pathToZis(File file) throws FileNotFoundException {
        zis = new ZipInputStream(new FileInputStream(file));
    }


}
