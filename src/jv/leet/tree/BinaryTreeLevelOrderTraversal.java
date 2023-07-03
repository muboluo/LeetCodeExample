package jv.leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 二叉树遍历, 按照层次去遍历
public class BinaryTreeLevelOrderTraversal {


    /**
     * 层次遍历之迭代
     */
    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {

        // 存放每层的数据
        LinkedList<TreeNode> nodeList = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        nodeList.add(root);

        // set terminal
        while (nodeList.size() != 0) {

            List<Integer> currentLevel = new ArrayList<>();

            int currentLevelSize = nodeList.size();

            for (int i = 0; i < currentLevelSize; i++) {

                TreeNode node = nodeList.removeFirst();

                currentLevel.add(node.value);

                if (node.left != null) {
                    nodeList.add(node.left);
                }

                if (node.right != null) {
                    nodeList.add(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }


    // 第一种方法 - 第二遍
    private static List<List<Integer>> leverOrderTraversal_1_2(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> currentList = new LinkedList<>();

        currentList.add(root);

        while (!currentList.isEmpty()) {

            int len = currentList.size();

            List<Integer> currentLevelList = new ArrayList<>();

            for (int i = 0; i < len; i++) {

                TreeNode pop = currentList.removeFirst();
                currentLevelList.add(pop.value);

                if (pop.left != null) {
                    currentList.add(pop.left);
                }
                if (pop.right != null) {
                    currentList.add(pop.right);
                }
            }
            result.add(currentLevelList);
        }

        return result;
    }

    public static List<List<Integer>> levelOrderTraversal_2(TreeNode node) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(1, result, node);
        return result;

    }

    private static void dfs(int index, List<List<Integer>> result, TreeNode root) {

        // 判断当前层级有没有保存数据的 list

        if (result.size() < index) {
            result.add(new ArrayList<>());
        }

        result.get(index - 1).add(root.value);

        if (root.left != null) {
            dfs(index + 1, result, root.left);
        }

        if (root.right != null) {
            dfs(index + 1, result, root.right);
        }
    }


    private static List<List<Integer>> levelOrderTraversal_2_2(TreeNode node) {

        if (node == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs2(1, result, node);

        return result;
    }

    private static void dfs2(int index, List<List<Integer>> result, TreeNode node) {

        if (node == null) {
            return;
        }

        if (result.size() < index) {
            result.add(new ArrayList<>());
        }

        result.get(index - 1).add(node.value);

        if (node.left != null) {
            dfs2(index + 1, result, node.left);
        }

        if (node.right != null) {
            dfs2(index + 1, result, node.right);
        }
    }

    private static List<List<Integer>> levelOrderTraversal_2_3(TreeNode node) {


        if (node == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs3(node, result, 1);
        return result;
    }

    private static void dfs3(TreeNode node, List<List<Integer>> result, int currentLevel) {

        if (result.size() < currentLevel) {
            result.add(new ArrayList<>());
        }

        result.get(currentLevel - 1).add(node.value);

        if (node.left != null) {
            dfs3(node.left, result, currentLevel + 1);
        }

        if (node.right != null) {

            dfs3(node.right, result, currentLevel + 1);
        }
    }

    private static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public int value;

    }

}
