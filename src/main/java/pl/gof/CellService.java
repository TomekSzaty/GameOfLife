package pl.gof;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import static pl.gof.Config.COLS;
import static pl.gof.Config.ROWS;

public class CellService {

    private final List<Cell> cells = new ArrayList<>();

    private static final CellService INSTANCE = new CellService();

    public static CellService getINSTANCE() {
        return INSTANCE;
    }

    private CellService() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells.add(new Cell(j, i));
            }
        }
        try {
            populate();
        } catch (IOException e) {
            System.out.println("Problem with read file");
        }
        getByCords(11, 11).setLife(true);
    }

    private void populate() throws IOException {
        //String fileName = "dart.cells";
        //String fileName = "dragon.cells";
        String fileName = "snail.cells";

        int y = 60;

        for (String line : Files.readAllLines(Paths.get(fileName))) {
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'O') {
                    getByCords(x, y).setLife(true);
                }
            }
            y++;
        }
    }

    public Cell getByCords(int x, int y) {
        return cells.stream()
                .filter(cell -> cell.getX() == x && cell.getY() == y)
                .findFirst().orElse(null);
    }

    public List<Cell> getAllCells() {
        return cells;
    }

    public void update() {
        List<Cell> newCells = new ArrayList<>();
        List<Cell> deathCells = new ArrayList<>();

        for (Cell cell : cells) {
            long lifeNeighbour = cells.stream()
                    .filter(cell::isNeighbour)
                    .filter(Cell::isLife)
                    .count();

            if (cell.isLife()) {
                if (lifeNeighbour < 2 || lifeNeighbour > 3) {
                    deathCells.add(cell);
                }
            } else {
                if (lifeNeighbour == 3) {
                    newCells.add(cell);
                }
            }
        }
        for (Cell cell : deathCells) {
            cell.setLife(false);
        }
        for (Cell cell : newCells) {
            cell.setLife(true);
        }
    }
}
