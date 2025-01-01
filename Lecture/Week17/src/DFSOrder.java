import java.util.ArrayList;
import java.util.List;

public class DFSOrder<T> {

    private class BSTNode {
        private T key;
        private BSTNode leftChild;
        private BSTNode rightChild;
        private boolean isMarked;

        public BSTNode(T key) {
            this.key = key;
            leftChild = null;
            rightChild = null;
            isMarked = false;
        }

        public List<BSTNode> getChild() {
            List<BSTNode> childrens = new ArrayList<>();
            childrens.add(leftChild);
            childrens.add(rightChild);
            return childrens;
        }
    }

    public void preOrder(BSTNode x) {
        if (x == null) {
            return;
        }
        System.out.println(x.key);
        preOrder(x.leftChild);
        preOrder(x.rightChild);
    }

    public void inOrder(BSTNode x) {
        if (x == null) {
            return;
        }
        inOrder(x.leftChild);
        System.out.println(x.key);
        inOrder(x.rightChild);
    }

    public void postOrder(BSTNode x) {
        if (x == null) {
            return;
        }
        postOrder(x.leftChild);
        postOrder(x.rightChild);
        System.out.println(x.key);
    }

    public boolean isConnected(BSTNode s, BSTNode t) {
        s.isMarked = true;
        if (s == t) {
            return true;
        }
        for (BSTNode child : s.getChild()) {
            if (child.isMarked == true) {
                return false;
            }
            if (isConnected(child, t)) {
                return true;
            }
        }
        return false;
    }
}
