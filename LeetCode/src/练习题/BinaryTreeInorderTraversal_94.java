package 练习题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        TreeNode node = root;
        makeStack(node, stack, rightStack);

        while (stack.size() > 0) {
            TreeNode stackPeek;
            TreeNode rightPeek;
            if (stack.size() == 0) {
                stackPeek = null;
            }else {
                stackPeek = stack.peek();
            }
            if (rightStack.size() == 0) {
                rightPeek = null;
            }else {
                rightPeek = rightStack.peek();
            }

            if (stackPeek != rightPeek) {
                res.add(stack.pop().val);
            }else {
                node = stack.pop();
                rightStack.pop();

                makeStack(node, stack, rightStack);
            }
        }

        return res;
    }

    public void makeStack(TreeNode node, Stack<TreeNode> stack, Stack<TreeNode> rightStack) {
        while (node != null) {
            if (node.right != null) {
                stack.push(node.right);
                rightStack.push(node.right);
            }
            if (node != null) {
                stack.push(node);
            }
            node = node.left;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        List<Integer> list = new BinaryTreeInorderTraversal_94().inorderTraversal(null);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}