package com.anmol.service;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24
 */
public class SumOfLeftLeaves {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }

    public void dfs(TreeNode root, boolean isLeft) {
        if(root == null) return;
        if(root.left==null && root.right==null && isLeft) {
            sum +=root.val;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }
}
