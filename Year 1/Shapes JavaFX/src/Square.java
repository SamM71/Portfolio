/**
 * Square.java
 * @version 1.0.0
 * @author Mocock
 */


import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Square is a square shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 */
public class Square extends ClosedShape {
    private int side; //length of each side

    /**
     * Creates a square.
     * @param insertionTime When to insert the square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side length of the square (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /**
     * Method to convert an square to a string.
     * @return a string
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side length is " + this.side + "\n";
        return result;
    }

    /**
     * @param side Resets the height.
     */
    public void setSide (int side) {
        this.side = side;
    }

    /**
     * @return The side length of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * Draw the square.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side );
        }
        else {
            g.strokeRect( x, y, side, side );
        }
    }

    public int getWidth() {
        return side;
    }

    public int getHeight() {
        return side;
    }
}
