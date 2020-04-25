package com.anmol.service;

public class PathSumIII {

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        helper(root, sum, 0);
        return count;
    }

    public int helper(TreeNode root, int sum, int currSum) {
        if(root == null) return 0;

        currSum += root.val;
        if(currSum == sum) count++;
        int leftSum = helper(root.left, sum, 0);
        if(leftSum == sum) count++;
        int rightSum = helper(root.right, sum, 0);
        return leftSum+rightSum + root.val;
    }

    /**
     *     10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        PathSumIII pathSumIII = new PathSumIII();
        pathSumIII.pathSum(root, 8);
    }
}
