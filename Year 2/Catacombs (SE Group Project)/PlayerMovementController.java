import javafx.scene.control.Button;

import java.util.Arrays;
/**
 * Class that deals with the buttons that control player movement and methods that control the buttons
 * @author Declan McGauley
 * @version 1.0
 */
public class PlayerMovementController {
	private Profile profile = new Profile();
	private Game game;
	private ActionButtonController ungreyControl;
	
	public Game getGame() {
		return game;
	}

	public Player getTestPlayer() {
		return testPlayer;
	}
	
	public void setTestPlayer(Player player) {
		this.testPlayer = player;
	}
 	
	private Player testPlayer;
	private Button buttonDown = new Button("Down");
	private Button buttonUp = new Button("Up");
	private Button buttonLeft = new Button("Left");
	private Button buttonRight = new Button("Right");
	private Button skipTurn = new Button("Skip Moving");
	private GameboardController l;
	
	/**
	 * Gets how many players are playing from the menus and creates a game for that number of players
	 * creates a player instance from the game class
	 * @param gameboard
	 * @param gameboardController
	 */
	public PlayerMovementController(Gameboard gameboard, GameboardController gameboardController) {
		l = gameboardController;
		ungreyControl = l.getActionButtonController();
		int numPlayers = NewGameMenuController.getNumPlayers();
		if (numPlayers == 2) {
			game = Player2MenuController.getGame();
		} else if (numPlayers == 3) {
			game = Player3MenuController.getGame();
		} else if (numPlayers == 4) {
			game = Player4MenuController.getGame();
		} else{
			game = LoadGameMenuController.getGame();
		}
		testPlayer = game.getPlayer();
		game.nextPlayer();
		skipTurn.setDisable(true);
	}

	/**
	 * Implements the button to move a player down if a down move is available 
	 * @param board - active game board
	 * @return - button down to move player down
	 */
	public Button getButtonDown(Gameboard board) {

		if (!testPlayer.checkMove(board, "down")) {
			buttonDown.setDisable(true);
		}
		buttonDown.setOnAction(event -> {
			testPlayer.move(board, "down");
			testPlayer = game.getPlayer();

			buttonChecks(board);
			l.updatePlayerImageLocation();

			System.out.println(testPlayer.getProfile().getUsername());
			ungreyControl = l.getActionButtonController();
			ungreyControl.getButtonDrawTile(board).setDisable(false);

			disableMovementButtons();
			if(testPlayer.isDoubleMove()) {
				buttonChecks(board);
			}

			if(!testPlayer.isDoubleMove()) {
				game.nextPlayer();
			}else {
				testPlayer.setDoubleMove(false);
			}
		});
		return buttonDown;
	}

	/**
	 * Implements the button to move a player left if a left move is available 
	 * @param board - active game board
	 * @return - button left to move player left
	 */
	public Button getButtonLeft(Gameboard board) {
		if (!testPlayer.checkMove(board, "left")) {
			buttonLeft.setDisable(true);
		}
		buttonLeft.setOnAction(event -> {
			testPlayer.move(board, "left");
			testPlayer = game.getPlayer();
			buttonChecks(board);
			l.updatePlayerImageLocation();
			System.out.println(testPlayer.getProfile().getUsername());
			ungreyControl = l.getActionButtonController();
			ungreyControl.getButtonDrawTile(board).setDisable(false);
			disableMovementButtons();
			if(testPlayer.isDoubleMove()) {
				buttonChecks(board);
			}

			if(!testPlayer.isDoubleMove()) {
				game.nextPlayer();
			}else {
				testPlayer.setDoubleMove(false);
			}

		});
		return buttonLeft;
	}

	/**
	 * Implements the button to move a player right if a right move is available 
	 * @param board - active game board
	 * @return - button right to move player right
	 */
	public Button getButtonRight(Gameboard board) {
		if (!testPlayer.checkMove(board, "right")) {
			buttonRight.setDisable(true);


		}
		buttonRight.setOnAction(event -> {
			testPlayer.move(board, "right");
			testPlayer = game.getPlayer();
			buttonChecks(board);
			l.updatePlayerImageLocation();
			System.out.println(testPlayer.getProfile().getUsername());
			ungreyControl = l.getActionButtonController();
			ungreyControl.getButtonDrawTile(board).setDisable(false);
			disableMovementButtons();
			if(testPlayer.isDoubleMove()) {
				buttonChecks(board);
			}

			if(!testPlayer.isDoubleMove()) {
				game.nextPlayer();
			}else {
				testPlayer.setDoubleMove(false);
			}
		});
		return buttonRight;
	}

	
	/**
	 * Implements the button to move a player up if a up move is available 
	 * @param board - active game board
	 * @return - button right up move player up
	 */
	public Button getButtonUp(Gameboard board) {
		if (!testPlayer.checkMove(board, "up")) {
			buttonUp.setDisable(true);
		}
		buttonUp.setOnAction(event -> {
			testPlayer.move(board, "up");
			testPlayer = game.getPlayer();
			buttonChecks(board);
			l.updatePlayerImageLocation();

			System.out.println(testPlayer.getProfile().getUsername());
			ungreyControl = l.getActionButtonController();
			ungreyControl.getButtonDrawTile(board).setDisable(false);
			disableMovementButtons();
			if(testPlayer.isDoubleMove()) {
				buttonChecks(board);
			}

			if(!testPlayer.isDoubleMove()) {
				game.nextPlayer();
			}else {
				testPlayer.setDoubleMove(false);
			}
		});
		return buttonUp;
	}
	
	/**
	 * Implements the button to skip a turn if you are not able to move
	 * @param board
	 * @return - button skip turn
	 */
	public Button getButtonSkipTurn(Gameboard board) {
		skipTurn.setOnAction(event -> {
			testPlayer = game.getPlayer();
			ungreyControl = l.getActionButtonController();
			buttonChecks(board);
			skipTurn.setDisable(true);
			game.nextPlayer();
			
		});
		return skipTurn;
	}

	/**
	 * checks if a player can move in any direction and enables the player movement buttons if you are able to
	 * if there are no enabled buttons then the skip turn button is enabled
	 * @param board
	 */
	public void buttonChecks(Gameboard board) {
		boolean cantMove = true;
		System.out.println(Arrays.toString(testPlayer.getLocation()));
		if (!testPlayer.checkMove(board, "up")) {
			buttonUp.setDisable(true);
		} else {
			buttonUp.setDisable(false);
			cantMove = false;
		}
		if (!testPlayer.checkMove(board, "right")) {
			buttonRight.setDisable(true);
		} else {
			buttonRight.setDisable(false);
			cantMove = false;
		}
		if (!testPlayer.checkMove(board, "down")) {
			buttonDown.setDisable(true);
		} else {
			buttonDown.setDisable(false);
			cantMove = false;
		}
		if (!testPlayer.checkMove(board, "left")) {
			buttonLeft.setDisable(true);
		} else {
			buttonLeft.setDisable(false);
			cantMove = false;
		}
		ungreyControl = l.getActionButtonController();
		if (cantMove == true && ungreyControl.getIsTileDrawn()) {
			skipTurn.setDisable(false);
		}
		ungreyControl.setTileDrawn(false);
		cantMove = false;
 
	}
	
	/**
	 * disables the movement buttons
	 */
	public void disableMovementButtons() {
		buttonUp.setDisable(true);
		buttonDown.setDisable(true);
		buttonLeft.setDisable(true);
		buttonRight.setDisable(true);

	}
	


}




