import javafx.fxml.FXML;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

/**
 * Controls the JavaFX for the Menu
 * @author Jamie Withinshaw
 */
public class MenuController {

    private SceneChanger sceneChanger = new SceneChanger();

    @FXML
    private ImageView playPicture;
    @FXML
    private  ImageView leaderboardPicture;
    @FXML
    private ImageView exitPicture;

    @FXML
    private void onPlayButtonClick() {
        sceneChanger.playMenu();
    }

    @FXML
    private void onLeaderboardButtonClick() {
        sceneChanger.leaderBoardMenu();
    }

    @FXML
    private void onExitButtonClick() {
        sceneChanger.exit();
        }
    @FXML
    private void onPlayButtonMouseEnter() {
        playPicture.setBlendMode(BlendMode.DARKEN);
    }
    @FXML
    private void onPlayButtonMouseExit() {
        playPicture.setBlendMode(BlendMode.LIGHTEN);
    }

    @FXML
    private void onLeaderboardMouseEntered() {
        leaderboardPicture.setBlendMode(BlendMode.DARKEN);
    }

    @FXML
    private void onLeaderboardMouseExit() {
        leaderboardPicture.setBlendMode(BlendMode.LIGHTEN);
    }

    @FXML
    private void onExitMouseEntered() {
        exitPicture.setBlendMode(BlendMode.DARKEN);
    }

    @FXML
    private void onExitMouseExit() {
        exitPicture.setBlendMode(BlendMode.LIGHTEN);
    }

}



