import java.util.ArrayList;
/**
 * 
 * This class represents that players that will be playing the game
 * @author Declan McGauley 984379
 * @version 1.0
 */
public class Player {
	public int getPlayerNumber() {
		return playerNumber;
	}

	private int playerNumber;
	private int[] playerLocation;
	private int[] lastLocation;
	private int[] secondLastLocation;
	private ArrayList<Action> itemList = new ArrayList<Action>();
	private Profile profile;
	private boolean doubleMove = false;
	private Floor currentFloor;

	/**
	 * Constructor for player
	 * @param playerNum
	 * @param location
	 * @param prof
	 */
	public Player(int playerNum, int[] location, Profile prof) {
		setPlayerNumber(playerNum);
		setLocation(location);
		setProfile(prof);

	}

	
	public void setPlayerNumber(int playerNum) {
		this.playerNumber = playerNum;
	}


	public void setLocation(int[] location) {
		this.playerLocation = new int[] {location[0],location[1]};
	}

	public void setProfile(Profile prof) {
		this.profile = prof;
	}

	public void setDoubleMove(boolean doubleMove) {
		this.doubleMove = doubleMove;
	}

	public void setItemList(ArrayList<Action> itemList) {
		this.itemList = itemList;
	}


	/**
	 * selects a tile from the bag
	 * checks what type the tile is and returns the tile that is selected
	 * @param silkBag
	 * @return Tile selectedTile
	 */
	public Tile selectATile(Bag silkBag) {
		Tile selectedTile = silkBag.getTile();

		if (selectedTile.getTileType().equals("Action")) {
			itemList.add((Action) selectedTile);
			return selectedTile;
		} else {
			currentFloor = (Floor) selectedTile;
			return selectedTile;
		}
	}

	
	public Tile getCurrentFloor() {
		return this.currentFloor;
	}

	/*
	 * Gets the players location
	 * @return int[] playerLocation 
	 */
	public int[] getLocation() {
		return this.playerLocation;
	}

	/*
	 * Gets the players last Location before moving
	 * @return int[] lastLocation
	 */
	public int[] getLastLocation() {
		return this.lastLocation;
	}

	/*
	 * gets the players second to last position after the player has moved twice
	 * @return int[] second 
	 */
	public int[] getSecondLastLocation() {
		return this.secondLastLocation;
	}

	public ArrayList<Action> getItemList() {
		return this.itemList;
	}

	public Profile getProfile(){
		return profile;
	}

	/**
	 * moves the player in a given direction
	 * @param gameBoard
	 * @param direction
	 */
	public void move(Gameboard gameBoard, String direction) {

		if (direction.equals("up")) {
			moveUp(gameBoard);
		} else if (direction.equals("down")) {
			moveDown(gameBoard);
		} else if (direction.equals("left")) {
			moveLeft(gameBoard);
		} else {
			moveRight(gameBoard);
		} if (doubleMove) {
			doubleMove();
		}
	}

	/**
	 * sets the double move attribute to false
	 */
	public void doubleMove() {
		setDoubleMove(false);
		//get press
	}

	/**
	 * returns the value for double Move
	 * double move is used when we are playing a double move action tile
	 * @return doubleMove
	 */
	public boolean isDoubleMove() {
		return doubleMove;
	}

	
	/**
	 * Method that moves the player one tile upwards on the gameboard
	 * checks if you are at the border, if you are you are looped around and if not it moves you up a tile
	 * @param gameBoard
	 */
	public void moveUp(Gameboard gameBoard) {
		System.out.println("y: " + this.playerLocation[0] + " x: " + this.playerLocation[1]);
		Floor currentTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
		if (borderCheck("up", gameBoard)) {
			currentTile.setOccupied(false);
			secondLastLocation = lastLocation;
			lastLocation = playerLocation;
			this.setLocation(new int[] {playerLocation[0] - 1, playerLocation[1]});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("Valid move");
		} else {
			currentTile.setOccupied(false);
			this.setLocation(new int[] {gameBoard.getHeight() - 1, playerLocation[1]});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("looped");
		}

	}

	/**
	 * Method that moves the player one tile downwards on the gameboard
	 * checks if you are at the border, if you are you are looped around and if not it moves you up a tile
	 * @param gameBoard
	 */
	public void moveDown(Gameboard gameBoard) {
		System.out.println("y: " + this.playerLocation[0] + " x: " + this.playerLocation[1]);
		Floor currentTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);

		if (borderCheck("down", gameBoard)) {
			currentTile.setOccupied(false);
			secondLastLocation = lastLocation;
			lastLocation = playerLocation;
			this.setLocation(new int[] {playerLocation[0] + 1, playerLocation[1]});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("Valid move");
		} else {
			currentTile.setOccupied(false);
			this.setLocation(new int[] {0, playerLocation[1]});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("Looped");
		}

	}

	/**
	 * Method that moves the player one tile left on the gameboard
	 * checks if you are at the border, if you are you are looped around and if not it moves you up a tile
	 * @param gameBoard
	 */
	public void moveLeft(Gameboard gameBoard) {
		System.out.println("y: " + this.playerLocation[0] + " x: " + this.playerLocation[1]);
		Floor currentTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);

		if (borderCheck("left", gameBoard)) {
			currentTile.setOccupied(false);
			secondLastLocation = lastLocation;
			lastLocation = playerLocation;
			this.setLocation(new int[] {playerLocation[0], playerLocation[1] - 1});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("Valid move");
		} else {
			currentTile.setOccupied(false);
			this.setLocation(new int[] {playerLocation[0], gameBoard.getWidth() - 1});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("looped");
		}

	}
	
	/**
	 * Method that moves the player one tile right on the gameboard
	 * checks if you are at the border, if you are you are looped around and if not it moves you up a tile
	 * @param gameBoard
	 */
	public void moveRight(Gameboard gameBoard) {
		System.out.println("y: " + this.playerLocation[0] + " x: " + this.playerLocation[1]);
		Floor currentTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);


		if (borderCheck("right", gameBoard)) {
			currentTile.setOccupied(false);
			secondLastLocation = lastLocation;
			lastLocation = playerLocation;
			this.setLocation(new int[] {playerLocation[0], playerLocation[1] + 1});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("Valid move");
		} else {
			currentTile.setOccupied(false);
			this.setLocation(new int[] {playerLocation[0], 0});
			Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
			newTile.setOccupied(true);
			System.out.println("looped");
		}

	}
	/*
	 * Prints an readable description of a player Object 
	 * @return String objectDescription
	 */
	@Override
	public String toString() {
		return "Player Number: " + playerNumber + " Player location: " + playerLocation[0] + " " + playerLocation[1];
	}

	/**
	 * checks if a move by the player is valid 
	 * @param gameBoard
	 * @param direction
	 * @return boolean checkMove
	 */
	public boolean checkMove(Gameboard gameBoard, String direction) {
		Floor currentTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1]);
		if (borderCheck(direction, gameBoard)) {

			if (direction.equals("up")) {

				if (checkCurrentTileDirection(direction, currentTile)) {
					Floor newTile = gameBoard.getFloorAt(playerLocation[0] - 1, playerLocation[1]);
					if (checkNextTile("down", newTile)) {
						return true;
					}
				}
				return false;
			} else if (direction.equals("down")) {

				if (checkCurrentTileDirection(direction, currentTile)) {
					Floor newTile = gameBoard.getFloorAt(playerLocation[0] + 1, playerLocation[1]);
					if (checkNextTile("up", newTile)) {
						return true;
					}
				}
				return false;
			} else if (direction.equals("left")) {

				if (checkCurrentTileDirection(direction, currentTile)) {
					Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1] - 1);
					if (checkNextTile("right", newTile)) {
						return true;
					}
				}
				return false;
			} else if (direction.equals("right")) {

				if (checkCurrentTileDirection(direction, currentTile)) {
					Floor newTile = gameBoard.getFloorAt(playerLocation[0], playerLocation[1] + 1);
					if (checkNextTile("left", newTile)) {
						return true;
					}
				}
				return false;
			}
			return false;


		}
		return false;
	}

	
	/**
	 * checks if the player is at the border of the gameboard
	 * @param direction
	 * @param gameBoard
	 * @return boolean borderCheck
	 */
	private boolean borderCheck(String direction, Gameboard gameBoard) {
		if(direction.equals("up")) {
			if (playerLocation[0] == 0) {
				return false;
			}
			return true;
		} else if (direction.equals("down")) {
			if (playerLocation[0] == gameBoard.getHeight() - 1) {
				return false;
			}
			return true;
		} else if (direction.equals("left")) {
			if (playerLocation[1] == 0) {
				return false;
			}
			return true;
		} else if (direction.equals("right")) {
			if (playerLocation[1] == gameBoard.getWidth() - 1) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * checks if you can move in the chosen direction from the tile that you are on
	 * @param direction
	 * @param tile
	 * @return boolean canMove
	 */
	private boolean checkCurrentTileDirection(String direction, Floor tile) {
		if (direction.equals("up")) {
			return tile.isUpMove();
		} else if (direction.equals("down")) {
			return tile.isDownMove();
		} else if (direction.equals("left")) {
			return tile.isLeftMove();
		}
		return tile.isRightMove();
	}

	/**
	 * checks if you are able to move on to the tile that you are trying to move to
	 * @param direction
	 * @param tile
	 * @return boolean checkNextTile
	 */
	private boolean checkNextTile(String direction, Floor tile) {
		if (direction.equals("up")) {
			if (!tile.isBurning()) {
				if (tile.isUpMove()) {
					return !tile.isOccupied();
				}
			}
			return false;
		} else if (direction.equals("down")) {
			if (!tile.isBurning()) {
				if (tile.isDownMove()) {
					return !tile.isOccupied();
				}
			}
			return false;
		} else if (direction.equals("left")) {
			if (!tile.isBurning()) {
				if (tile.isLeftMove()) {
					return !tile.isOccupied();
				}
			}
			return false;
		} else if (!tile.isBurning()){
			if (tile.isRightMove()) {
				return !tile.isOccupied();
			}
		}
		return false;
	}

	/**
	 * Checks for a Fire tile in array list
	 * @return - true if fire tile is in list
	 */
	public boolean checkFire() { 
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i) instanceof Fire){
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Checks for a Freeze tile in array list
	 * @return - true if fire tile is in list
	 */
	public boolean checkFreeze() { 
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i) instanceof Freeze){
				return true;
			} 
		}
		return false;
	}
	
	
	/**
	 * Checks for a DoubleAction tile in array list
	 * @return - true if DoubleAction tile is in list
	 */
	public boolean checkDoubleAction() { 
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i) instanceof DoubleAction){
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Checks for a BackTrack tile in array list
	 * @return - true if fire BackTrack is in list
	 */
	public boolean checkBackTrack() { 
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i) instanceof BackTrack){
				return true;
			} 
		}
		return false;
	}
}
