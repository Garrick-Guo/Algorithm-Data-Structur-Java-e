package binaryTree;
/*
create test case for treeNode
 */
public class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.key = key;
    }
    public TreeNode(Integer[] array) {
        if (array.length != 0) {
            this.key = array[0];
            if (array.length > 1) {
                left = new TreeNode(array, 1);
            }
            if (array.length > 2) {
                right = new TreeNode(array, 2);
            }
        }
    }

    public TreeNode(Integer[] array, int index) {
        if (array[index] != null) {
            this.key = array[index];
            if (index * 2 + 1 < array.length) {
                left = new TreeNode(array, index * 2 + 1);
            }
            if (index * 2 + 2 < array.length) {
                right = new TreeNode(array, index * 2 + 2);
            }
        }
    }

    public void destruct() {
        if (left != null) {
            left.destruct();
        }
        if (right != null) {
            right.destruct();
        }
        left = null;
        right = null;
    }

}
