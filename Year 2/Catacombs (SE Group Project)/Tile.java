/**
 * This class represents the Tiles. It is the super class of floor and action tile
 * @author George Brooks
 * @version 1.0
 */
public class Tile {

	private String tileType;


	public Tile (String tileType) {
		this.tileType = tileType;
	}


	public String getTileType() {
		return tileType;
	}


}


