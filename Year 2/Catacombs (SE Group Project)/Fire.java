/**
 * This class represents the fire action tile.
 * @author George Brooks
 * @version 1.0
 */
public class Fire extends Action{

	Floor[][] gameboard;

	public Fire() {

	}



	/**
	 * Implements the effect of the fire tile changing isBurning to true for the selected tile and any surrounding it.
	 * @param posX Desired x position to play tile.
	 * @param posY Desired y position to play tile.
	 * @param board The game board to be played on.
	 * @return True if the tile was played.
	 */ 
	public boolean effect(int posX, int posY, Gameboard board) {

		gameboard = board.getBoardLayout();
		System.out.println(gameboard.length);
		System.out.println(gameboard[0].length);
		
		if((posX < gameboard[0].length) && (posY < gameboard.length) && !anyOccupied(posY, posX, board)) {
			if(posY + 1 < gameboard.length) {
				gameboard[posY + 1][posX].setBurning(true);
				System.out.println("+ 0");

			} if(posX + 1 < gameboard[0].length) {
				gameboard[posY][posX + 1].setBurning(true);
				System.out.println("0 +");

			}  if(posX - 1 >= 0 ) {
				gameboard[posY][posX - 1].setBurning(true);
				System.out.println("0 -");

			}if((posY - 1 >= 0) ) {
				gameboard[posY - 1][posX].setBurning(true);
				System.out.println("- 0");

			} if((posY - 1 >= 0) && posX- 1 >= 0 ) {
				gameboard[posY - 1][posX - 1].setBurning(true);
				System.out.println("- -");

			}if((posY + 1 < gameboard.length) && (posX + 1 < gameboard[0].length)) {
				gameboard[posY + 1][posX + 1].setBurning(true);
				System.out.println("+ +");

			}if((posY + 1 < gameboard.length) && (posX - 1 >= 0)) {
				gameboard[posY + 1][posX - 1].setBurning(true);
				System.out.println("+ -");

			}if((posY - 1 >= 0) && (posX + 1 < gameboard[0].length)) {
				gameboard[posY - 1][posX + 1].setBurning(true);
				System.out.println("- +");
			}
				gameboard[posY ][posX].setBurning(true);
				System.out.println("0 0");
			}
		return true;	
	}

	/**
	 * Checks if fire tile can be used.
	 * @param posX Desired x position to play tile.
	 * @param posY Desired y position to play tile.
	 * @param board The game board to be played on.
	 * @return True if the tile was played.
	 */
	public boolean anyOccupied(int posX, int posY, Gameboard board) {

		if(posY + 1 < gameboard.length && gameboard[posY + 1][posX].isOccupied()) {
			return true;
		}else if(posX + 1 < gameboard[0].length && gameboard[posY][posX+1].isOccupied()) {
			return true;
		} else if(posX - 1 >= 0 && gameboard[posY][posX-1].isOccupied()) {
			return true;
		}else if((posY - 1 >= 0) && gameboard[posY-1][posX].isOccupied()) {
			return true;
		} else if((posY - 1 >= 0) && posX- 1 >= 0 && gameboard[posY-1][posX-1].isOccupied()) {
			return true;
		}else if((posY + 1 < gameboard.length) && (posX + 1 < gameboard[0].length) && gameboard[posY+1][posX+1].isOccupied()) {
			return true;
		}else if((posY + 1 < gameboard.length) && (posX - 1 >= 0) && gameboard[posY+1][posX-1].isOccupied()) {
			return true;
		}else if((posY - 1 >= 0) && (posX + 1 < gameboard[0].length) && gameboard[posY-1][posX+1].isOccupied()) {
			return true;
		}else if(gameboard[posY][posX].isOccupied()){
			return true;
		}else {
			return false;
		}

	}
}
