import javafx.fxml.FXML;

/**
 * Controls the play menu.
 * @author Connor Humphries
 * @version 1.0
 */
public class PlayMenuController {
    private SceneChanger sceneChanger = new SceneChanger();

    @FXML
    /**
     * Go back.
     */
    private void onBackButtonClick() {
        sceneChanger.backButton();

    }

    @FXML
    /**
     * Go to new game menu.
     */
    private void onNewGameClick() {
        sceneChanger.newGameMenu();
    }

    @FXML
    /**
     * Show load game.
     */
    private void onLoadGameClick() {
        System.out.println("Load game");
    }
}
