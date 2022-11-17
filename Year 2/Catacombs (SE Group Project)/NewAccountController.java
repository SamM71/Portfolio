import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * This class represents the controller that allows you to create a new account.
 * @author Connor Humphries
 * @version 1.0
 */
public class NewAccountController {
	private SceneChanger sceneChanger = new SceneChanger();
	public TextField usernameTxt;
	@FXML
	/**
	 * Uses a button to help add a new profile
	 */
	public void onPressConfirm() {
		String username = usernameTxt.getText();
		System.out.println(usernameTxt.getText());
		FileReader.addProfile(username);
		sceneChanger.backButton();

	}
	@FXML
	/**
	 * Go back
	 */
    private void onBackPress() {
        sceneChanger.backButton();

    }
}
