public class BSTNodeMain {

    public static void main(String[] args) {
        Profile profile = new Profile("Sam", "Mocock", 24, 3, 2000,
                "978082@swans.ac.uk", new String[]{"Football", "Programming"},
                new String[]{"5-a-side", "Gaming"});
        Profile profile1 = new Profile("Bob", "Dylan", 24, 5, 1941,
                "111000@swans.ac.uk", new String[]{"Music", "Guitar"},
                new String[]{"Performing", "Singing"});
        BSTNode bstNode = new BSTNode(profile);
        BSTNode bstNode1 = new BSTNode(profile1);
        bstNode.setL(bstNode1);
        System.out.println(bstNode.getL().getProfile().toString());
    }

}
