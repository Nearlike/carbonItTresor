package model;

import java.util.Objects;

public abstract class Cell {

    private CellType type;
    private int horizontal;
    private int vertical;

    public Cell(CellType type, int horizontal, int vertical) {
        this.type = type;
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return type == cell.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type +
                " - " + horizontal +
                " - " + vertical;
    }

    public CellPlain toCellPlain(){
        return new CellPlain(this.horizontal, this.vertical);
    };

    public abstract Cell getLastCell();

}
