package com.netcracker2.TextOutput;


public class TextToScreen {

    public void printFirstArc() {
        System.out.println("Enter first archive path.");
    }

    public void printSecondArc() {
        System.out.println("Enter second archive path.");
    }

    public void cancel() {
        System.out.println("Cancelled.");
    }

    public void finish() {
        System.out.println("Find the result of comparing two archives on the path of the first archive in text.txt.");
    }

    public void accessDenied() {
        System.out.println("Error writing file .txt. Access denied. Change path of first file.");
    }

    public void incorrectArgs() {
        System.out.println("Path to file is not correct or first file is located in only for reading path. Enter correct path to archives in programm arguments.");
    }

    public void printFileName(String name) {
        System.out.println(name);
    }

    public void notArchvive() {
        System.out.println("Enter zip or jar file.");
    }
}
