package map;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TMap {
    private List<Row> rows;
    private List<CellExplorer> explorers;
    private int laps;
    private Cell lastCell;
    private int hLength;
    private int vLength;

    public TMap() {
        this.rows = new ArrayList<>();
        this.explorers = new ArrayList<>();
        this.laps = 0;
        this.lastCell = new CellPlain(0, 0);
        this.hLength = 0;
        this.vLength = 0;
    }

    public TMap(List<Row> rows) {
        this.rows = rows;
    }

    public void initMap(int horizontal, int vertical) {
        this.hLength = horizontal;
        this.vLength = vertical;
        this.rows = IntStream.range(0, vertical).mapToObj(v -> new Row(
                IntStream.range(0, horizontal).mapToObj(h -> new CellPlain(h, v)).collect(Collectors.toList())
        )).collect(Collectors.toList());
    }

    public void modifCellType(Cell cell, int horizontal, int vertical) {
        this.rows.get(vertical).getCells().set(horizontal, cell);
    }

    public void play() {
        for(int i = 0; i < laps; i++) {
            for (CellExplorer explorer : this.explorers) {
                switch (explorer.getNextMove(i)) {
                    case "A":
                        this.moveForward(explorer);
                        break;
                    case "D":
                        this.turnRight(explorer);
                        break;
                    case "G":
                        this.turnLeft(explorer);
                        break;
                    default:
                }
            }
        }
    }

    private void moveForward(CellExplorer explorer) {
        switch (explorer.getOrientation()) {
            case "N":
                this.moveNorth(explorer);
                break;
            case "E":
                this.moveEast(explorer);
                break;
            case "O":
                this.moveWest(explorer);
                break;
            case "S":
                this.moveSouth(explorer);
                break;
        }
    }

    private void turnRight(CellExplorer explorer) {
        switch (explorer.getOrientation()) {
            case "N":
                explorer.setOrientation("E");
                break;
            case "E":
                explorer.setOrientation("S");
                break;
            case "O":
                explorer.setOrientation("N");
                break;
            case "S":
                explorer.setOrientation("O");
                break;
        }
    }

    private void turnLeft(CellExplorer explorer) {
        switch (explorer.getOrientation()) {
            case "N":
                explorer.setOrientation("O");
                break;
            case "E":
                explorer.setOrientation("N");
                break;
            case "O":
                explorer.setOrientation("S");
                break;
            case "S":
                explorer.setOrientation("E");
                break;
        }
    }

    private void moveNorth(CellExplorer explorer) {
        this.checkNextCell(explorer, explorer.getHorizontal(), explorer.getVertical() - 1);
    }

    private void moveEast(CellExplorer explorer) {
        this.checkNextCell(explorer, explorer.getHorizontal() + 1, explorer.getVertical());
    }

    private void moveWest(CellExplorer explorer) {
        this.checkNextCell(explorer, explorer.getHorizontal() - 1, explorer.getVertical());
    }

    private void moveSouth(CellExplorer explorer) {
        this.checkNextCell(explorer, explorer.getHorizontal(), explorer.getVertical() + 1);
    }

    private void checkNextCell(CellExplorer explorer, int horizontal, int vertical) {
        if(vertical < 0 || vertical > this.rows.toArray().length) {
            return;
        }

        if (horizontal < 0 || horizontal > this.rows.get(vertical).getCells().toArray().length) {
            return;
        }

        switch (this.rows.get(vertical).getCells().get(horizontal).getType()) {
            case P:
                CellPlain cellPlain = this.rows.get(vertical).getCells().get(horizontal).toCellPlain();
                Cell cellExplorer = this.rows.get(explorer.getVertical()).getCells().get(explorer.getHorizontal());
                cellExplorer.setHorizontal(horizontal);
                cellExplorer.setVertical(vertical);
                CellExplorer cEP = (CellExplorer) cellExplorer;
                this.modifCellType(cEP.getLastCell(), cEP.getLastCell().getHorizontal(), cEP.getLastCell().getVertical());
                this.modifCellType(cEP, cEP.getHorizontal(), cEP.getVertical());
                cEP.setLastCell(cellPlain);
                return;
            case T:
                Cell cellTreasure = this.rows.get(vertical).getCells().get(horizontal);
                Cell cellExplorerT = this.rows.get(explorer.getVertical()).getCells().get(explorer.getHorizontal());
                cellExplorerT.setHorizontal(horizontal);
                cellExplorerT.setVertical(vertical);
                CellExplorer cET = (CellExplorer) cellExplorerT;
                CellTreasure treasure = (CellTreasure) cellTreasure;
                if (treasure.getNbTreasure() > 0) {
                    treasure.setNbTreasure(treasure.getNbTreasure() - 1);
                    explorer.setTreasures(explorer.getTreasures() + 1);
                }
                this.modifCellType(cET.getLastCell(), cET.getLastCell().getHorizontal(), cET.getLastCell().getVertical());
                this.modifCellType(cET, cET.getHorizontal(), cET.getVertical());
                cET.setLastCell(treasure);
                return;
            case A:
            case M:
            default:
                return;
        }
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<CellExplorer> getExplorers() {
        return explorers;
    }

    public void setExplorers(List<CellExplorer> explorers) {
        this.explorers = explorers;
    }

    public void addExplorer(CellExplorer explorer) {
        this.explorers.add(explorer);
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        if(laps > this.laps)
            this.laps = laps;
    }

    public Cell getLastCell() {
        return lastCell;
    }

    public void setLastCell(Cell lastCell) {
        this.lastCell = lastCell;
    }

    public int gethLength() {
        return hLength;
    }

    public void sethLength(int hLength) {
        this.hLength = hLength;
    }

    public int getvLength() {
        return vLength;
    }

    public void setvLength(int vLength) {
        this.vLength = vLength;
    }
}


