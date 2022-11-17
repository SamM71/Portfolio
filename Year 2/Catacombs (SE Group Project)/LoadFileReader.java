import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * File reader for loading games.
 * @author Mekid
 * @version 1.0
 */
public class LoadFileReader {

    public static savedLevel fileReader() {
        Scanner in;
        try {
            File f = new File("saveGame.txt");
            in = new Scanner(f);
            return fileScanner(in);
        } catch (FileNotFoundException e) {

            System.out.println("file not found");
            return null;
        }
    }

    private static savedLevel fileScanner(Scanner f) {
        
            String nextLine = f.nextLine();
            Scanner str = new Scanner(nextLine).useDelimiter(",");
            
            // Loads width and height
            int width = str.nextInt();
            int height = str.nextInt();
            str.close();
            

            //Info about fixed tiles
            ArrayList<FixedFileTile> ffts = new ArrayList<>();
            ArrayList<MovingFileTile> mfts = new ArrayList<>();
            for (int i = 0; i < (width * height) + 1; i++) {
                String TilesScanner = f.nextLine();
                Scanner TilesStr = new Scanner(TilesScanner).useDelimiter(",");

                while (TilesStr.hasNext()) {
                    int x = TilesStr.nextInt();
                    System.out.println(x);
                    int y = TilesStr.nextInt();
                    String type = TilesStr.next();
                    int orientation = TilesStr.nextInt();
                    int ifFixed = TilesStr.nextInt();
                    switch(ifFixed){
                        case 0:
                            MovingFileTile mft = new MovingFileTile(x, y, type, orientation);
                            mfts.add(mft);
                            break;
                        case 1:
                            FixedFileTile fft = new FixedFileTile(x, y, type, orientation);
                            ffts.add(fft);

                    }
                }
                TilesStr.close();
            }
            

            // Loads amt of floor tiles
            int amtOfFloor = f.nextInt();
            Bag<Tile> silkBag = new Bag<Tile>();

            //Add floor tiles to bag
            for (int i = 0; i < amtOfFloor; i++) {
                String floorType = f.nextLine();
                switch (floorType) {
                    case "class Corner":
                        Tile corner = new Corner(0, false);
                        silkBag.addTile(corner);
                        break;
                    case "class T_Shape":
                        Tile tShape = new T_Shape(0, false);
                        silkBag.addTile(tShape);
                        break;
                    case "class Straight":
                        Tile straight = new Straight(0, false);
                        silkBag.addTile(straight);
                        break;
                    case "ICE":
                        Tile ice = new Freeze();
                        silkBag.addTile(ice);
                        break;
                    case "FIRE":
                        Tile fire = new Fire();
                        silkBag.addTile(fire);
                        break;
                    case "DOUBLE MOVE":
                        Tile doubleMove = new DoubleAction();
                        silkBag.addTile(doubleMove);
                        break;
                    case "BACKTRACK":
                        Tile backtrack = new BackTrack();
                        silkBag.addTile(backtrack);
                        break;
                }
            }
            // Loads number of players
            int numOfPlayers = f.nextInt();
            // Loads starting positions
            ArrayList<int[]> startPos = getStart(f);

            //Loads players in saved game
            ArrayList<Player> players = new ArrayList<Player>();
            for (int pl = 0; pl < numOfPlayers; pl++){
                String player = f.nextLine();
                Scanner playerScan = new Scanner(player).useDelimiter(",");
                while(playerScan.hasNext()){
                    int playerNum = playerScan.nextInt();
                    int x = playerScan.nextInt();
                    int y = playerScan.nextInt();
                    int[] location = {x,y};
                    String username = playerScan.next();
                    int gamesPlayed = playerScan.nextInt();
                    int amtOfWins = playerScan.nextInt();
                    int amtOfLosses = playerScan.nextInt();
                    Profile prof = new Profile(username, gamesPlayed, amtOfWins, amtOfLosses);
                    Player Player = new Player(playerNum, location, prof);
                    players.add(Player);
                }
                playerScan.close();
            }

            // Loads action tiles that players hold
            for (int t = 0; t < numOfPlayers; t++){
                int numOfTiles = f.nextInt();
                ArrayList<Action> playerTiles = new ArrayList<Action>();
                for (t = 0; t < numOfTiles; t++){
                    
                    String tileType = f.nextLine();
                    switch (tileType) {
                        case "ICE":
                            Action ice = new Freeze();
                            playerTiles.add(ice);
                            break;
                        case "FIRE":
                            Action fire = new Fire();
                            playerTiles.add(fire);
                            break;
                        case "DOUBLE MOVE":
                            Action doubleMove = new DoubleAction();
                            playerTiles.add(doubleMove);
                            break;
                        case "BACKTRACK":
                            Action backtrack = new BackTrack();
                            playerTiles.add(backtrack);
                            break;
                    }   
                    players.get(t).setItemList(playerTiles);
                }
                
            }
            
            // MISSING MFTS COMMENTED OUT
            savedLevel level = new savedLevel(width, height, ffts, mfts, silkBag, players, startPos);

        return level;
        
    }
    
    

    private static ArrayList<int[]> getStart(Scanner f) {
        ArrayList<int[]> startingPositions = new ArrayList<int[]>();

        for (int i = 0; i < 4; i++) {
            String startingPosScanner = f.nextLine();
            Scanner startingPosString = new Scanner(startingPosScanner).useDelimiter(",");

            int startX = startingPosString.nextInt();
            int startY = startingPosString.nextInt();

            startingPositions.add(new int[]{startX,startY});
            startingPosString.close();
        }
        return startingPositions;
    }

    
    
}