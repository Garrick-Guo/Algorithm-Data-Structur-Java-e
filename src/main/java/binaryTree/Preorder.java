package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Implement a recursive, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]
 */
public class Preorder {
    public static void main(String[] args) {
        Preorder obj = new Preorder();
        Integer[] array = new Integer[]{5,3,8,1,4,11};
        TreeNode root = new TreeNode(array);
        List<Integer> result = obj.preOrder1(root);
        List<Integer> result2 = obj.preOrder2(root);
        System.out.println(result);
        System.out.println(result2);
    }

    private List<Integer> preOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.key);
        helper(root.left, result);
        helper(root.right, result);
    }
    private List<Integer> preOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            result.add(cur.key);
        }
        return result;
    }
}
