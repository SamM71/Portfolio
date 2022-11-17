import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;
/**
 * Controls the changing of scenes in the 
 * @author Connor Humphries & Declan McGauley
 * @version 1.0
 */
public class SceneChanger {
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;

	/**
	 * Main menu scene changing
	 */
	public void playMenu() {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/playMenu.fxml"));
			Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
			Menu.getCurrentStage().setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Scene changer for leaderboard
	 */
	public void leaderBoardMenu() {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/leaderboard.fxml"));
			Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
			Menu.getCurrentStage().setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scene changer for new game menu
	 */
	public void newGameMenu() {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/newGameMenu.fxml"));
			Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
			Menu.getCurrentStage().setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * used for exiting the game
	 */
	public void exit() {
		Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?");
		Optional result = exitAlert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			System.exit(0);
		}
	}

	/**
	 * Play menu scene changing
	 */
	public void backButton() {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/menu.fxml"));
			Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
			Menu.getCurrentStage().setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Scene changer for a menu for a game of two players
	 */
	public void playerMenu2() {
		ComboBox<Integer> Player1Cmb = new ComboBox<Integer>();
		try { 
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/2Players.fxml"));
			Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);

			Player1Cmb.getItems().addAll(1,2,3,4,5);
			Player1Cmb.setEditable(true);

			Menu.getCurrentStage().setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Scene changer for a menu for a game of three players
	 */
	public void playerMenu3() {
		try { 
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/3Players.fxml"));
			Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);

			Menu.getCurrentStage().setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Scene changer for a menu for a game of four players
	 */
	public void playerMenu4() {
		try { 
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/4Players.fxml"));
			Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
			Menu.getCurrentStage().setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Scene changer for a menu for adding a new account
	 */
	public void newAccount() {
		try { 
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("fxml/newAccount.fxml"));
			Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
			Menu.getCurrentStage().setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Scene changer for a menu for loading a game
	 */
	public void loadGame(){
		try { 
			Pane root = (Pane) FXMLLoader.load(getClass().
					getResource("/fxml/loadGame2.fxml"));
			Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
			Menu.getCurrentStage().setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
