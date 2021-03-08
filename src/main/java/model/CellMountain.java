package model;

public class CellMountain extends Cell {
    private static final CellType type = CellType.M;

    public CellMountain(int horizontal, int vertical) {
        super(type, horizontal, vertical);
    }

    @Override
    public Cell getLastCell() {
        return null;
    }
}
