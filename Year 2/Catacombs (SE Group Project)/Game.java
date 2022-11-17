import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class controls the flow of the game.
 * @author Mekid
 * @version 1.0
 */
public class Game {
    
    private boolean gameStatus = false;
    private int numOfPlayers;
    private ArrayList<Profile> selectedPlayers = new ArrayList<Profile>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private int currentPlayer;

    //private GameboardController test = new GameboardController();
    private Gameboard game = new Gameboard();

    private Level current = LevelFileReader.fileReader();
    private savedLevel current2 = LoadFileReader.fileReader();
    //private Profile currentPlayer = profiles[0];

    /**
     * Creates a game with the right amount of players.
     * @param selectedPlayers The selected players (profiles).
     */
    public Game(ArrayList<Profile> selectedPlayers){
    	this.selectedPlayers = selectedPlayers;
    	this.currentPlayer = 0;
        setPlayers(selectedPlayers.size());
        //LevelFileReader current = new LevelFileReader();
        System.out.println(selectedPlayers.size());
        if (selectedPlayers.size() == 2){
            Player player1 = new Player(1, current.getStartPos().get(0), selectedPlayers.get(0));
            players.add(0, player1);
            Player player2 = new Player(2, current.getStartPos().get(1), selectedPlayers.get(1));
            players.add(1, player2);
            
        }
        else if(selectedPlayers.size() == 3){
            Player player1 = new Player(1, current.getStartPos().get(0), selectedPlayers.get(0));
            players.add(0, player1);
            Player player2 = new Player(2, current.getStartPos().get(1), selectedPlayers.get(1));
            players.add(1, player2);
            Player player3 = new Player(3, current.getStartPos().get(2), selectedPlayers.get(2));
            players.add(2, player3);
        }
        else{
            Player player1 = new Player(1, current.getStartPos().get(0), selectedPlayers.get(0));
            players.add(0, player1);
            Player player2 = new Player(2, current.getStartPos().get(1), selectedPlayers.get(1));
            players.add(1, player2);
            Player player3 = new Player(3, current.getStartPos().get(2), selectedPlayers.get(2));
            players.add(2, player3);
            Player player4 = new Player(4, current.getStartPos().get(3), selectedPlayers.get(3));
            players.add(3, player4);
        }
    }

    /**
     * Overloaded game constructor for Load Game, uses LoadGameFileReaded to read saved game
     */
    public Game(ArrayList<Profile> selectedPlayers, int l){
    	this.selectedPlayers = selectedPlayers;
    	this.currentPlayer = 0;
        setPlayers(selectedPlayers.size());
        //LevelFileReader current = new LevelFileReader();
        System.out.println(selectedPlayers.size());
        if (selectedPlayers.size() == 2){
            Player player1 = new Player(1, current2.getStartPos().get(0), selectedPlayers.get(0));
            players.add(0, player1);
            Player player2 = new Player(2, current2.getStartPos().get(1), selectedPlayers.get(1));
            players.add(1, player2);
            
        }
        else if(selectedPlayers.size() == 3){
            Player player1 = new Player(1, current2.getStartPos().get(0), selectedPlayers.get(0));
            players.add(0, player1);
            Player player2 = new Player(2, current2.getStartPos().get(1), selectedPlayers.get(1));
            players.add(1, player2);
            Player player3 = new Player(3, current2.getStartPos().get(2), selectedPlayers.get(2));
            players.add(2, player3);
        }
        else{
            Player player1 = new Player(1, current2.getStartPos().get(0), selectedPlayers.get(0));
            players.add(0, player1);
            Player player2 = new Player(2, current2.getStartPos().get(1), selectedPlayers.get(1));
            players.add(1, player2);
            Player player3 = new Player(3, current2.getStartPos().get(2), selectedPlayers.get(2));
            players.add(2, player3);
            Player player4 = new Player(4, current2.getStartPos().get(3), selectedPlayers.get(3));
            players.add(3, player4);
        }
    }



    public ArrayList<Player> getPlayerArray() {
        return players;
    }

    private void setPlayers(int numOfPlayers){
        this.numOfPlayers = numOfPlayers;
    }

    public int getPlayers() {
        return numOfPlayers;
    }

    public void increaseScore(){
        selectedPlayers.get(currentPlayer).addWin();
        
    }

    public void setStatus(){
        gameStatus = true;
    }

    public boolean getStatus(){
        return gameStatus;
    }
    public void nextPlayer(){
        if (currentPlayer == numOfPlayers - 1){
            currentPlayer = 0;
        }
        else{
            currentPlayer++;
        }
        
    }
    
    public Player getPlayer() {
    	Player player = players.get(currentPlayer);
    	return player;
    }

    /**
     * Saves the game.
     */
    public void saveGame() {

        int length = current.getHeight();
        String len = new Integer(length).toString();
        int width = current.getWidth();
        String wid = new Integer(width).toString();

        try {
            File gameStatus = new File("src/saveGame1.txt");
            FileWriter saveGame = new FileWriter(gameStatus, false);
            BufferedWriter bw = new BufferedWriter(saveGame);
            // writes length and width
            bw.write(len + "," + wid);
            bw.newLine();
            // writes the tiles and the data corresponding to them 
            for (int x = 0; x < length; x++) {
                for (int y = 0; y < width; y++) { 
                    String ex = new Integer(x).toString();
                    String wy = new Integer(y).toString();
                    String type = game.getBoardLayout()[x][y].toString();
                    String orientation = new Integer(game.getBoardLayout()[x][y].getOrientation()).toString();
                    int fixed = (game.getBoardLayout()[x][y].isFixed()) ? 1 : 0;
                    String isFixed = new Integer(fixed).toString();
                    bw.write(ex + "," + wy + ","  + type + "," + orientation + "," + isFixed);
                    bw.newLine();
                    bw.flush(); 
                }
            }

            // writes the number of tiles in bag
            int numofBagTiles = current.getActionTiles();
            bw.write(new Integer(numofBagTiles).toString());
            bw.newLine();
            // writes the tiles in bag
            for (int z = 0 ; z < game.getSilkBag().size() ; z ++){

                bw.write(game.getSilkBag().getTile().getTileType());
                bw.newLine();
            }

            
            // number of players
            int numPlayers = getPlayers();
            bw.write(new Integer(numPlayers).toString());
            bw.newLine();
            // writes the players info

            int playerNumber = 0;

            for (int ply = 0; ply < players.size(); ply++){
                playerNumber ++;
                String playerNum = new Integer(playerNumber).toString();
                Player p = players.get(ply);
                int playerx = p.getLocation()[1];
                String x = new Integer(playerx).toString();
                int playery = p.getLocation()[0];
                String y = new Integer(playery).toString();

                String username = p.getProfile().getUsername();
                String gamesPlayed = new Integer(p.getProfile().getGamesPlayed()).toString();
                String amtOfWins = new Integer(p.getProfile().getAmtOfWins()).toString();
                String amtOfLoss = new Integer(p.getProfile().getAmtOfLosses()).toString();

                bw.write(playerNum + "," + x + "," + y + "," + username + "," + gamesPlayed + "," + amtOfWins + "," + amtOfLoss);
                bw.newLine();
                bw.flush();
            }
            


            // writes the tiles the players hold
            //int counter = 0;
            for (int p = 0; p < numPlayers; p ++){
                String size = new Integer(players.get(p).getItemList().size()).toString();
                bw.write(size);
                bw.newLine();
                
                
                for (int a = 0; a < numPlayers; a++){
                    Player test = players.get(a);
                    String playerIndex = new Integer(a).toString();
                    for (int l = 0; l < test.getItemList().size(); l++){
                        bw.write(playerIndex + "," + test.getItemList().get(l).getTileType());
                        bw.newLine();
                        bw.flush();
                    }
                    
                    //bw.newLine();
                    bw.flush();
                }
                bw.flush();
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /**
     * Gets the player that just had their turn.
     * @return Previous player.
     */
    public Player getLastPlayer() {
    	if (currentPlayer == 0) {
    		Player lastPlayer = players.get(players.size());
    		return lastPlayer;
    	} else {
    		Player lastPlayer = players.get(currentPlayer - 1);
    		return lastPlayer;
    	}
    }
    
    
    
}

    









