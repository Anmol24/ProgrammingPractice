package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        writePaths(root, res, "");
        return res;
    }
    public void writePaths(TreeNode root, List<String> res, String curr){
        if(root == null) return;
        curr += root.val;
        writePaths(root.left, res, curr+"->");
        writePaths(root.right, res, curr+"->");
        if(root.left == null && root.right == null) res.add(curr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreePaths treePaths = new BinaryTreePaths();
        treePaths.binaryTreePaths(root);
    }
}
