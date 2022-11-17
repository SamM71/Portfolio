import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents the gameboard.
 * @author Jamie Withinshaw, Sam Mocock
 * @version 1.0
 */
public class Gameboard {
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    


    private Floor[][] boardLayout;

    public Bag getSilkBag() {
        return silkBag;
    }

    private Bag silkBag;
    Level level;

    public Level getLevel(){
        return level;
    }

    public Gameboard() {
        level = LevelFileReader.fileReader();
        silkBag = level.getSilkBag();
        this.height = level.getHeight();
        this.width = level.getWidth();
        boardLayout = new Floor[height][width];
        populateBoard();
    }


    savedLevel savedLevel;
    public Gameboard(int i){
        savedLevel = LoadFileReader.fileReader();
        silkBag = savedLevel.getSilkBag();
        this.height = savedLevel.getHeight();
        this.width = savedLevel.getWidth();
        boardLayout = new Floor[height][width];
        populateSavedBoard();

    }

    @Override
    public String toString() {
        String returnedString = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                returnedString = returnedString + boardLayout[i][j] + "\n";
            }

        }
        return returnedString;
    }

    public Floor[][] getBoardLayout() {
        return boardLayout;
    }

    /**
     * Gets the floor tile at the given location.
     * @param x The row of the tile
     * @param y The column of the tile
     * @return The floor tile at the given location
     */
    public Floor getFloorAt(int x, int y) {
        return boardLayout[x][y];
    }

    public Floor[] getRow(int x) {
        return boardLayout[x];
    }

    public void insertTileOnRight(Floor insertedTile, int row) {
        Floor[] shiftingRow = boardLayout[row];
        Floor temp = shiftingRow[0];

        int from = 1;
        for(; from < shiftingRow.length; from++) {
            shiftingRow[from - 1] = shiftingRow[from];
        }

        shiftingRow[from - 1] = insertedTile;

        for (int i = 0; i < boardLayout.length; i++) {
            boardLayout[row][i] = shiftingRow[i];
        }
        Floor testTile = temp;
        if (testTile.isOccupied) {
            testTile.setOccupied(false);
        }
        temp = testTile;
        silkBag.addTile(temp);
    }

    public void insertTileOnLeft(Floor insertedTile, int row) {
        Floor[] shiftingRow = boardLayout[row];
        Floor temp = shiftingRow[shiftingRow.length - 1];

        for (int i = shiftingRow.length-2; i >=0; i--) {
            shiftingRow[i+1] = shiftingRow[i];
        }
        shiftingRow[0] = insertedTile;

        for (int i = 0; i < boardLayout.length; i++) {
            boardLayout[row][i] = shiftingRow[i];
        }
        Floor testTile = temp;
/*        if (testTile.isOccupied) {
            testTile.setOccupied(false);
        }*/
        temp = testTile;
        silkBag.addTile(temp);
    }

    public Floor[] getCol(int col) {
        Floor[] column = new Floor[this.getHeight()];
        for (int i = 0; i < this.getHeight(); i++) {
            column[i] = boardLayout[i][col];
        }
        return column;
    }

    public void insertTileBottom(Floor insertedTile, int col) {
        Floor[] shiftingCol = new Floor[boardLayout.length];

        for (int i = 0; i < boardLayout.length; i++) {
            shiftingCol[i] = boardLayout[i][col];
        }
/*        if (shiftingCol[0].isOccupied) {
            shiftingCol[0].setOccupied(false);
        }*/
        silkBag.addTile(shiftingCol[0]);
        int from = 1;
        for(; from < shiftingCol.length; from++) {
            shiftingCol[from - 1] = shiftingCol[from];
        }

        shiftingCol[from - 1] = insertedTile;

        for (int i = 0; i < boardLayout.length; i++) {
            boardLayout[i][col] = shiftingCol[i];
        }
    }

    public void insertTileTop(Floor insertedTile, int col) {
        Floor[] shiftingCol = new Floor[boardLayout.length];
        Floor temp;

        for (int i = 0; i < boardLayout.length; i++) {
            shiftingCol[i] = boardLayout[i][col];
        }

        temp = shiftingCol[shiftingCol.length-1];
        for (int i = shiftingCol.length-2; i >=0; i--) {
            shiftingCol[i+1] = shiftingCol[i];
        }

        shiftingCol[0] = insertedTile;

        for (int i = 0; i < boardLayout.length; i++) {
            boardLayout[i][col] = shiftingCol[i];
        }
        Floor testTile = temp;
        if (testTile.isOccupied) {
            testTile.setOccupied(false);
        }
        temp = testTile;
        silkBag.addTile(temp);
    }

    /**
     * Takes a floor tile from the bag, and puts it on the given location on the board.
     */
    public ArrayList<FixedFileTile> t;
    public ArrayList<MovingFileTile> m;

    private void populateBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                fillWithFixed(i,j);

            }
        }
    }


    private void populateSavedBoard(){
        populateBoard();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                fillWithMoving(i,j);

            }
        }
        
    }


    private void fillWithFixed(int i, int j) {
        t = level.getFfts();
        for (FixedFileTile e : t) {
            if (e.getType().equals("CORNER") && e.getX() == i && e.getY() == j) {
                boardLayout[i][j] = new Corner(e.getOrientation(), true);
                return;
            } else if (e.getType().equals("STRAIGHT") && e.getX() == i && e.getY() == j) {
                boardLayout[i][j] = new Straight(e.getOrientation(), true);
                return;
            } else if (e.getType().equals("T-SHAPED") && e.getX() == i && e.getY() == j) {
                boardLayout[i][j] = new T_Shape(e.getOrientation(), true);
                return;
            } else if (e.getType().equals("GOAL") && e.getX() == i && e.getY() == j) {
            	boardLayout[i][j] = new Goal();
            	return;
            }
        }
        boardLayout[i][j] = (Floor) silkBag.getFloorTile();
    }
    private void fillWithMoving(int i, int j) {
        m = savedLevel.getMfts();
        for (MovingFileTile e : m){
            if (e.getType().equals("CORNER") && e.getX() == i && e.getY() == j) {
                boardLayout[i][j] = new Corner(e.getOrientation(), true);
                return;
            } else if (e.getType().equals("STRAIGHT") && e.getX() == i && e.getY() == j) {
                boardLayout[i][j] = new Straight(e.getOrientation(), true);
                return;
            } else if (e.getType().equals("T-SHAPED") && e.getX() == i && e.getY() == j) {
                boardLayout[i][j] = new T_Shape(e.getOrientation(), true);
                return;
            } else if (e.getType().equals("GOAL") && e.getX() == i && e.getY() == j) {
            	boardLayout[i][j] = new Goal();
            	return;
            }
        }
    }
}

