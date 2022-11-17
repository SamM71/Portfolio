import java.util.NoSuchElementException;
import java.util.LinkedList;
/**
 * This class represents the silk bag that contains the floor and action tiles.
 * Implemented similar to a linked list.
 * @author Sam Mocock
 * @version 1.0
 * @param <T> Tile
 */
public class Bag<T> {
	private BagTile<Tile> head;
	private BagTile<Tile> tail;

	/**
	 * Create a bag and set both the head and tail to null.
	 */
	public Bag() {
		this.head = null;
		this.tail = null;
	}

	/**
	 * Set the tail of the linked list.
	 * @return Tail of linked list
	 */
	private BagTile<Tile> tail() {
		tail = head;
		while (tail.getNextElement() != null) {
			tail = tail.getNextElement();
		}
		return tail;
	}

	/**
	 * Gets a tile and removes it from the bag.
	 * @return The element at position n.
	 */
	public Tile getTile() {
		if (isEmpty()) {
			System.out.println("Can't get tile from empty bag");
			return null;
		}
		BagTile<Tile> curItem = head;
		this.head = curItem.getNextElement();
		return curItem.getElement();
	}

	/**
	 * Called by Gameboard class at the start of the game.
	 * @return floor tile.
	 */
	public Tile getFloorTile() {
		if (this.isEmpty()) {
			System.out.println("Can't get tile from empty bag");
			return null;
		}
		BagTile<Tile> curItem = head;
		if (curItem.getElement().getTileType().equals("Floor")) {
			head = curItem.getNextElement();
			return curItem.getElement();
		}
		//While not a floor tile
		while (!curItem.getElement().getTileType().equals("Floor")) {
			curItem = curItem.getNextElement();
		}
		removeTile(curItem);
		return curItem.getElement();
	}

	/**
	 * Adds a tile to the bag at a random position.
	 * @param el element to insert into bag.
	 */
	public void addTile(Tile el) {
		int n = getRandomInt();
		/*
	        If empty, insert the new item at the start
		 */
		if (isEmpty()) {
			BagTile<Tile> newBT = new BagTile<>(el, null);
			head = newBT;
		} else if (n == 0) {
			BagTile<Tile> curItem = head;
			BagTile<Tile> newBT = new BagTile<>(el, curItem);
			head = newBT;
		} else {
			BagTile<Tile> curItem = head;
			/*
	            Loop gets the item before the position where we want to insert
			 */
			for (int j = 0; j< (n - 1); ++j) {
				curItem = curItem.getNextElement();
			}
			BagTile<Tile> newBT = new BagTile<>(el, curItem.getNextElement());
			//Change pointers
			BagTile<Tile> prev = curItem;
			BagTile<Tile> next = curItem.getNextElement();
			newBT.setNextElement(next);
			prev.setNextElement(newBT);
		}
		this.tail = tail();
	}

	/**
	 * Finds out if the bag is empty or not.
	 * @return true if the linked list is empty.
	 */
	private boolean isEmpty() {
		return head == null && tail == null;
	}

	/**
	 * Gets a random integer.
	 * @return A random int which is less than or equal to the amount of elements in bag.
	 */
	private int getRandomInt() {
		if (isEmpty()) {
			return 0;
		}
		int max = this.size() + 1;
		int ranInt = (int) (Math.random() * max);
		return ranInt;
	}

	/**
	 * Finds the size of the bag.
	 * @return an integer of how many elements are in the bag.
	 */
	public int size() {
		BagTile<Tile> curItem = head;
		int size = 0;
		while (curItem != null) {
			size++;
			curItem = curItem.getNextElement();
		}
		return size;
	}

	/**
	 * Removes a tile from the bag and sets new pointers.
	 * @param removableTile The tile to be removed.
	 */
	private void removeTile(BagTile<Tile> removableTile) {
		if (this.size() == 1 || isEmpty()) {
			head = null;
		} else {
			BagTile<Tile> curItem = head;
			//Find the item before removableTile
			while (curItem.getNextElement() != removableTile) {
				curItem = curItem.getNextElement();
			}
			curItem.setNextElement(removableTile.getNextElement());
			removableTile.setNextElement(null);
		}
	}

}

