package com.anmol.service;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        int leftHeight = dfs(root.left, 1);
        int rightHeight = dfs(root.right, 1);
        return Math.abs(leftHeight - rightHeight) <=1;
    }

    public int dfs(TreeNode root, int height) {
        if(root == null) return height;
        int leftHeight = dfs(root.left, height+1);
        int rightHeight = dfs(root.right, height +1);
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        balancedBinaryTree.isBalanced(root);
    }
}
