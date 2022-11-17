/**
 * This class represents the corner floor tile.
 * @author George Brooks
 * @version 1.0
 */
public class Corner extends Floor{


	/**
	 * Creates a corner object.
	 * @param orientation Orientation of tile.
	 * @param isFixed Whether or not the tile is movable.
	 */
	public Corner (int orientation, boolean isFixed ) {
		super(false, false, false, false, isFixed);
		super.orientation = orientation;
		setOrientation(super.orientation);
	}
 
	/**
	 * Sets the orientation of a tile.
	 * @param orientation - desired orientation of a tile .
	 */
	public void setOrientation(int orientation) {
		super.orientation = orientation;
		//changes movement options based of orientation 
		switch (orientation) {
		case(0):
			super.rightMove = true;
		super.downMove = true;
		break;

		case(1):
			super.leftMove = true;
		super.downMove = true;
		break;

		case(2):
			super.rightMove = true;
		super.upMove = true;
		break;

		case(3):
			super.leftMove = true;
		super.upMove = true;
		}
	}
}
