/**
 * This class represents the T-shaped tiles one of the types of tile that can appear on the board
 * @author George Brooks
 * @version 1.0
 */
public class T_Shape extends Floor {




	public T_Shape (int orientation, boolean isFixed ) {
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
		switch (orientation) {
		case(0):
			super.rightMove = true;
		super.leftMove = true;
		super.downMove = true;
		break;

		case(1):
			super.upMove = true;
		super.downMove = true;
		super.rightMove = true;
		break;

		case(2):
			super.rightMove = true;
		super.leftMove = true;
		super.upMove = true;
		break;

		case(3):
			super.leftMove = true;
		super.upMove = true;
		super.downMove = true;
		break;
		}
	}


}
