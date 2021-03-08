package utils;

import map.TMap;
import model.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    public static String read(String fileName) {
        try (Stream stream = Files.lines(Paths.get(fileName))) {
            return (String) stream.map(Object::toString).collect(Collectors.joining("/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(TMap tMap) {
        Path path = Paths.get("output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            List<Cell> c = tMap.getRows().stream()
                    .flatMap(row -> row.getCells().stream())
                    .filter(cell -> cell.getType() == CellType.M
                            || cell.getType() == CellType.T
                            || cell.getType() == CellType.A)
                    .collect(Collectors.toList());

            writer.write("C - " + tMap.gethLength() + " - " + tMap.getvLength() + "\n");
            c.stream()
                    .filter(cell -> cell instanceof CellMountain)
                    .forEach(s -> {
                        try {
                            writer.write(s.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            writer.write("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}\n");
            c.stream()
                    .filter(cell -> cell instanceof CellTreasure)
                    .forEach(s -> {
                        try {
                            writer.write(s.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            writer.write("# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}\n");
            c.stream()
                    .filter(cell -> cell instanceof CellExplorer)
                    .forEach(s -> {
                        try {
                            writer.write(s.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
