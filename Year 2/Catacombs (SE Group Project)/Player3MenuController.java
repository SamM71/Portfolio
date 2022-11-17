import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
/**
 * Controls the menu if 2 players are selected.
 * @author Connor Humphries
 * @version 1.0
 */
public class Player3MenuController implements Initializable {
    public Button selectPlayer1;
	public Button selectPlayer2;
	public Button selectPlayer3;
	public Button confirmPlayers;
	private SceneChanger sceneChanger = new SceneChanger();
	public ComboBox<String> Player1Cmb;
	public ComboBox<String> Player2Cmb;
	public ComboBox<String> Player3Cmb;
	private static ArrayList<Profile> listOfProfiles = FileReader.fileReader();
	private static ArrayList<String> listOfUsernames = getAllUsernames(listOfProfiles);
	private static ArrayList<Profile> selectedPlayers = new ArrayList<Profile>();
	static Game game;

	ObservableList<String> list = FXCollections.observableArrayList(listOfUsernames);

	@Override
	/**
	 * Set the potential items to get from combo boxes.
	 */
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stubc
		Player1Cmb.setItems(list);
		Player2Cmb.setItems(list);
		Player3Cmb.setItems(list);
	}

	/**
	 * Get names of users.
	 * @param listOfProfiles ArrayList of the profiles in the game.
	 * @return Names of players in the game.
	 */
	private static ArrayList<String> getAllUsernames(ArrayList<Profile> listOfProfiles) {
		ArrayList<String> listOfUsernames = new ArrayList<String>();
		int numOfProfiles = listOfProfiles.size();
		for (int i = 0; i < numOfProfiles; i++) {
			String name = listOfProfiles.get(i).getUsername();
			listOfUsernames.add(name);
		}
		return listOfUsernames;
	}
	@FXML
	/**
	 * Choose an option from the combo box.
	 */
	private void onSelect1Press() {
		String selectedPlayer1 = Player1Cmb.getValue();
		getProfile(selectedPlayer1);
		Player2Cmb.getItems().remove(selectedPlayer1);
		Player3Cmb.getItems().remove(selectedPlayer1);
		System.out.println(selectedPlayer1);
		Player1Cmb.setDisable(true);
		selectPlayer1.setDisable(true);
	}
	@FXML
	/**
	 * Choose an option from the combo box.
	 */
	private void onSelect2Press() {
		String selectedPlayer2 = Player2Cmb.getValue();
		getProfile(selectedPlayer2);
		Player1Cmb.getItems().remove(selectedPlayer2);
		Player3Cmb.getItems().remove(selectedPlayer2);
		System.out.println(selectedPlayer2);
		Player2Cmb.setDisable(true);
		selectPlayer2.setDisable(true);
	}
	@FXML
	/**
	 * Choose an option from the combo box.
	 */
	private void onSelect3Press() {
		String selectedPlayer3 = Player3Cmb.getValue();
		getProfile(selectedPlayer3);
		Player1Cmb.getItems().remove(selectedPlayer3);
		Player2Cmb.getItems().remove(selectedPlayer3);
		System.out.println(selectedPlayer3);
		Player3Cmb.setDisable(true);
		selectPlayer3.setDisable(true);
	}

	@FXML
	/**
	 * Go back.
	 */
	private void onBackPress() {
		listOfProfiles = null;
		listOfUsernames = null;
		sceneChanger.backButton();
	}
	@FXML
	/**
	 * Confirm selection of players.
	 */
	private void onConfirmPress() {
		game = new Game(selectedPlayers);
		start();
		Stage stage = (Stage) confirmPlayers.getScene().getWindow();
		stage.close();
	}
	
	public static Game getGame() {
		return game;
	}
	
	private void getProfile(String username) {
		for (int i = 0; i < listOfProfiles.size(); i++) {
			if (listOfProfiles.get(i).getUsername().equals(username)) {
				selectedPlayers.add(listOfProfiles.get(i));
			}
		}
	}
	private void start() {
		Stage testStage = new Stage();
		GameboardController t = new GameboardController();
		t.start(testStage);
	}
}