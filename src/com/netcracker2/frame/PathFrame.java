package com.netcracker2.frame;

import com.netcracker2.TextOutput.TextToScreen;

import javax.swing.*;
import java.io.File;


public class PathFrame extends JFrame {
    private File file;
    private JFileChooser dialog;
    private TextToScreen toScreen = new TextToScreen();

    public File fileSelection() {

        dialog = new JFileChooser();
        dialog.showOpenDialog(this);
        file = dialog.getSelectedFile();

        if (file.getName().endsWith(".zip") || file.getName().endsWith(".jar")) {
            return file;
        } else {
            toScreen.notArchvive();
            fileSelection();
        }

        return file;
    }
}
