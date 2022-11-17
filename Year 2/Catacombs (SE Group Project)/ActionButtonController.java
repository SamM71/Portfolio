import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;

/**
 * This class represents the buttons used to implement the action tiles.
 * @author George Brooks, Sam Mocock
 * @version 1.0
 */
public class ActionButtonController {
	private Button buttonFire = new Button("Fire");
	private Button buttonFreeze = new Button("Freeze");
	private Button buttonDoubleAction = new Button("DoubleAction");
	private Button buttonBackTrack = new Button("BackTrack");
	private Button buttonDrawTile = new Button("Draw a tile");
	private Button buttonPlayerOne = new Button("Player One");
	private Button buttonPlayerTwo = new Button("Player Two");
	private Button buttonPlayerThree = new Button("Player Three");
	private Button buttonPlayerFour = new Button("Player Four");
	private boolean isTileDrawn = false;
	private Button saveGame = new Button("SaveGame");
	private Game game;
	private Player currentPlayer;
	private GameboardController gameboardController;
	private PlayerMovementController playerMovementController;
	private Gameboard board;
	private int numPlayers;
	private BackTrack toUse = new BackTrack();
	private Freeze freezeTile = new Freeze();


	/**
	 * Creates a ActionButtonController object and loads game based on the number of players.
	 * @param gameboard A Gameboard object.
	 * @param gameboardController A GameboardController object.
	 */
	public ActionButtonController(Gameboard gameboard, GameboardController gameboardController) {
		this.gameboardController = gameboardController;
		playerMovementController = gameboardController.getPlayerMovementController();
		board = gameboard;
		numPlayers = NewGameMenuController.getNumPlayers();
		
		//loads game based on number of players 
		if (numPlayers == 2) {
			game = Player2MenuController.getGame();
			
		} else if (numPlayers == 3) {
			game = Player3MenuController.getGame();
			buttonPlayerFour.setDisable(true);
		}  else if (numPlayers == 4) {
			game = Player4MenuController.getGame();
		}
		  else{
			game = LoadGameMenuController.getGame();
		  }

		
	}

	//private boolean isAction;

	public Tile getDrawnTile() {
		return drawnTile;
	}

	public boolean getIsTileDrawn() {
		return this.isTileDrawn;
	}

	public void setTileDrawn(boolean bool) {
		this.isTileDrawn = bool;
	}

	private Tile drawnTile;
	/**
	 * Implements a button to draw a tile for silk bag.
	 * @param board - the active game board.
	 * @return - button to allow a player to draw a tile.
	 */
	public Button getButtonDrawTile(Gameboard board) {

		buttonDrawTile.setOnAction(event -> {
			this.isTileDrawn = true;
			drawnTile = currentPlayer.selectATile(board.getSilkBag());

			if (drawnTile.getTileType().equals("Action")) {
				gameboardController.getPlayerMovementController().buttonChecks(board);
				buttonChecks();
			} else {
				buttonDrawTile.setDisable(true);
				gameboardController.showNextTile(drawnTile);
				gameboardController.getCorrectRotation((Floor) drawnTile);

			}
		});

		return buttonDrawTile;
	}

	/**
	 * Implements Fire action button if one is held by player.
	 * @param board - the active game board.
	 * @return - button to use fire action.
	 */
	public Button getButtonFire(Gameboard board) {
		currentPlayer = game.getPlayer();
		if (!currentPlayer.checkFire()) {
			buttonFire.setDisable(true);
		}
		
		buttonFire.setOnAction(event -> {
			int xCord = Integer.parseInt(JOptionPane.showInputDialog("Enter X co-ordinate:"));
			int yCord = Integer.parseInt(JOptionPane.showInputDialog("Enter Y co-ordinate:"));
			ArrayList<Action>itemList = currentPlayer.getItemList();
			boolean found = false;
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i) instanceof Fire && found == false){
					((Fire) itemList.get(i)).effect(xCord, yCord, board);
					itemList.remove(i);
					found = true;
				} 
			}
			
		System.out.println(xCord + " " + yCord + " Burned ");
		playerMovementController.buttonChecks(board);
		buttonFire.setDisable(true);
		});
		return buttonFire;
	}

	/**
	 * Implements Freeze button if one is held by player
	 * @param board - the active game board
	 * @return - button to use a freeze action
	 */
	public Button getButtonFreeze(Gameboard board) {
		currentPlayer =  game.getPlayer();
		if (!currentPlayer.checkFreeze()) {
			buttonFreeze.setDisable(true);
		}
		buttonFreeze.setOnAction(event -> {
			ArrayList<Action>itemList = currentPlayer.getItemList();
			int xCord = Integer.parseInt(JOptionPane.showInputDialog("Enter X co-ordinate:"));
			int yCord = Integer.parseInt(JOptionPane.showInputDialog("Enter Y co-ordinate:"));
			boolean found = false;
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i) instanceof DoubleAction && found == false){
					((Freeze) itemList.get(i)).effect(xCord, yCord, board);
					itemList.remove(i);
					found = true;
				} 
			}
			
			
			freezeTile.effect(xCord, yCord, board);
			System.out.println(xCord + " " + yCord + " frozen");
			buttonFreeze.setDisable(true);
			
		});
		return buttonFreeze;
	}


	/**
	 * Implements double action button if one is held by player.
	 * @param board - the active game board.
	 * @return - button to use a double action action.
	 */
	public Button getButtonDoubleAction(Gameboard board) {
		currentPlayer = game.getPlayer();
		if (!currentPlayer.checkDoubleAction()) {
			buttonDoubleAction.setDisable(true);
		}
		buttonDoubleAction.setOnAction(event -> {
			System.out.println("pressed");
			ArrayList<Action>itemList = currentPlayer.getItemList();
			boolean found = false;
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i) instanceof DoubleAction && found == false){
					DoubleAction toUse = (DoubleAction) itemList.get(i);
					toUse.effect(currentPlayer);
					itemList.remove(i);
					found = true;
				} 
			}	

		});
		return buttonDoubleAction;
	}

	/**
	 * Implements back track button if one is held by player.
	 * @param board - the active game board.
	 * @return - button to use a back track action.
	 */
	public Button getButtonBackTrack(Gameboard board) {
		currentPlayer = game.getPlayer();
		if (!currentPlayer.checkBackTrack()) {
			buttonBackTrack.setDisable(true);
		}
		greyBackTrackPlayers();
		buttonBackTrack.setOnAction(event -> {
			System.out.println("pressed");
			ArrayList<Action>itemList = currentPlayer.getItemList();
			System.out.println(itemList.toString());
			boolean found = false;
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i) instanceof BackTrack && found == false){
					playerChecks();
					buttonBackTrack.setDisable(true);
					itemList.remove(i);
					found = true;
				} 
			}	

		});
		return buttonBackTrack;

	}

	
	/**
	 * Implements the button to back track player one.
	 * @return - player one button.
	 */
	public Button getButtonPlayerOne() {
		buttonPlayerOne.setOnAction(event -> {
			//effect called on player one
			toUse.effect(game.getPlayerArray().get(0) , board);
			gameboardController.updatePlayerImageLocation();
			greyBackTrackPlayers();
		});
		return buttonPlayerOne;
	}
	
	/**
	 * Implements the button to back track player two.
	 * @return - player two button.
	 */
	public Button getButtonPlayerTwo() {
		buttonPlayerTwo.setOnAction(event -> {
			//effect called on player one
			toUse.effect(game.getPlayerArray().get(1) , board);
			gameboardController.updatePlayerImageLocation();
			greyBackTrackPlayers();
			
		});
		return buttonPlayerTwo;
	}
	
	/**
	 * Implements the button to back track player three.
	 * @return - player three button.
	 */
	public Button getButtonPlayerThree() {
		buttonPlayerThree.setOnAction(event -> {
			//effect called on player one
			toUse.effect(game.getPlayerArray().get(2) , board);
			gameboardController.updatePlayerImageLocation();
			greyBackTrackPlayers();
			
		});
		return buttonPlayerThree;
	}
	
	/**
	 * Implements the button to back track player four.
	 * @return - player four button.
	 */
	public Button getButtonPlayerFour() {
		buttonPlayerFour.setOnAction(event -> {
			//effect called on player one
			toUse.effect(game.getPlayerArray().get(3) , board);
			gameboardController.updatePlayerImageLocation();
			greyBackTrackPlayers();
			
		});
		return buttonPlayerFour;
	}
	

	/**
	 * Checks how may players are in game to activate correct player buttons.
	 */
	private void playerChecks(){
		switch (numPlayers) {
		case(2):
			buttonPlayerOne.setDisable(false);
		buttonPlayerTwo.setDisable(false);

		break;

		case(3):
			buttonPlayerOne.setDisable(false);
		buttonPlayerTwo.setDisable(false);
		buttonPlayerThree.setDisable(false);
		break;

		case(4):
			buttonPlayerOne.setDisable(false);
		buttonPlayerTwo.setDisable(false);
		buttonPlayerThree.setDisable(false);
		buttonPlayerFour.setDisable(false);
		break;
		}
	}
	
	/**
	 * Checks the which actions the current player has and enables if they have an action of that type.
	 */
	private void buttonChecks() {
		currentPlayer =  game.getPlayer();
		if (!currentPlayer.checkFire()) {
			buttonFire.setDisable(true);
		} else {
			buttonFire.setDisable(false);
		}
		if (!currentPlayer.checkFreeze()) {
			buttonFreeze.setDisable(true);
		} else {
			buttonFreeze.setDisable(false);
		}
		if (!currentPlayer.checkDoubleAction()) {
			buttonDoubleAction.setDisable(true);
		} else {
			buttonDoubleAction.setDisable(false);
		}
		if (!currentPlayer.checkBackTrack()) {
			buttonBackTrack.setDisable(true);
		} else {
			buttonBackTrack.setDisable(false);
		}
	}
	
	/**
	 * Disables player buttons.
	 */
	private void greyBackTrackPlayers() {
		buttonPlayerOne.setDisable(true);
		buttonPlayerTwo.setDisable(true);
		buttonPlayerThree.setDisable(true);
		buttonPlayerFour.setDisable(true);
	}


	public Button saveGame() {
		saveGame.setOnAction(event -> {
			//effect called on player one
			//game = Player2MenuController.getGame();
			game.saveGame();
			//System.out.println(game.getPlayers());
		});
		return saveGame;
	}
}
