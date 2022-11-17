
import javafx.fxml.FXML;
import java.awt.Button;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller for Load Game menu
 * @author Mekid
 * @version 1.0
 */

public class LoadGameMenuController implements Initializable{
    private SceneChanger sceneChanger = new SceneChanger();
    private static ArrayList<Profile> selectedPlayers = new ArrayList<Profile>();
    private static savedLevel savedLevel = LoadFileReader.fileReader();


	static Game thisGame;




    @FXML
	private void onConfirmPress() {
        int size = savedLevel.getPlayers().size();
        for (int i = 0; i < size; i++){
            selectedPlayers.add(i, savedLevel.getPlayers().get(i).getProfile());
        }

		thisGame = new Game(selectedPlayers, 0);
		
		start();
	}



    public static Game getGame() {
		return thisGame;
	}


    private void start() {
		Stage testStage = new Stage();
		GameboardController t = new GameboardController();
		t.start(testStage);

	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
    
}