package pl.gof;

import java.awt.*;

public class MainCanvas extends Canvas {

    private static final MainCanvas INSTANCE = new MainCanvas();

    private final CellService cellService = CellService.getINSTANCE();

    public static MainCanvas getINSTANCE() {
        return INSTANCE;
    }

    private MainCanvas() {
        setSize(Config.COLS * Config.SIZE, Config.ROWS * Config.SIZE);
    }

    @Override
    public void paint(Graphics g) {
        for (Cell cell : cellService.getAllCells()) {

            if (cell.isLife()) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.WHITE);
            }

            int x = cell.getX() * Config.SIZE;
            int y = cell.getY() * Config.SIZE;

            g.fillRect(x, y, Config.SIZE - 1, Config.SIZE - 1);
        }
    }
}
