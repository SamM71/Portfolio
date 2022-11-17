import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents the file reader that gets all the information needed to create a level object.
 * @author Sam Mocock
 * @version 1.0
 */
public class LevelFileReader {

    /**
     * Creates a file reader.
     * @return A level object.
     */
    public static Level fileReader() {
        Scanner in;
        try {
            File f = new File("src/paris.txt");
            in = new Scanner(f);
            return fileScanner(in);
        } catch (FileNotFoundException e) {

            System.out.println("file not found");
            return null;
        }
    }

    /**
     * Reads all the data from the level file and creates a level object.
     * @param f Scanner.
     * @return A level object.
     */
    private static Level fileScanner(Scanner f) {
        String nextLine = f.nextLine();
        Scanner str = new Scanner(nextLine).useDelimiter(",");

        int width = str.nextInt();
        int height = str.nextInt();

        str.close();

        int amtOfFixed = f.nextInt();
        //Info about fixed tiles
        ArrayList<FixedFileTile> ffts = new ArrayList<>();
        for (int i = 0; i < amtOfFixed + 1; i++) {
            String fixedTilesScanner = f.nextLine();
            Scanner fixedTilesStr = new Scanner(fixedTilesScanner).useDelimiter(",");
            while (fixedTilesStr.hasNext()) {
                int x = fixedTilesStr.nextInt();
                int y = fixedTilesStr.nextInt();
                String type = fixedTilesStr.next();
                int orientation = fixedTilesStr.nextInt();
                FixedFileTile fft = new FixedFileTile(x, y, type, orientation);
                ffts.add(fft);
            }
            fixedTilesStr.close();
        }
        int amtOfFloor = f.nextInt();
        Bag<Tile> silkBag = new Bag<Tile>();
        Random rand = new Random();
        //Add floor tiles to bag
        for (int i = 0; i < amtOfFloor + 1; i++) {
            String floorType = f.nextLine();
            switch (floorType) {
                case "CORNER":
                    Tile corner = new Corner(rand.nextInt(3), false);
                    silkBag.addTile(corner);
                    break;
                case "T-SHAPED":
                    Tile tShape = new T_Shape(rand.nextInt(3), false);
                    silkBag.addTile(tShape);
                    break;
                case "STRAIGHT":
                    Tile straight = new Straight(rand.nextInt(3), false);
                    silkBag.addTile(straight);
                    break;
            }
        }

        int amtOfAction = f.nextInt();

        //Add action tiles to bag
        for (int i = 0; i < amtOfAction + 1; i++) {
            String actionType = f.nextLine();
            switch (actionType) {
                case "ICE":
                    Tile ice = new Freeze();
                    silkBag.addTile(ice);
                    break;
                case "FIRE":
                    Tile fire = new Fire();
                    silkBag.addTile(fire);
                    break;
                case "DOUBLE MOVE":
                    Tile doubleMove = new DoubleAction();
                    silkBag.addTile(doubleMove);
                    break;
                case "BACKTRACK":
                    Tile backtrack = new BackTrack();
                    silkBag.addTile(backtrack);
                    break;
            }
        }


        ArrayList<int[]> startPos = getStart(f);

        Level level = new Level(width, height, ffts, amtOfAction, silkBag, startPos);

        return level;
    }

    /**
     * Gets the starting positions of all the players.
     * @param f Scanner.
     * @return An array list containing the starting positions of the players.
     */
    private static ArrayList<int[]> getStart(Scanner f) {
        ArrayList<int[]> startingPositions = new ArrayList<int[]>();

        for (int i = 0; i < 4; i++) {
            String startingPosScanner = f.nextLine();
            Scanner startingPosString = new Scanner(startingPosScanner).useDelimiter(",");

            int startX = startingPosString.nextInt();
            int startY = startingPosString.nextInt();

            startingPositions.add(new int[]{startX,startY});
        }
        return startingPositions;
    }
}
