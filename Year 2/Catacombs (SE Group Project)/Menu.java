import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Starts the application and creates the first menu.
 * @author Jamie Withinshaw
 */
public class Menu extends Application {
	private Label message;
    // The dimensions of the window
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    private static final String WINDOW_TITLE = "Catacombs";
    public static Stage getCurrentStage() {
        return currentStage;
    }
    
    private static Stage currentStage;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the main menu.
     * @param primaryStage The first stage.
     */
    public void start(Stage primaryStage) {
        currentStage = primaryStage;
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().
                    getResource("fxml/menu.fxml"));
            Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
            primaryStage.setTitle(WINDOW_TITLE);
            primaryStage.setScene(scene);
            primaryStage.show();
            message = new Label (Message.getMessage());
			root.getChildren().add(message);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
