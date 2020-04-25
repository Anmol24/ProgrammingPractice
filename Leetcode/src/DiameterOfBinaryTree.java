package com.anmol.service;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode root, int height) {
        if(root== null) {

            return 0;

        }
        int left = dfs(root.left, height+1);
        int right = dfs(root.right, height+1);
        ans = Math.max(ans, left+right+1); // at any node calculate the left and right height + 1 would be the diameter for that node.need to find maximum of that node
        return Math.max(left, right) + 1;   // at any given node the height of the tree would be max of left and right height +1 for the node.
    }

    public int diameterOfBinaryTreeI(TreeNode root) {
        if(root == null)return 0;
        int leftHeight = dfs(root.left, 1);
        int rightHeight = dfs(root.right, 1);

        return Math.max(leftHeight + rightHeight - 2, Math.max(diameterOfBinaryTreeI(root.left), diameterOfBinaryTreeI(root.right)));
    }

    public int dfsI(TreeNode root, int height) {
        if(root== null) {

            return height;

        }
        return Math.max(dfsI(root.left, height+1),
                dfsI(root.right, height+1));
    }
}
