/**
 * This class represents tiles from the level file that can move.
 * @author Mekid
 * @version 1.0
 */
public class MovingFileTile {
    private int x;
    private int y;
    private String type;
    private int orientation;

    /**
     * Creates an object
     * @param x X position
     * @param y Y position
     * @param type Tile type
     * @param orientation Orientation of tile
     */
    public MovingFileTile(int x, int y, String type, int orientation) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public int getOrientation() {
        return orientation;
    }
}
