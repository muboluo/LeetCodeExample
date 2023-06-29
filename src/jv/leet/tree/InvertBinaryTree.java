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

    private static TreeNode invertBinaryTree1_2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree1_2(root.left);
        invertBinaryTree1_2(root.right);
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
                nodeList.add(treeNode.right);
            }
        }

        return root;
    }

    private static TreeNode invertBinaryTree2_2(TreeNode root) {

        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> rootList = new LinkedList<>();

        rootList.add(root);

        while (rootList.size() > 0) {

            TreeNode remove = rootList.removeFirst();

            TreeNode temp = remove.left;
            remove.left = remove.right;
            remove.right = temp;
            if (remove.left != null) {
                rootList.add(temp.left);
            }
            if (remove.right != null) {
                rootList.add(temp.right);
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
