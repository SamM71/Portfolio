/**
 * This class represents the backtrack action tile.
 * @author George Brooks
 * @version 1.0
 */
public class BackTrack extends Action {




	int[] posistionTwoAgo;
	int[] posistionOneAgo;
	public BackTrack() {

	}

	/**
	 * Implements the effect of BackTrack tile by moving a player back to an available position starting from two turns
	 * ago.
	 * @param user - The player who is using the action.
	 * @param board - The game board for the game that is being played.
	 * @return - True if tile was played.
	 */
	public boolean effect(Player user, Gameboard board) {
		posistionTwoAgo = user.getSecondLastLocation();
		posistionOneAgo = user.getLastLocation();
		if(!board.getFloorAt(posistionTwoAgo[1], posistionTwoAgo[0]).isOccupied() &&
				!board.getFloorAt(posistionOneAgo[1], posistionOneAgo[0]).isBurning()) {
			int[] newLocation = user.getLocation();
			board.getFloorAt(newLocation[0], newLocation[1]).setOccupied(false);
			user.setLocation(user.getSecondLastLocation());
			newLocation = user.getLocation();
			board.getFloorAt(newLocation[0], newLocation[1]).setOccupied(true);

		} else if(!board.getFloorAt(posistionOneAgo[1], posistionOneAgo[0]).isOccupied() &&
				!board.getFloorAt(posistionOneAgo[1], posistionOneAgo[0]).isBurning()) {
			int[] newLocation = user.getLocation();
			board.getFloorAt(newLocation[0], newLocation[1]).setOccupied(false);
			user.setLocation(user.getLastLocation());
			newLocation = user.getLocation();
			board.getFloorAt(newLocation[0], newLocation[1]).setOccupied(true);
			
			
		}


			return true;
	

	}
}
