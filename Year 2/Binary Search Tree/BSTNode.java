public class BSTNode {
    private Profile data;
    private BSTNode l;
    private BSTNode r;

    public BSTNode(Profile data) {
        this.data = data;
    }

    public Profile getProfile() {
        return this.data;
    }

    public void setL(BSTNode l) {
        this.l = l;
    }

    public void setR(BSTNode r) {
        this.r = r;
    }

    public BSTNode getL() {
        return this.l;
    }

    public BSTNode getR() {
        return this.r;
    }

}
