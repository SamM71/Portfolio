import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class controls the leaderboard.
 * @author Connor Humphries
 * @version 1.0
 */
public class LeaderboardController implements Initializable {

	private SceneChanger sceneChanger = new SceneChanger();
	private static ArrayList<Profile> listOfProfiles = FileReader.fileReader();
	private static ArrayList<Profile> sortedProfiles = sortedListByWinPerc(listOfProfiles);
	
	 public TableView<Profile> leaderboardTable;
	    public TableColumn<Profile,String> usernameCol;
	    public TableColumn<Profile,Double> winPerCol;
	    public TableColumn<Profile,Double> totGameCol;
	    public TableColumn<Profile,Double> totWinCol;
	    public TableColumn<Profile,Double> totLossCol;
	    
	    
	    public static ArrayList<Profile> sortedListByWinPerc(ArrayList<Profile> Profiles) {
	    	Collections.sort(Profiles, new Comparator<Profile>() {
	    	    @Override
	    	    public int compare(Profile p1, Profile p2) {
	    	        return Double.compare(p2.getPercentageOfWins(), p1.getPercentageOfWins());
	    	    }
	        });

	        return Profiles;
	    }
	    
	    private ObservableList<Profile> getProfiles(){
	        ObservableList<Profile> profiles = FXCollections.observableArrayList();
	        for (int i = 0; i < sortedProfiles.size(); i++) {
	        	profiles.add(sortedProfiles.get(i));
	        }

	        return profiles;
	    }
	@FXML
	private void onBackButtonClick() {
		sceneChanger.backButton();

	}

	 @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	  
		 usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

		 winPerCol.setCellValueFactory(new PropertyValueFactory<>("percentageOfWins"));

		 totGameCol.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));

		 totWinCol.setCellValueFactory(new PropertyValueFactory<>("amtOfWins"));

		 totLossCol.setCellValueFactory(new PropertyValueFactory<>("amtOfLosses"));

		 leaderboardTable.setItems(getProfiles());

	}
}
