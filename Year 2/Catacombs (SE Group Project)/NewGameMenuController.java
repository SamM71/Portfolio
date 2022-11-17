import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * This class represents the functionality of the new game menu.
 * @author Connor Humphries
 * @version 1.0
 */
public class NewGameMenuController {
	 private SceneChanger sceneChanger = new SceneChanger();
	 private static int numPlayers;

	 @FXML
	 private ComboBox<Integer> NoPlayersCombo;
	 @FXML
	 /**
	  * Chooses how many players enter the game.
	  */
	 public void onNextPress() {
	 	if(NoPlayersCombo.getValue() == 2) {
	 		sceneChanger.playerMenu2();
	 		this.numPlayers = 2;
	 	}
	 	else if (NoPlayersCombo.getValue() == 3) {
	 		sceneChanger.playerMenu3();
	 		this.numPlayers = 3;
	 	}
	 	else if (NoPlayersCombo.getValue() == 4) {
	 		sceneChanger.playerMenu4();
	 		this.numPlayers = 4;
	 	}

	 }
	 
	 public static int getNumPlayers() {
		 return numPlayers;
	 }
	 @FXML
	 /**
	  * Create new account
	  */
	 public void onPressNewAcc() {
		 sceneChanger.newAccount();
	 }
}
