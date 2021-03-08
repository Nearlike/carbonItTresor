package model;

public class CellExplorer extends Cell {

    private static final CellType type = CellType.A;
    private String name;
    private String orientation;
    private String moves;
    private int treasures;
    private Cell lastCell;

    public CellExplorer(String name, String orientation, String moves, int horizontal, int vertical) {
        super(type, horizontal, vertical);
        this.name = name;
        this.orientation = orientation;
        this.moves = moves;
        this.treasures = 0;
        this.lastCell = new CellPlain(horizontal, vertical);
    }

    public String getNextMove(int i) {
        if (this.moves.split("").length > i)
            return this.moves.split("")[i];
        else
            return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public Cell getLastCell() {
        return lastCell;
    }

    public void setLastCell(Cell lastCell) {
        this.lastCell = lastCell;
    }

    @Override
    public String toString() {
        return super.getType() +
                " - " + name +
                " - " + super.getHorizontal() +
                " - " + super.getVertical() +
                " - " + orientation +
                " - " + treasures;
    }
}
