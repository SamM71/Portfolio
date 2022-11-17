/**
 * Text.java
 * @version 1.0.0
 * @author Mocock
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Text is a text shape that can be drawn to the screen, either
 * filled with colour or opaque.
 */
public class Text extends ClosedShape {
    private String str;
    private int maxWidth;

    /**
     * Creates a square.
     * @param insertionTime When to insert the text.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param str The text to be displayed.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     * @param maxWidth The maximum width of the string.
     */
    public Text (int insertionTime, int x, int y, int vx, int vy, String str, Color colour, boolean isFilled, int maxWidth) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.str = str;
        this.maxWidth = maxWidth;
    }

    /**
     * Method to convert the text shape to a string.
     * @return a string
     */
    public String toString () {
        String result = "This is a piece of text\n";
        result += super.toString ();
        result += "It says: " + this.str + "\n";
        result += "Its maximum width is " + this.maxWidth + "\n";
        return result;
    }

    /**
     * @param maxWidth Resets the max width.
     */
    public void setMaxWidth (int maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * @return The maximum width of the text.
     */
    public int getMaxWidth() {
        return maxWidth;
    }

    /**
     * Draw the text.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillText( str, x, y, maxWidth);
        }
        else {
            g.strokeText( str, x, y, maxWidth );
        }
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getWidth() {
        return maxWidth;
    }

    public int getHeight() {
        return maxWidth;
    }
}
