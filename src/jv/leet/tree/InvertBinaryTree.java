package jv.leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 翻转二叉树
public class InvertBinaryTree {


    public static void main(String[] args) {
    }

    private static TreeNode invertBinaryTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return root;
    }

    private static TreeNode invertBinaryTree2(TreeNode root) {

        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();

        nodeList.add(root);

        while (nodeList.size() > 0) {

            TreeNode treeNode = nodeList.poll();

            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;

            if (treeNode.left != null) {
                nodeList.add(treeNode.left);
            }


            if (treeNode.right != null) {
            }
        }

        return root;
    }


    private static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public int value;

    }
}
