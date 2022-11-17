/**
 * This class represents the fixed tiles that are read from the level file.
 * @author Sam Mocock
 * @version 1.0
 */
public class FixedFileTile {
    private int x;
    private int y;
    private String type;
    private int orientation;

    public FixedFileTile(int x, int y, String type, int orientation) {
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
