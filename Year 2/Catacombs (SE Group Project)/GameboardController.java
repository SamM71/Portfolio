import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the visual elements of the gameboard as well as the movement that takes place on the board.
 * @author Jamie Withinshaw
 * @version 1.0
 */
public class GameboardController extends Application {

    public GameboardController() {
    }

    public Gameboard getBoard() {
        return board;
    }

    private Gameboard board;


    public static void main(String[] args) {
        imageLoader();
        launch(args);
    }


    private VBox root = new VBox();

    private GridPane displayBoard = new GridPane();
    private StackPane imageLayer;
    private StackPane imageLayer2;
    private StackPane imageLayer3;
    private StackPane imageLayer4;

    public PlayerMovementController getPlayerMovementController() {
        return playerMovementController;
    }

    /**
     * Loads the gameboard window and populates it.
     * @param primaryStage The stage it takes place on.
     */
    public void start(Stage primaryStage) {
        imageLoader();

        Scene scene = new Scene(root, 900, 500);
        primaryStage.setTitle("Catacombs");
        primaryStage.setScene(scene);
        primaryStage.show();
        board = new Gameboard();
        displayBoard.setAlignment(Pos.CENTER);
        displayBoard.setPrefWidth(1000);
        playerMovementController = new PlayerMovementController(board, this);
        actionButtonController  = new ActionButtonController(board,this);
        addPlayerMovementButtons();
        setPositions();
        addActionButtons();
        generateBoard();

    	displayBoard.getChildren().add(playersTurnLabel);

        generateButtons();


        playerMovementController.disableMovementButtons();




    }
	private Label playersTurnLabel = new Label("");
        
    private Image image;
    private static Image image2;
    private Image image3;
    private Image image4;
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView playerImageView;
    private ImageView playerImageView2;
    private ImageView playerImageView3;
    private ImageView playerImageView4;

    /**
     * Sets positions of players.
     */
    private void setPositions() {
        ArrayList<Player> t = playerMovementController.getGame().getPlayerArray();
        System.out.println("Player array size: " + t.size());
        for (Player e : t) {
            board.getFloorAt(e.getLocation()[0], e.getLocation()[1]).setOccupied(true);
        }
    }

    /**
     * Looks at the gameboard 2D array, Creates a visual representation of it.
     */
    private PlayerMovementController playerMovementController;
    private ActionButtonController actionButtonController;

    public ActionButtonController getActionButtonController() {
        return actionButtonController;
    }

    /**
     * Populates the board with tiles and players.
     */
    public void generateBoard() {

        for (int x = 0; x < board.getHeight() + 2; x++) {
            for (int y = 0; y < board.getWidth() + 2; y++) {


                imageView = new ImageView(image);
                playerImageView = new ImageView(playerImage);
                playerImageView.setFitWidth(20);
                playerImageView.setFitHeight(20);

                imageView2 = new ImageView(image2);
                playerImageView2 = new ImageView(playerImage2);
                playerImageView2.setFitWidth(20);
                playerImageView2.setFitHeight(20);

                imageView3 = new ImageView(image3);
                playerImageView3 = new ImageView(playerImage3);
                playerImageView3.setFitWidth(20);
                playerImageView3.setFitHeight(20);

                imageView4 = new ImageView(image4);
                playerImageView4 = new ImageView(playerImage4);
                playerImageView4.setFitWidth(20);
                playerImageView4.setFitHeight(20);

                if (x <= board.getHeight() && y <= board.getWidth() && x >= 1 && y >= 1) {
                    tileImageSetter(x, y);
                }

               imageLayer = new StackPane();
                imageLayer.setMaxHeight(50);
                imageLayer.setMaxWidth(50);
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                imageLayer.getChildren().add(imageView);

                imageLayer2 = new StackPane();
                imageLayer2.setMaxHeight(50);
                imageLayer2.setMaxWidth(50);
                imageView2.setFitHeight(50);
                imageView2.setFitWidth(50);
                imageLayer2.getChildren().add(imageView2);

                imageLayer3 = new StackPane();
                imageLayer3.setMaxHeight(50);
                imageLayer3.setMaxWidth(50);
                imageView3.setFitHeight(50);
                imageView3.setFitWidth(50);
                imageLayer3.getChildren().add(imageView3);

                imageLayer4 = new StackPane();
                imageLayer4.setMaxHeight(50);
                imageLayer4.setMaxWidth(50);
                imageView4.setFitHeight(50);
                imageView4.setFitWidth(50);
                imageLayer4.getChildren().add(imageView4);

                GridPane.setRowIndex(imageLayer, x);
                GridPane.setColumnIndex(imageLayer, y);
                GridPane.setRowIndex(imageView, x);
                GridPane.setColumnIndex(imageView, y);

                GridPane.setRowIndex(imageLayer2, x);
                GridPane.setColumnIndex(imageLayer2, y);
                GridPane.setRowIndex(imageView2, x);
                GridPane.setColumnIndex(imageView2, y);

                GridPane.setRowIndex(imageLayer3, x);
                GridPane.setColumnIndex(imageLayer3, y);
                GridPane.setRowIndex(imageView3, x);
                GridPane.setColumnIndex(imageView3, y);

                GridPane.setRowIndex(imageLayer4, x);
                GridPane.setColumnIndex(imageLayer4, y);
                GridPane.setRowIndex(imageView4, x);
                GridPane.setColumnIndex(imageView4, y);

                displayBoard.getChildren().add(imageView);
                Game testGame = playerMovementController.getGame();
                //displayBoard.getChildren().add(imageView2);
                //displayBoard.getChildren().add(imageView3);
                //displayBoard.getChildren().add(imageView4);
                if (x <= board.getHeight() && y <= board.getWidth() && x >= 1 && y >= 1) {

                    if (board.getFloorAt(x - 1, y - 1).isOccupied) {
                        for (int i = 0; i < testGame.getPlayerArray().size(); i++) {
                            if (testGame.getPlayerArray().get(i).getPlayerNumber() == 1 &&
                                    testGame.getPlayerArray().get(i).getLocation()[0] == x - 1 &&
                                    testGame.getPlayerArray().get(i).getLocation()[1] == y - 1) {
                                imageLayer.getChildren().add(playerImageView);
                                displayBoard.getChildren().add(imageLayer);
                            } else if (testGame.getPlayerArray().get(i).getPlayerNumber() == 2 &&
                                    testGame.getPlayerArray().get(i).getLocation()[0] == x - 1 &&
                                    testGame.getPlayerArray().get(i).getLocation()[1] == y - 1) {
                                imageLayer2.getChildren().add(playerImageView2);
                                displayBoard.getChildren().add(imageLayer2);
                            } else if (testGame.getPlayerArray().get(i).getPlayerNumber() == 3 &&
                                    testGame.getPlayerArray().get(i).getLocation()[0] == x - 1 &&
                                    testGame.getPlayerArray().get(i).getLocation()[1] == y - 1) {
                                imageLayer3.getChildren().add(playerImageView3);
                                displayBoard.getChildren().add(imageLayer3);
                            } else if (testGame.getPlayerArray().get(i).getPlayerNumber() == 4 &&
                                    testGame.getPlayerArray().get(i).getLocation()[0] == x - 1 &&
                                    testGame.getPlayerArray().get(i).getLocation()[1] == y - 1) {
                                imageLayer4.getChildren().add(playerImageView4);
                                displayBoard.getChildren().add(imageLayer4);
                            }
                        }
                    }
                    playersTurnLabel.setText("");
					playersTurnLabel.disabledProperty();
					if (testGame.getPlayer().getPlayerNumber() == 1) {
						playersTurnLabel.setText(
								"It is " + testGame.getPlayerArray().get(0).getProfile().getUsername() + "'s turn");
						playersTurnLabel.setTextFill(Color.RED);
						playersTurnLabel.disabledProperty();
					} else if (testGame.getPlayer().getPlayerNumber() == 2) {
						playersTurnLabel.setText(
								"It is " + testGame.getPlayerArray().get(1).getProfile().getUsername() + "'s turn");
						playersTurnLabel.setTextFill(Color.BLUE);
						playersTurnLabel.disabledProperty();
					} else if (testGame.getPlayer().getPlayerNumber() == 3) {
						playersTurnLabel.setText(
								"It is " + testGame.getPlayerArray().get(2).getProfile().getUsername() + "'s turn");
						playersTurnLabel.setTextFill(Color.GREEN);
						playersTurnLabel.disabledProperty();
					} else if (testGame.getPlayer().getPlayerNumber() == 4) {
						playersTurnLabel.setText(
								"It is " + testGame.getPlayerArray().get(3).getProfile().getUsername() + "'s turn");
						playersTurnLabel.setTextFill(Color.PURPLE);
						playersTurnLabel.disabledProperty();
					}

                }

                    imageRotation(x, y);
                    checkIfWin(x, y);
                    image = null;
                    imageView = new ImageView(image);
                }
            }
            root.getChildren().add(displayBoard);
        }

    /**
     * Check if a player has won the game.
     * @param x X position.
     * @param y Y position.
     */
    private void checkIfWin(int x, int y) {
        if (x <= board.getHeight() && y <= board.getWidth() && x >= 1 && y >= 1) {
            if (board.getFloorAt(x - 1, y - 1).toString().equals("class Goal") &&
                    board.getFloorAt(x - 1, y - 1).isOccupied) {
                System.out.println("WINNNNNNNNNNNNNNNNNNNERRRRRRRRRRRRRR");
                Alert winAlert = new Alert(Alert.AlertType.INFORMATION, "WIN");
                winAlert.showAndWait();
              Game testGame = playerMovementController.getGame();
              
              Profile winningProfile = testGame.getLastPlayer().getProfile();
				
				for (int i = 0; i < testGame.getPlayerArray().size(); i++) {
					if (testGame.getPlayerArray().get(i).getProfile() == winningProfile) {
						winningProfile.addGame();
						winningProfile.addWin();
					} else {
						testGame.getPlayerArray().get(i).getProfile().addGame();
						testGame.getPlayerArray().get(i).getProfile().addLoss();
					}
				
				}
				
				saveProfileFile.updateProfiles();
				System.exit(1);
			}
		}
                
    }

    /**
     * Visually updates the player's location.
     */
    public void updatePlayerImageLocation() {
        root.getChildren().remove(displayBoard);
        generateBoard();
    }

    /**
     * Rotates the image.
     * @param x X position.
     * @param y Y position.
     */
    private void imageRotation(int x, int y) {
        if (x <= board.getHeight() && y <= board.getWidth() && x >= 1 && y >= 1) {
            if (board.getFloorAt(x - 1, y - 1).toString().equals("class Corner")) {
                if (board.getFloorAt(x - 1, y - 1).getOrientation() == 0) {
                    imageView.setRotate(180);
                    playerImageView.setRotate(180);
                } else if (board.getFloorAt(x - 1, y - 1).getOrientation() == 1) {
                    imageView.setRotate(270);
                    playerImageView.setRotate(270);
                } else if (board.getFloorAt(x - 1, y - 1).getOrientation() == 2) {
                    imageView.setRotate(90);
                }
            } else if (board.getFloorAt(x - 1, y - 1).toString().equals("class Straight")) {
                if (board.getFloorAt(x - 1, y - 1).getOrientation() == 1) {
                    imageView.setRotate(90);
                }
            } else {
                if (board.getFloorAt(x - 1, y - 1).getOrientation() == 1) {
                    imageView.setRotate(270);
                } else if (board.getFloorAt(x - 1, y - 1).getOrientation() == 2) {
                    imageView.setRotate(180);
                } else if (board.getFloorAt(x - 1, y - 1).getOrientation() == 3) {
                    imageView.setRotate(90);
                }
            }
        }
    }

    /**
     * Slides the tiles in the given column down, and inserts the new
     * tile from the bag.
     * @param col The column that is being changed.
     */
    private void slideButtonDown(int col) {
        te = actionButtonController.getDrawnTile();
        board.insertTileTop((Floor) te, col - 1);
        testGame = playerMovementController.getGame();
        for (Player p : testGame.getPlayerArray()) {
            if (p.getLocation()[1] == col - 1) {
                p.moveDown(board);
            }
        root.getChildren().remove(displayBoard);
        playerMovementController.buttonChecks(board);
        root.getChildren().remove(currentTile);
        generateBoard();
    }

    }

    /**
     * Slides the tiles in the given column up, and inserts the new tile
     * from the silk bag.
     * @param col The row column is being changed.
     */
    private void slideButtonUp(int col) {
        te = actionButtonController.getDrawnTile();
        board.insertTileBottom((Floor) te, col - 1);
        testGame = playerMovementController.getGame();
        for (Player p : testGame.getPlayerArray()) {
            if (p.getLocation()[1] == col - 1) {
                p.moveUp(board);
            }
        }
        root.getChildren().remove(displayBoard);
        playerMovementController.buttonChecks(board);
        root.getChildren().remove(currentTile);
        generateBoard();
    }

    /**
     * Slides the tiles in the given row to the right, and inserts the new tile from
     * the silk bag.
     * @param row The row that is being changed.
     */
    Tile te;
    private void slideButtonRight(int row) {
        te = actionButtonController.getDrawnTile();
        board.insertTileOnLeft((Floor) te, row - 1);
        testGame = playerMovementController.getGame();
        for (Player p : testGame.getPlayerArray()) {
            if (p.getLocation()[0] == row - 1) {
                p.moveRight(board);
            }
        }
        root.getChildren().remove(displayBoard);
        playerMovementController.buttonChecks(board);
        root.getChildren().remove(currentTile);
        generateBoard();
    }
    private Game testGame;


    /**
     * Slides the tiles in the given row to the left, and inserts the new tile
     * from the silk bag.
     * @param row The row that is being changed.
     */
    private void slideButtonLeft(int row) {
        te = actionButtonController.getDrawnTile();
        board.insertTileOnRight((Floor) te, row - 1);
        testGame = playerMovementController.getGame();
        for (Player p : testGame.getPlayerArray()) {
            if (p.getLocation()[0] == row - 1) {
                p.moveLeft(board);
            }
        }
        root.getChildren().remove(displayBoard);
        playerMovementController.buttonChecks(board);
        root.getChildren().remove(currentTile);
        generateBoard();
    }

    /**
     * Checks a given row for fixed tiles.
     * @param row The row that is being checked.
     * @return True/False depending on if there is a fixed tile in the row.
     */
    private boolean fixedTileDetectionForRow(int row) {
        Floor[] testedRow = board.getRow(row);
        boolean result = false;
        for (int i = 0; i < testedRow.length; i++) {
            if (testedRow[i].isFixed || testedRow[i].isFrozen) {
                return true;
            } else {
                result = false;
            }
        }
        return false;
    }

    /**
     * Detects if there's a fixed tile in the column.
     * @param col Location of column.
     * @return True if there's a fixed tile.
     */
    private boolean fixedTileDetectionColumn(int col) {
        Floor[] testedCol = board.getCol(col);
        boolean result = false;
        for (int i = 0; i < testedCol.length; i++) {
            if (testedCol[i].isFixed || testedCol[i].isFrozen) {
                return true;
            } else {
                result = false;
            }
        }
        return result;
    }

    private static Image cornerImage;
    private static Image straightImage;
    private static Image t_ShapeImage;
    private static Image playerImage;
    private static Image goalImage;
    private static Image playerImage2;
    private static Image playerImage3;
    private static Image playerImage4;

    /**
     * Places the correct image onto its corresponding tile.
     * @param x The row of the current tile.
     * @param y The column of the current tile.
     */
    private void tileImageSetter(int x, int y) {
        if (board.getFloorAt(x - 1, y - 1).toString().equals("class Corner")) {
            imageView = new ImageView(cornerImage);
        } else if (board.getFloorAt(x - 1, y - 1).toString().equals("class Straight")){
            imageView = new ImageView(straightImage);
        } else if (board.getFloorAt(x - 1, y - 1).toString().equals("class T_Shape")) {
            imageView = new ImageView(t_ShapeImage);
        } else if (board.getFloorAt(x - 1, y - 1).toString().equals("class Goal")) {
        	imageView = new ImageView(goalImage);
        }
    }

    /**
     * Loads the images for the tiles.
     */
    private static void imageLoader() {
        FileInputStream t = null;
        try  {
            t = new FileInputStream("src/Images/corner.png");
            cornerImage = new Image(t);
        } catch (Exception e) {
            System.out.println("Image not found");
        }
        try  {
            t = new FileInputStream("src/Images/Straight.png");
            straightImage = new Image(t);

        } catch (Exception e) {
            System.out.println("Image not found");
        }
        try  {
            t = new FileInputStream("src/Images/t_Shape.png");
            t_ShapeImage = new Image(t);

        } catch (Exception e) {
            System.out.println("Image not found");
        }
        try {
            t = new FileInputStream("src/Images/player.png");
            playerImage = new Image(t);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
            t = new FileInputStream("src/Images/player2.png");
            playerImage2 = new Image(t);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
            t = new FileInputStream("src/Images/player3.png");
            playerImage3 = new Image(t);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
            t = new FileInputStream("src/Images/player4.png");
            playerImage4 = new Image(t);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
        	t = new FileInputStream("src/Images/goal.png");
        	goalImage = new Image(t);
        } catch (FileNotFoundException e){
        	System.out.println(e);
        }
        try {
            assert t != null;
            t.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Creates and sets the buttons on the side and the top of the board, as well as their event handlers.
     */
    private boolean columnButtonRemover(int y) {
        if (y <= board.getWidth() &&y >= 1) {
            if (fixedTileDetectionColumn(y - 1)) return true;
        }
        return false;

    }
    private boolean rowButtonRemover(int x) {
        if (x <= board.getHeight() &&x >= 1) {
            if (fixedTileDetectionForRow(x - 1)) return true;
        }
        return false;

    }
    private boolean columnOccupied(int col) {
        Floor[] testedCol = board.getCol(col);
        boolean result = false;
        for (int i = 0; i < testedCol.length; i++) {
            if (testedCol[i].isOccupied) {
                System.out.println("meme");
                return true;
            } else {
                result = false;
            }
        }
        return result;
    }
    private boolean rowOccupied(int row) {
        Floor[] testedRow = board.getRow(row);
        boolean result = false;
        for (int i = 0; i < testedRow.length; i++) {
            if (testedRow[i].isOccupied) {
                return true;
            } else {
                result = false;
            }
        }
        return false;
    }

    public Button getSlide() {
        return slide;
    }

    private ArrayList<Button> buttonArray = new ArrayList<>();
    private Button slide = new Button();

    /**
     * Generates buttons for sliding tiles.
     */
    private void generateButtons() {
        for (int x = 0; x < board.getHeight() + 2; x++) {
            for (int y = 0; y < board.getWidth() + 2; y++) {

                if (x == 0 || y == 0 || x == board.getHeight() + 1 || y == board.getWidth() + 1) {
                    if (!((x == 0 && y == 0) || (x == board.getHeight() + 1 && y == board.getWidth() + 1) ||
                            (x == board.getHeight() + 1 && y == 0) || x == 0 && y == board.getWidth() + 1 ||
                            columnButtonRemover(y) || rowButtonRemover(x))) {
                        if (x == 0) {

                            slide = new Button("x = " + (y - 1));
                            Button finalSlide = slide;
                            slide.setOnAction(event -> { slideButtonDown(GridPane.getColumnIndex(finalSlide));
                                grayMovement();
                            });
                            playerMovementController.buttonChecks(board);
                        } else if (y == 0) {
                            slide = new Button("-->");
                            Button finalSlide = slide;
                            slide.setOnAction(event -> { slideButtonRight(GridPane.getRowIndex(finalSlide));
                                System.out.println
                                        (Arrays.toString(playerMovementController.getTestPlayer().getLocation()));
                                grayMovement();
                            });
                            playerMovementController.buttonChecks(board);
                        } else if (x == board.getHeight() + 1) {
                            slide = new Button("x = " + (y - 1));
                            Button finalSlide = slide;
                            slide.setOnAction(event -> { slideButtonUp(GridPane.getColumnIndex(finalSlide));
                                System.out.println
                                        (Arrays.toString(playerMovementController.getTestPlayer().getLocation()));
                                grayMovement();
                            });
                            playerMovementController.buttonChecks(board);
                        } else if (y == board.getWidth() + 1) {
                            slide = new Button("<--");
                            Button finalSlide = slide;
                            slide.setOnAction(event -> { slideButtonLeft(GridPane.getRowIndex(finalSlide));

                                System.out.println
                                        (Arrays.toString(playerMovementController.getTestPlayer().getLocation()));
                                grayMovement();
                            });
                            playerMovementController.buttonChecks(board);
                        }
                        slide.setPrefHeight(50);
                        slide.setPrefWidth(50);
                        slide.setAlignment(Pos.CENTER);
                        GridPane.setRowIndex(slide, x);
                        GridPane.setColumnIndex(slide, y);
                        displayBoard.getChildren().add(slide);
                        slide.setDisable(true);
                        buttonArray.add(slide);
                    }
                }
            }

        }

    }
/*
    private boolean resetBool = false;
    private void setPlayer(int col) {
        int[] positionArray = new int[2];
        if (col >= 1 && resetBool) {
            root.getChildren().remove(displayBoard);
            positionArray[1] = (col - 1);
            playerMovementController.getTestPlayer().setLocation(positionArray);
            board.getFloorAt(playerMovementController.getTestPlayer().getLocation()[0], col -1).setOccupied(true);
            resetBool = false;
            generateBoard();
        }

        if (playerMovementController.getTestPlayer().getLocation()[0]  == board.getHeight() - 1) {
            resetBool = true;

        }
    }
*/

    /**
     * UnGrays the slide buttons.
     */
    public void unGrayMovementSlide() {
        for (Button b : buttonArray) {
            b.setDisable(false);
        }

    }

    /**
     * Greys the movement buttons.
     */
    public void grayMovement() {
        for (Button b : buttonArray) {
            b.setDisable(true);
        }
    }

    private HBox movementButtonBox = new HBox();
    private HBox actionButtonBox = new HBox();
    private HBox selectPlayerBox = new HBox();

    /**
     * Adds player movement buttons.
     */
    private void addPlayerMovementButtons() {
        movementButtonBox.getChildren().add(playerMovementController.getButtonUp(board));
        movementButtonBox.getChildren().add(playerMovementController.getButtonDown(board));
        movementButtonBox.getChildren().add(playerMovementController.getButtonLeft(board));
        movementButtonBox.getChildren().add(playerMovementController.getButtonRight(board));
        movementButtonBox.getChildren().add(playerMovementController.getButtonSkipTurn(board));
        root.getChildren().add(actionButtonController.getButtonDrawTile(board));
        root.getChildren().add(movementButtonLabel);
        root.getChildren().add(movementButtonBox);
    }
    private Label movementButtonLabel = new Label("Movement Buttons");
    private Label actionButtonLabel = new Label("Action buttons");

    /**
     * Adds action buttons.
     */
    private void addActionButtons() {
        actionButtonBox.getChildren().add(actionButtonController.getButtonFire(board));
        actionButtonBox.getChildren().add(actionButtonController.getButtonFreeze(board));
        actionButtonBox.getChildren().add(actionButtonController.getButtonDoubleAction(board));
        actionButtonBox.getChildren().add(actionButtonController.getButtonBackTrack(board));
        selectPlayerBox.getChildren().add(actionButtonController.getButtonPlayerOne());
        selectPlayerBox.getChildren().add(actionButtonController.getButtonPlayerTwo());
        selectPlayerBox.getChildren().add(actionButtonController.getButtonPlayerThree());
        selectPlayerBox.getChildren().add(actionButtonController.getButtonPlayerFour());
        
        root.getChildren().add(actionButtonLabel);
        root.getChildren().add(actionButtonBox);
        root.getChildren().add(selectPlayerBox);
        root.getChildren().add(rotateButton);
        root.getChildren().add(actionButtonController.saveGame());

    }
    private Button rotateButton = new Button("Rotate");
    private ImageView currentTile;

    /**
     * Shows the next tile to be inserted.
     * @param tile Tile to be shown.
     */
    public void showNextTile(Tile tile) {
        te = tile;
        currentTile = new ImageView(getTileImage((Floor) te));
        currentTile.setFitWidth(50);
        currentTile.setFitHeight(50);
        getCorrectRotation((Floor) te);
        rotateButton.setOnAction(event -> {
            rotateCurrentTile();
        });
        root.getChildren().add(currentTile);
        root.getChildren().remove(displayBoard);
        generateBoard();
        unGrayMovementSlide();
    }


    public void getCorrectRotation(Floor test) {
        if (test.toString().equals("class Corner")) {
            if (test.getOrientation() == 0) {
                currentTile.setRotate(180);
            } else if (test.getOrientation() == 1) {
                currentTile.setRotate(270);
            } else if (test.getOrientation() == 2) {
                currentTile.setRotate(90);
            }
        } else if (test.toString().equals("class Straight")) {
            if (test.getOrientation() == 1) {
                currentTile.setRotate(90);
            } else if (test.getOrientation() == 3) {
                currentTile.setRotate(90);
            } else if (test.getOrientation() == 2) {
                currentTile.setRotate(180);
            } else if (test.getOrientation() == 0) {
                currentTile.setRotate(180);
            }
        } else {
            if (test.getOrientation() == 1) {
                currentTile.setRotate(270);
            } else if (test.getOrientation() == 2) {
                currentTile.setRotate(180);
            } else if (test.getOrientation() == 0) {
                currentTile.setRotate(90);
            } else {
                currentTile.setRotate(0);
            }
        }
        te = test;
    }

    /**
     * Gets the image of the tile.
     * @param tile Tile to display.
     * @return Image of tile.
     */
    private Image getTileImage(Floor tile) {
        if (tile.toString().equals("class T_Shape")) {
            return t_ShapeImage;
        } else if (tile.toString().equals("class Straight")) {
            return straightImage;
        }
        return cornerImage;
    }

    /**
     * Rotates the tile to be inserted.
     */
    private void rotateCurrentTile() {
        //getCorrectRotation((Floor) te);
        System.out.println("The current rotation: " + currentTile.getRotate());
        if (currentTile.getRotate() == 90) {
            currentTile.setRotate(180);
        }else if (currentTile.getRotate() == 180) {
            currentTile.setRotate(270);
        }else if (currentTile.getRotate() == 270) {
            currentTile.setRotate(0);
        }else {
            currentTile.setRotate(90);
        }
        imageRotationForNewTile();

    }


    /**
     * Rotates the image of the tile.
     */
    public void imageRotationForNewTile() {
        Floor tile = (Floor) te;
            if (tile.toString().equals("class Corner")) {
                System.out.println("In here");
                if (currentTile.getRotate() == 180) {
                    tile.setOrientation(0);
                    System.out.println("Orientation is 1");
                } else if (currentTile.getRotate() == 270) {
                    tile.setOrientation(1);
                    System.out.println("Orientation is 2");
                } else if (currentTile.getRotate() == 90) {
                    tile.setOrientation(2);
                    System.out.println("Orientation is 3");
                } else {
                    tile.setOrientation(3);
                }

            } else {
                if (currentTile.getRotate() == 270) {
                    tile.setOrientation(1);
                } else if (currentTile.getRotate() == 180) {
                    tile.setOrientation(2);
                } else if (currentTile.getRotate() == 90) {
                    tile.setOrientation(3);
                } else {
                    tile.setOrientation(0);
                }
            }
        //getCorrectRotation(tile);
            te = tile;
        //

        }
    }



