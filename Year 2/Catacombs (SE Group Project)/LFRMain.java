public class LFRMain {
    public static void main(String args[]) {
        Level level = LevelFileReader.fileReader();
        Bag<Tile> bag = level.getSilkBag();
        System.out.println(bag.getTile().getTileType());
    }
}
