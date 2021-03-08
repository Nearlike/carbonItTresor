import map.TMap;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapTest {

    private TMap tMap;

    @Before
    public void setup() {
        tMap = new TMap();
    }

    @Test
    public void shouldInitMapWithPlainCell() {
        List<Row> rowsExpected = Arrays.asList(
                new Row(
                        Arrays.asList(
                            new CellPlain(0, 0),
                            new CellPlain(1, 0),
                            new CellPlain(2, 0))
                ),
                new Row(
                        Arrays.asList(
                            new CellPlain(0, 1),
                            new CellPlain(1, 1),
                            new CellPlain(2, 1))
                )
        );

        TMap TMapExpected = new TMap(rowsExpected);
        tMap.initMap(3, 2);

        assertEquals(TMapExpected.getRows(), tMap.getRows());
    }

    @Test
    public void shouldModifCellTypeByGivenMoutainType() {
        List<Row> rowsExpected = Arrays.asList(
                new Row(
                        Arrays.asList(
                                new CellPlain(0, 0),
                                new CellPlain(1, 0),
                                new CellPlain(2, 0))
                ),
                new Row(
                        Arrays.asList(
                                new CellPlain(0, 1),
                                new CellMountain(1, 1),
                                new CellPlain(2, 1))
                )
        );

        TMap TMapExpected = new TMap(rowsExpected);
        tMap.initMap(3, 2);
        tMap.modifCellType(new CellMountain(1, 1), 1, 1);

        assertEquals(TMapExpected.getRows(), tMap.getRows());
    }

    @Test
    public void shouldModifCellByTreasureCell() {
        List<Row> rowsExpected = Arrays.asList(
                new Row(
                        Arrays.asList(
                                new CellPlain(0, 0),
                                new CellPlain(1, 0),
                                new CellPlain(2, 0))
                ),
                new Row(
                        Arrays.asList(
                                new CellPlain(0, 1),
                                new CellTreasure(1, 1, 2),
                                new CellPlain(2, 1))
                )
        );

        TMap TMapExpected = new TMap(rowsExpected);
        CellTreasure cellTreasure = new CellTreasure(1, 1, 2);
        tMap.initMap(3,2);
        tMap.modifCellType(cellTreasure, 1, 1);

        assertEquals(TMapExpected.getRows(), tMap.getRows());
    }

    @Test
    public void shouldModifCellByExplorerCell() {
        String name = "jean";
        String orientation = "N";
        String moves = "AAGADA";
        List<Row> rowsExpected = Arrays.asList(
                new Row(
                        Arrays.asList(
                                new CellPlain(0, 0),
                                new CellPlain(1, 0),
                                new CellPlain(2, 0))
                ),
                new Row(
                        Arrays.asList(
                                new CellPlain(0, 1),
                                new CellExplorer(name, orientation, moves, 1, 1),
                                new CellPlain(2, 1))
                )
        );

        TMap TMapExpected = new TMap(rowsExpected);
        CellExplorer cellExplorer = new CellExplorer(name, orientation, moves, 1, 1);
        tMap.initMap(3, 2);
        tMap.modifCellType(cellExplorer, 1, 1);

        assertEquals(TMapExpected.getRows(), tMap.getRows());
    }
}
