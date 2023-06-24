package jv.leet.tree;

import java.util.LinkedList;

// 检查是否是对称二叉树
public class SymmetricTree {

    public static void main(String[] args) {

    }

    // 递归实现
    private static boolean isSymmetric1(TreeNode root) {

        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);

    }

    private static boolean dfs(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.value != right.value) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    // 使用迭代实现
    private boolean isSymmetricTree2(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();

        nodeList.add(root.left);
        nodeList.add(root.right);

        while (nodeList.size() > 0) {

            TreeNode left = nodeList.pop();
            TreeNode right = nodeList.pop();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.value != right.value) {
                return false;
            }

            // set next level
            nodeList.add(left.left);
            nodeList.add(right.right);

            nodeList.add(left.right);
            nodeList.add(right.left);
        }

        return true;
    }

    private static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public int value;

    }
}
