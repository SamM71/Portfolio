import java.util.Arrays;

public class GameboardMain {
    public static void main(String[] args) {
        Gameboard testBoard = new Gameboard();
        Floor te = new Straight(1, false);
        System.out.println(Arrays.deepToString(testBoard.getBoardLayout()).replace("], ", "]\n"));
        
        GameboardController.main(null);



    }
}
