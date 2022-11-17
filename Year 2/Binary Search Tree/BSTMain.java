public class BSTMain {
    /**
     * Creates profiles and then puts them in a binary search tree
     * @param args
     */
    public static void main(String[] args) {
        Profile profile = new Profile("Sam", "Mocock", 24, 3, 2000,
                "978082@swans.ac.uk", new String[]{"Football", "Programming"},
                new String[]{"5-a-side", "Gaming"});
        Profile profile1 = new Profile("Bob", "Dylan", 24, 5, 1941,
                "111000@swans.ac.uk", new String[]{"Music", "Guitar"},
                new String[]{"Performing", "Singing"});
        Profile profile2 = new Profile("Aaron", "Aardvark", 1, 1, 1990,
                "100000@swans.ac.uk", new String[]{"Animals", "Eating"},
                new String[]{"Bird spotting"});

        BST tree = new BST();

        tree.insertProfile(profile1);
        tree.insertProfile(profile);
        tree.insertProfile(profile2);
        System.out.println(tree.printNode(profile));
        System.out.println(tree.printNode(profile1));
        System.out.println(tree.printNode(profile2));
    }
}
