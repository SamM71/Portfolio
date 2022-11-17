public class BST {
    private BSTNode root;

    public BST() {
    }

    public void insertProfile(Profile p) {
        BSTNode bstNode = new BSTNode(p);

        if (this.root == null) {
            this.root = bstNode;
        } else {
            bstNode = findSpace(this.root, p);
        }
        System.out.println(p.toString());
    }

    /**
     * Recursive algorithm finds the correct place to put the new profile
     * @param node - the current node being compared
     * @param p - the reference to the profile that needs a node
     * @return the node to put the reference to the profile
     */
    private BSTNode findSpace(BSTNode node, Profile p) {
        String currentName = node.getProfile().getForename() + " " + node.getProfile().getSurname();
        String newProfileName = p.getForename() + " " + p.getSurname();
        BSTNode newNode = new BSTNode(p);

        /*
        If positive, go left. If negative, go right.
         */
        if (currentName.compareTo(newProfileName) > 0) {
            /*
            If a slot is found, set the slot to the new node and return it
             */
            if (node.getL() == null) {
                node.setL(newNode);
                return node.getL();
            } else {
                node = findSpace(node.getL(), p);
                return node;
            }
        } else if (currentName.compareTo(newProfileName) < 0) {
            /*
            If a slot is found, set the slot to the new node and return it
             */
            if (node.getR() == null) {
                node.setR(newNode);
                return node.getR();
            } else {
                node = findSpace(node.getR(), p);
                return node;
            }
        } else {
            /*
            This runs if the names are the same. Tries to find a slot for the Profile but there's a chance it won't
             */
            if (node.getL() == null) {
                node.setL(newNode);
                return node.getL();
            } else if (node.getR() == null) {
                node.setR(newNode);
                return node.getR();
            } else {
                System.out.println("No space for friend");
                return null;
            }
        }
    }

    /**
     *
     * @param p - profile
     * @return a string that represents the data of the node
     */
    public String printNode(Profile p) {
        BSTNode node = accessNode(p);
        //Stops error
        if (accessNode(p) == null) {
            return null;
        }
        String output = node.getProfile().toString();
        //Prints left child (mainly for testing)
        if (node.getL() != null) {
            output += "\nLeft: " + node.getL().getProfile().getForename();
        }
        //Prints right child (mainly for testing)
        if (node.getR() != null) {
            output += "\nRight: " + node.getR().getProfile().getForename();
        }
        output += "\n";
        return output;
    }

    //use if statements to find if profile is in a node

    /**
     *
     * @param p - profile to search for
     * @return the node that holds the correct data
     */
    public BSTNode accessNode(Profile p) {
        String profileName = p.getForename() + " " + p.getSurname();
        BSTNode searchNode = this.root;
        boolean found = false;
        try {
            while (!found) {
                String currentName = searchNode.getProfile().getForename() + " " + searchNode.getProfile().getSurname();
                /*
                If profile is found, change value of found. If positive, go left. If positive, go right.
                */
                if (currentName.compareTo(profileName) == 0) {
                    found = true;
                } else if (currentName.compareTo(profileName) > 0) {
                    searchNode = searchNode.getL();
                } else if (currentName.compareTo(profileName) < 0) {
                    searchNode = searchNode.getR();
                } else {
                    return null;
                }
            }
            return searchNode;
        }
        catch (NullPointerException e) {
            System.out.println("Node not found");
            return null;
        }
    }

}
