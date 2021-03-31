package 其他.腾讯;

public class KthSmallestElementinaBST_230 {
    private int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k).val;
    }

    public TreeNode dfs(TreeNode node, int k) {
        if (node == null) {
            return null;
        }
        TreeNode left = dfs(node.left, k);

        counter++;
        if (counter == k) {
            return node;
        }

        TreeNode right = dfs(node.right, k);
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
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