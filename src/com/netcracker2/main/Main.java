package com.netcracker2.main;

import com.netcracker2.TextOutput.TextToScreen;
import com.netcracker2.comparator.ArchiverComparator;
import com.netcracker2.comparator.InputPath;
import com.netcracker2.comparator.Unpacking;
import com.netcracker2.corparatorExceptions.IncorrectArgsException;
import com.netcracker2.frame.PathFrame;
import com.netcracker2.writer.WriterDotTxt;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String path1 = null;
        String path2 = null;
        String firstFileName = null;
        String secondFileName = null;
        PathFrame chooser;
        Map<String, Long> firstZip;
        Map<String, Long> secondZip;
        InputPath inputPath1 = new InputPath();
        InputPath inputPath2 = new InputPath();
        Unpacking unpackFirstZip = new Unpacking();
        Unpacking unpackSecondZip = new Unpacking();
        ArchiverComparator comparator = new ArchiverComparator();
        WriterDotTxt writer = new WriterDotTxt();
        TextToScreen toScreen = new TextToScreen();

        try {
            if (args.length < 2) {
                chooser = new PathFrame();
                toScreen.printFirstArc();
                path1 = chooser.fileSelection().getPath();
                firstFileName = pathToName(path1);
                toScreen.printFileName(firstFileName);
                toScreen.printSecondArc();
                path2 = chooser.fileSelection().getPath();
                secondFileName = pathToName(path2);
                toScreen.printFileName(secondFileName);

            } else if (args.length == 2) {

                path1 = args[0];
                firstFileName = pathToName(path1);
                toScreen.printFileName(firstFileName);
                path2 = args[1];
                secondFileName = pathToName(path2);
                toScreen.printFileName(secondFileName);
            }

            firstZip = unpackFirstZip.unpackArchive(inputPath1.pathIsFile(path1));
            secondZip = unpackSecondZip.unpackArchive(inputPath2.pathIsFile(path2));
            writer.textFileName(path1);
            writer.filesNames(firstFileName);
            writer.line();
            writer.writer(comparator.compareFirstToSecond(firstZip, secondZip));
            writer.filesNames(secondFileName);
            writer.line();
            writer.writer(comparator.compareSecondToFirst(firstZip, secondZip));
            writer.flush();
            toScreen.finish();
        } catch (FileNotFoundException e) {
            toScreen.accessDenied();
        } catch (NullPointerException e) {
            toScreen.cancel();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IncorrectArgsException e) {
            toScreen.incorrectArgs();
        }
        finally {
            System.exit(0);
        }

    }

    private static String pathToName(String path) {
        return path.substring(path.lastIndexOf('\\') + 1, path.length());
    }
}
