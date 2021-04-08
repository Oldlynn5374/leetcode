package test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode solve (TreeNode root) {
        // write code here
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean isOver = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Queue<TreeNode> tempQueue = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempQueue.offer(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }else {
                    isOver = true;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }else {
                    isOver = true;
                }
            }

            if (isOver) {
                while (!tempQueue.isEmpty()) {
                    TreeNode node = tempQueue.poll();
                    node.left = null;
                    node.right = null;
                }
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(302);
        TreeNode n2 = new TreeNode(196);
        TreeNode n3 = new TreeNode(100);
        TreeNode n4 = new TreeNode(162);
        TreeNode n5 = new TreeNode(178);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n4.left = n5;

        TreeNode result = new Solution().solve(n1);
        System.out.println();
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}