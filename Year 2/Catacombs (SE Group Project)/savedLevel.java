import java.util.ArrayList;

/**
 * This class represents all the current information about the saved game.
 * @author Mekid, Sam Mocock
 * @version 1.0
 */
public class savedLevel {
    private int width;
    private int height;
    private int actionTiles;
    private ArrayList<FixedFileTile> ffts;
    private ArrayList<MovingFileTile> mfts;
    private Bag<Tile> silkBag;
    private ArrayList<int[]> startPos;
    private ArrayList<Player> players;


    /**
     * Creates a saved level with the necessary information.
     * @param width Width of board.
     * @param height Height of board.
     * @param ffts Fixed file tiles.
     * @param mfts Moving file tiles.
     * @param silkBag Silk bag.
     * @param players ArrayList of players.
     * @param startPos Starting positions of players.
     */
    public savedLevel(int width, int height, ArrayList<FixedFileTile> ffts, ArrayList<MovingFileTile> mfts,
                      Bag<Tile> silkBag, ArrayList<Player> players,  ArrayList<int[]> startPos) {
        this.width = width;
        this.height = height;
        this.ffts = ffts;
        this.mfts = mfts;
        this.silkBag = silkBag;
        this.startPos = startPos;
        this.players = players;
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

    public ArrayList<MovingFileTile> getMfts(){
        return mfts;
    }

    //public ArrayList<MovingFileTile> getMfts(){
    //    return mfts;
    //}

    public Bag<Tile> getSilkBag() {
        return silkBag;
    }

    

    public ArrayList<int[]> getStartPos() {
        return startPos;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    /**
     * @return a string for testing
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
