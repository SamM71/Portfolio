/**
 * This class represents the DoubleAction action tile.
 * @author George Brooks
 * @version 1.0
 */
public class DoubleAction extends Action {

	
	public DoubleAction() {

	}

	/**
	 * implements the effect of DoubleAction tile by allowing the player two move twice changing a boolean in player using it
	 * @param user - The player who is using the action 
	 * @return - true if tile was played
	 */
	public boolean effect(Player user) {
		user.setDoubleMove(true);
		System.out.println("used");

		return true;
	}


}
