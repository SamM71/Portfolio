import java.util.ArrayList;

/**
 * This class represent the all the information about the level at the start of the game.
 * @author Sam Mocock
 * @version 1.0
 */
public class Level {
    private int width;
    private int height;
    private int actionTiles;
    private ArrayList<FixedFileTile> ffts;
    private Bag<Tile> silkBag;
    private ArrayList<int[]> startPos;

    /**
     * Creates a level and sets the necessary attributes.
     * @param width The width of the board.
     * @param height The height of the board.
     * @param ffts The fixed floor tiles that go on the board.
     * @param actionTiles The number of action tiles that go in the bag.
     * @param silkBag The silk bag.
     * @param startPos The starting positions of each player.
     */
    public Level(int width, int height, ArrayList<FixedFileTile> ffts, int actionTiles, Bag<Tile> silkBag,
                 ArrayList<int[]> startPos) {
        this.width = width;
        this.height = height;
        this.actionTiles = actionTiles;
        this.ffts = ffts;
        this.silkBag = silkBag;
        this.startPos = startPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getActionTiles(){
        return actionTiles;
    }

    public ArrayList<FixedFileTile> getFfts() {
        return ffts;
    }

    public Bag<Tile> getSilkBag() {
        return silkBag;
    }

    public ArrayList<int[]> getStartPos() {
        return startPos;
    }

    /**
     * Creates a string to represent the level object (only used for testing).
     * @return a string for testing.
     */
    public String toString() {
        String str = getWidth() + ", " + getHeight() +'\n';
        str += getFfts().toString() + '\n';
        str += getActionTiles() + '\n';
        str += getSilkBag().toString() +'\n';
        str += getStartPos().toString();
        return str;
    }
}
