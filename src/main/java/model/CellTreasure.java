package model;

public class CellTreasure extends Cell {

    private static final CellType type = CellType.T;
    private int nbTreasure;

    public CellTreasure(int horizontal, int vertical, int nbTreasure) {
        super(type, horizontal, vertical);
        this.nbTreasure = nbTreasure;
    }

    public int getNbTreasure() {
        return nbTreasure;
    }

    public void setNbTreasure(int nbTreasure) {
        this.nbTreasure = nbTreasure;
    }

    @Override
    public String toString() {
        return super.getType() +
                " - " + super.getHorizontal() +
                " - " + super.getVertical() +
                " - " + nbTreasure;
    }

    @Override
    public Cell getLastCell() {
        return null;
    }
}
