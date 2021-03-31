package 其他.腾讯;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum_124 {
    private int max;
    // private Map<TreeNode, int[]> lineMap;
    // private Map<TreeNode, Integer> allMap;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // lineMap = new HashMap<>();
        // allMap = new HashMap<>();
        max = root.val;
        dfs(root);

        return max;
    }

    public int dfs(TreeNode node){
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int mid = node.val;
        int line = mid, all = mid;
        if (left >= 0) {
            line += left > right ? left : right;
        }else if (right >= 0) {
            line += right > left ? right : left;
        }

        if (left > 0) {
            all += left;
        }
        if (right > 0) {
            all += right;
        }
        // lineMap.put(node, new int[]{line, all});
        // allMap.put(node, all);
        max = Math.max(max, all);
        return line;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(new BinaryTreeMaximumPathSum_124().maxPathSum(n1));
    }
}
