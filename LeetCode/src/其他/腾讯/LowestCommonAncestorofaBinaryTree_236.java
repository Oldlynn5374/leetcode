package 其他.腾讯;

public class LowestCommonAncestorofaBinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


    private TreeNode reuslt = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return reuslt;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }

        dfs(root.left, p ,q);
        if (reuslt != null) {
            return;
        }
        dfs(root.right, p ,q);
        if (reuslt != null) {
            return;
        }

        boolean left = foundPQ(root.left, p ,q);
        if (left) {
            reuslt = root.left;
            return;
        }
        boolean right = foundPQ(root.right, p ,q);
        if (right) {
            reuslt = root.right;
            return;
        }

        if (foundPQ(root, p, q)) {
            reuslt = root;
        }

    }

    public boolean foundPQ(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean foundP = false;
        boolean foundQ = false;

        if (node == p) {
            foundP = true;
        }
        if (node == q) {
            foundQ = true;
        }

        if (foundP) {
            foundQ = contain(node.left, q) || contain(node.right, q);
        } else if (foundQ) {
            foundP = contain(node.left, p) || contain(node.right, p);
        }else {
            foundQ = contain(node.left, q) || contain(node.right, q);
            foundP = contain(node.left, p) || contain(node.right, p);
        }

        if (foundP && foundQ) {
            return true;
        }
        return false;
    }

    public boolean contain(TreeNode node, TreeNode value) {
        if (node == null) {
            return false;
        }
        if (node == value) {
            return true;
        }
        boolean left = contain(node.left, value);
        if (left) {
            return true;
        }
        boolean right = contain(node.right, value);
        if (right) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        System.out.println(new LowestCommonAncestorofaBinaryTree_236().lowestCommonAncestor(n1, n6, n9).val);
    }

}
