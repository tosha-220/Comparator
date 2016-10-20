package com.netcracker2.writer;

import java.io.*;
import java.util.ArrayList;


public class WriterDotTxt {


    private FileWriter fileWriter;

    public void textFileName(final String path) throws IOException {

        fileWriter = new FileWriter(path.substring(0, path.lastIndexOf('\\') + 1) + "text.txt");

    }

    public void filesNames(final String substring) throws IOException {
        fileWriter.write(substring);
        lineSeparator();
    }

    public void writer(final ArrayList<String> list) throws IOException {
        for (String s : list) {
            fileWriter.write(s);
            lineSeparator();
        }
        lineSeparator();
    }

    public void flush() throws IOException {
        fileWriter.flush();
    }

    private void lineSeparator() throws IOException {
        fileWriter.write(System.getProperty("line.separator"));
    }

    public void line() throws IOException {
        fileWriter.write("--------------");
        lineSeparator();
    }
}
