/**
 * This class represents the ice/freeze action tile.
 * @author George Brooks
 * @version 1.0
 */
public class Freeze extends Action{


	Floor[][] gameboard;

	public Freeze() {

	}

	/**
	 * Implements the effect of a Freeze tile setting isFrozen() to true for the selected tiles
	 * and any that surround it.
	 * @param posX Desired x position to play tile.
	 * @param posY Desired y position to play tile.
	 * @param board The game board to be played on.
	 * @return True if the tile was played.
	 */
	boolean effect(int posX, int posY, Gameboard board) {
		gameboard = board.getBoardLayout();
		System.out.println(gameboard.length);
		System.out.println(gameboard[0].length);

		if((posX < gameboard[0].length) && (posY < gameboard.length)) {
			if(posY + 1 < gameboard.length) {
				gameboard[posY + 1][posX].setFrozen(true);
				System.out.println("+ 0");

			} if(posX + 1 < gameboard[0].length) {
				gameboard[posY][posX + 1].setFrozen(true);
				System.out.println("0 +");

			}  if(posX - 1 >= 0 ) {
				(gameboard[posY][posX - 1]).setFrozen(true);
				System.out.println("0 -");

			}if((posY - 1 >= 0) ) {
				gameboard[posY - 1][posX].setFrozen(true);
				System.out.println("- 0");

			} if((posY - 1 >= 0) && posX- 1 >= 0 ) {
				gameboard[posY - 1][posX - 1].setFrozen(true);
				System.out.println("- -");

			}if((posY + 1 < gameboard.length) && (posX + 1 < gameboard[0].length)) {
				gameboard[posY + 1][posX + 1].setFrozen(true);
				System.out.println("+ +");

			}if((posY + 1 < gameboard.length) && (posX - 1 >= 0)) {
				gameboard[posY + 1][posX - 1].setFrozen(true);
				System.out.println("+ -");

			}if((posY - 1 >= 0) && (posX + 1 < gameboard[0].length)) {
				gameboard[posY - 1][posX + 1].setFrozen(true);
				System.out.println("- +");
			}
				gameboard[posY ][posX].setFrozen(true);
				System.out.println("0 0");
			}
		return true;	
	}
	


}