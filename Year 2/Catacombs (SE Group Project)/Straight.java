/**
 * This class represents the Straight tile one of the types of tile that can appear on the board
 * @author George Brooks
 * @version 1.0
 */
public class Straight extends Floor {


	public Straight(int orientation, boolean isFixed ) {
		super(false, false, false, false, isFixed);
		super.orientation = orientation;
		setOrientation(super.orientation);

	}

	/**
	 * Sets the orientation of a tile
	 * @param orientation - desired orientation of a tile 
	 */
	public void setOrientation(int orientation) {
		super.orientation = orientation;
		// As straight is symmetrical orientations are the same 
		if (orientation == 2){
			orientation = 0;
		} else if (orientation == 3 ) {
			orientation = 1;
		}

		//changes movement options based of orientation 
		switch (orientation) {
		case(0):
			super.upMove = true;
		super.downMove = true;
		break;

		case(1):
			super.leftMove = true;
		super.rightMove = true;
		break;
		}
	}
}
