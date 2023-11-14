package binaryTree;

import java.util.*;

/*
Implement a recursive, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.
Examples:

        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]
 */
public class PostOrder {
    public static void main(String[] args) {
        PostOrder obj = new PostOrder();
        Integer[] array = new Integer[]{5, 3, 8, 1, 4, 11};
        TreeNode root = new TreeNode(array);
        List<Integer> result1 = obj.postOrder1(root);
        List<Integer> result2 = obj.postOrder2(root);
        System.out.println(result1);
        System.out.println(result2);
    }
    private List<Integer> postOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.key);
    }
    private List<Integer> postOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            if(cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if(cur.right != null) {
                stack.offerFirst(cur.right);
            }
            result.add(cur.key);
        }
        Collections.reverse(result);
        return result;
    }

}
