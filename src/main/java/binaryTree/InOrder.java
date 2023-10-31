package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Implement a recursive, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.
Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]
 */
public class InOrder {
    public static void main(String[] args) {
        InOrder obj = new InOrder();
        Integer[] array = new Integer[]{5,3,8,1,4,11};
        TreeNode root = new TreeNode(array);
        List<Integer> result = obj.inOrder1(root);
        List<Integer> result2 = obj.inOrder2(root);
        System.out.println(result);
        System.out.println(result2);
    }
    private List<Integer> inOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.key);
        helper(root.right, result);
    }
    private List<Integer> inOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null ) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pollFirst();
                result.add(node.key);
                cur = node.right;
            }
        }
        return result;
    }
}
