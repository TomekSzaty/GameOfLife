package pl.gof;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        setTitle("The Life Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        add(MainCanvas.getINSTANCE());
        pack();
        setLocationRelativeTo(null);

    }
}
