package Tree;
/**
 * Created by Francis Yang on 5/4/17.
 */
public class TreeNode {
    public int val;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int _val) {
        val = _val;
        size = 1;
    }

    private void setLeftChild(TreeNode _left) {
        if (_left == null)
            return;
        left = _left;
        left.parent = this;
    }

    private void setRightChild(TreeNode _right) {
        if (_right == null)
            return;
        right = _right;
        right.parent = this;
    }

    public int size() {
        return size;
    }

    // Binary Search Tree: left.val <= this.val <= right.val
    public boolean isBST() {
        if (left != null) {
            if (val < left.val || !left.isBST()) {
                return false;
            }
        }

        if (right != null) {
            if (val > right.val || !right.isBST()) {
                return false;
            }
        }
        return true;
    }

    public int height() {
        int leftHeight = (left != null ? left.height() : 0);
        int rightHeight = (right != null ? right.height() : 0);
        return 1 + Math.max (leftHeight, rightHeight);
    }

    public TreeNode find(int _val) {
        if (_val == val) {
            return this;
        } else if (_val < val) {
            return left != null ? left.find(_val) : null;
        } else {
            return right != null ? right.find(_val) : null;
        }
    }

    public void print() {
        BTreePrinter.printNode(this);
    }

    private static TreeNode createMinimalBST(int arr[], int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.setLeftChild(createMinimalBST(arr, 0, mid - 1));
        node.setRightChild(createMinimalBST(arr, mid + 1, end));
        return node;
    }

    public static TreeNode createMinimalBST(int arr[]) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    public void insertInOrder(int _val) {
        if (_val <= val) {
            if (left == null) {
                setLeftChild(new TreeNode(_val));
            } else {
                left.insertInOrder(_val);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(_val));
            } else {
                right.insertInOrder(_val);
            }
        }
        size++;
    }
}
