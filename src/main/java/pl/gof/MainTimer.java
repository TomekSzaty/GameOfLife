package pl.gof;

import javax.swing.*;

public class MainTimer {
    private Timer timer;
    private final CellService cellService = CellService.getINSTANCE();
    private final MainCanvas mainCanvas = MainCanvas.getINSTANCE();

    public MainTimer() {

        timer = new Timer(200, e ->{
            cellService.update();
            mainCanvas.repaint();

        });
    }
    public void start() {
        timer.start();
    }
}
