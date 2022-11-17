/**
 * This class represents the floor tiles. It is the superclass of the four different floor tiles.
 * @author George Brooks
 * @version 1.0
 */
public class Floor extends Tile{

	protected int orientation;
	protected boolean upMove;
	protected boolean downMove;
	protected boolean leftMove;
	protected boolean rightMove;
	protected boolean isBurning = false;
	protected boolean isFrozen = false;
	protected boolean isFixed;
	protected boolean isOccupied;

	/**
	 * Creates a Floor object with certain attributes.
	 * @param upMove Whether or not the player can go up from the tile.
	 * @param downMove Whether or not the player can go down from the tile.
	 * @param leftMove Whether or not the player can go left from the tile.
	 * @param rightMove Whether or not the player can go right from the tile.
	 * @param isFixed Whether or not the tile can be moved.
	 */
	public Floor(boolean upMove,boolean downMove, boolean leftMove, boolean rightMove, boolean isFixed) {
		super("Floor");
		this.upMove = upMove;
		this.downMove = downMove;
		this.leftMove = leftMove;
		this.rightMove = rightMove;
		this.isFixed = isFixed;
	}


	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public boolean isUpMove() {
		return upMove;
	}

	public void setUpMove(boolean upMove) {
		this.upMove = upMove;
	}

	public boolean isDownMove() {
		return downMove;
	}

	public void setDownMove(boolean downMove) {
		this.downMove = downMove;
	}

	public boolean isLeftMove() {
		return leftMove;
	}

	public void setLeftMove(boolean leftMove) {
		this.leftMove = leftMove;
	}

	public boolean isRightMove() {
		return rightMove;
	}

	public void setRightmove(boolean rightmove) {
		this.rightMove = rightmove;
	}

	public boolean isBurning() {
		return isBurning;
	}

	public void setBurning(boolean isBurning) {
		this.isBurning = isBurning;
	}

	public boolean isFrozen() {
		return isFrozen;
	}

	public void setFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	public boolean isFixed() {
		return isFixed;
	}

	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}

	public boolean isOccupied() {
		return isOccupied;
	}


	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}


	public String toString() {
		//return ("Left: " + leftMove + "| Down: " + downMove + "| Right: " + rightMove + "| Up: " + upMove + "| Fixed: " + isFixed);
		return (this.getClass().toString());
	}




}
