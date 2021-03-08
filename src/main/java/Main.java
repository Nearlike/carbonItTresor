import map.TMap;
import model.CellExplorer;
import model.CellMountain;
import model.CellTreasure;
import utils.ReadFile;

public class Main {

    public static void main(String[] args) {
        TMap tMap = new TMap();
        String actions = ReadFile.read("config.txt");

        String[] splittedActions = actions.split("/");

        for (String action : splittedActions) {
            String[] actionSplit = action.split(" - ");
            switch (actionSplit[0]) {
                case "C":
                    tMap.initMap(Integer.parseInt(actionSplit[1]), Integer.parseInt(actionSplit[2]));
                    break;
                case "M":
                    CellMountain cellMountain = new CellMountain(Integer.parseInt(actionSplit[1]), Integer.parseInt(actionSplit[2]));
                    tMap.modifCellType(cellMountain, Integer.parseInt(actionSplit[1]), Integer.parseInt(actionSplit[2]));
                    break;
                case "T":
                    CellTreasure cellTreasure = new CellTreasure(Integer.parseInt(actionSplit[1]), Integer.parseInt(actionSplit[2]), Integer.parseInt(actionSplit[3]));
                    tMap.modifCellType(cellTreasure, Integer.parseInt(actionSplit[1]), Integer.parseInt(actionSplit[2]));
                    break;
                case "A":
                    CellExplorer cellExplorer = new CellExplorer(actionSplit[1], actionSplit[4], actionSplit[5], Integer.parseInt(actionSplit[2]), Integer.parseInt(actionSplit[3]));
                    tMap.modifCellType(cellExplorer, Integer.parseInt(actionSplit[2]), Integer.parseInt(actionSplit[3]));
                    tMap.addExplorer(cellExplorer);
                    tMap.setLaps(actionSplit[5].split("").length);
                    break;
                default :
                    break;
            }
        }
        tMap.play();
        ReadFile.write(tMap);
    }
}
