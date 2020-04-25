package com.anmol.service;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 * Example 1:
 * Input:
 * A binary tree as following:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * v = 1
 *
 * d = 2
 *
 * Output:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 *
 * Example 2:
 * Input:
 * A binary tree as following:
 *       4
 *      /
 *     2
 *    / \
 *   3   1
 *
 * v = 1
 *
 * d = 3
 *
 * Output:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 */
public class AddOneToBinaryTree {

    /**
     * Do a simple BFS of the tree and count the level starting from root.
     * When you reach depth -1 level. remove elements from queue and create new nodes as left and right tree
     * and mark the original children as the children of the new nodes.
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode curr = new TreeNode(v);
            curr.left = root;
            return curr;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(level == d-1) {
                for(int i = 0;i<size;i++) {
                    TreeNode parentNode = queue.poll();
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    if(parentNode.left!=null) {
                        left.left = parentNode.left;
                    }
                    if(parentNode.right!=null) {
                        right.right = parentNode.right;
                    }
                    parentNode.left = left;
                    parentNode.right = right;

                }
            } else {
                for(int i = 0;i<size;i++) {
                    TreeNode temp = queue.poll();
                    if(temp.left!=null) {
                        queue.add(temp.left);
                    }
                    if(temp.right!=null) {
                        queue.add(temp.right);
                    }
                }
            }

            level++;
        }
        return root;

    }
}
