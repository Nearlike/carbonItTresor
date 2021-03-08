package model;

import java.util.List;
import java.util.Objects;

public class Row {
    private List<Cell> cells;

    public Row(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(cells, row.cells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cells);
    }
}
