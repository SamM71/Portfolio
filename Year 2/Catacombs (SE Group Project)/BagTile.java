/**
 * This class represents the linked list elements that go in the silk bag.
 * @author Sam Mocock
 * @version 1.0
 * @param <Tile>
 */
public class BagTile<Tile> {
    private Tile element;
    private BagTile<Tile> nextElement;

    /**
     * Creates a bag tile with an element and a next element.
     * @param el The current element.
     * @param next The next element.
     */
    public BagTile(Tile el, BagTile<Tile> next) {
        this.element = el;
        this.nextElement = next;
    }

    public void setElement(Tile el) {
        this.element = el;
    }

    public void setNextElement(BagTile<Tile> next) {
        this.nextElement = next;
    }

    public Tile getElement() {
        return this.element;
    }

    public BagTile<Tile> getNextElement() {
        return this.nextElement;
    }
}
