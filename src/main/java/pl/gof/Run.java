package pl.gof;

import java.awt.*;

public class Run {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);

            MainTimer mainTimer = new MainTimer();
            mainTimer.start();
        });
    }
}
