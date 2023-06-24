package jv.leet.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        dfs(null, result);
    }

    public static void dfs(TreeNode node, List<Integer> result) {

        // 递归实现
        if (node == null) {
            return;
        }

        // 前序遍历
        //result.add(node.value);
        dfs(node.left, result);
        // 中序遍历
        result.add(node.value);
        dfs(node.right, result);
        // 后序遍历
        //result.add(node.value);
    }

    private static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public int value;

    }

    // 使用栈 实现
    private static List<Integer> inorderTraversal(TreeNode node) {

        // 定义 临时变量和结果

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        // 设置终止条件
        while (node != null || !stack.isEmpty()) {

            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    return result;
                }

                TreeNode pop = stack.pop();
                result.add(pop.value);
                node = pop.right;
            }
        }
        return result;
    }
}
