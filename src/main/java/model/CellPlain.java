package model;

public class CellPlain extends Cell {
    private static final CellType type = CellType.P;

    public CellPlain(int horizontal, int vertical) {
        super(type, horizontal, vertical);
    }

    @Override
    public Cell getLastCell() {
        return null;
    }
}
