package jv.leet.tree;

// 最近最先祖先
public class LowAncestor {

    public static void main(String[] args) {

    }

    /**
     * 从 root 出发，如果找到了其中一个节点 A
     * 如果另一个节点在该节点的下方， 那么他们的最近公共祖先 就是节点 A
     * 否则，就是 root。
     * 反之，B 也是一样的。
     */
    private static TreeNode loWestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = loWestCommonAncestor(root.left, p, q);
        TreeNode right = loWestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    //第二遍
    private static TreeNode loWestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = loWestCommonAncestor2(root.left, p, q);
        TreeNode right = loWestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private static TreeNode loWestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = loWestCommonAncestor3(root.left, p, q);
        TreeNode right = loWestCommonAncestor3(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
    private static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public int value;

    }
}
