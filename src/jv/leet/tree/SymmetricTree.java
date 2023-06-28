package jv.leet.tree;

import java.util.LinkedList;

// 检查是否是对称二叉树

/**
 * 思路一： 递归
 * 递归实现每一个节点下，left 和 right 的值是否相同
 * 需要提供辅助方法
 * 思路二： 循环遍历
 * 不需要提供辅助方法
 * 需要使用额外空间，空间复杂度为  O(N)
 */
public class SymmetricTree {

    public static void main(String[] args) {

    }

    private static boolean isSymmetric2(TreeNode root) {

        if (root == null) {
            return true;
        }

        return dfs2(root.left, root.right);

    }

    private static boolean dfs2(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else if (left.value != right.value) {
            return false;
        }
        return dfs2(left.left, right.right) && dfs(left.right, right.left);
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

    // 第二次使用迭代实现
    private boolean isSymmetricTree22(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        LinkedList<TreeNode> nodeList = new LinkedList();
        nodeList.add(root.left);
        nodeList.add(root.right);

        while (nodeList.size() > 0) {

            TreeNode left = nodeList.pop();
            TreeNode right = nodeList.pop();

            if (left == null && right == null) {
                continue;
            }

            if (left == null) {
                return false;
            } else if (right == null) {
                return false;
            } else if (left.value != right.value) {
                return false;
            }

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
