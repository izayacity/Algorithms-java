package Tree;
/**
 * Created by Francis Yang on 5/4/17.
 */
public class TreeNode {
    public int data;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int val) {
        data = val;
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

    // Binary Search Tree: left.data <= this.data <= right.data
    public boolean isBST() {
        if (left != null) {
            if (data < left.data || !left.isBST()) {
                return false;
            }
        }

        if (right != null) {
            if (data > right.data || !right.isBST()) {
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

    public TreeNode find(int val) {
        if (val == data) {
            return this;
        } else if (val < data) {
            return left != null ? left.find(val) : null;
        } else {
            return right != null ? right.find(val) : null;
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

    public void insertInOrder(int val) {
        if (val <= data) {
            if (left == null) {
                setLeftChild(new TreeNode(val));
            } else {
                left.insertInOrder(val);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(val));
            } else {
                right.insertInOrder(val);
            }
        }
        size++;
    }
}
