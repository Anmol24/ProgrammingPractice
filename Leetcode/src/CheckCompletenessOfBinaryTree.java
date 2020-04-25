package com.anmol.service;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 *
 *
 *
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 * Note:
 *
 * The tree will have between 1 and 100 nodes.
 */
public class CheckCompletenessOfBinaryTree {

    /**
     * do a bfs of the tree and if you find a null leaf then mark it as found and after this point there shouldn't not be any non
     * null node.
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftNullFound = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                TreeNode curr = queue.poll();
                TreeNode left = curr.left;
                if(left!=null) {
                    if(leftNullFound) {
                        return false;
                    }
                    queue.add(left);
                } else {
                    leftNullFound = true;
                }
                TreeNode right = curr.right;
                if(right!=null) {
                    if(leftNullFound) {
                        return false;
                    }
                    queue.add(right);
                } else {
                    leftNullFound = true;
                }
            }

        }
        return true;
    }

}
