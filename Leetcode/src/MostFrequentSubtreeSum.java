package com.anmol.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {
    Map<Integer, Integer> subTree = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int max = 0;
        for(int value : subTree.values()) {
            max = Math.max(max, value);
        }
        List<Integer> result = new ArrayList<>();
        for(int key : subTree.keySet()) {
            if(subTree.get(key) == max) {
                result.add(key);
            }
        }
        int[] arr = new int[result.size()];
        for(int i = 0; i< result.size();i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    /**
     * Do a POST order traversal of the tree and recursively find the left and right subtree sum and add to the current
     * root node to get the sum of the tree rooted at a node.
     * node.val + leftSubtreeSum + rightSubTreeSum
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int subTreeSum = root.val + leftSum+rightSum;
        subTree.put(subTreeSum, subTree.getOrDefault(subTreeSum, 0) +1);
        return subTreeSum;
    }

    public static void main(String[] args) {
        MostFrequentSubtreeSum subtreeSum = new MostFrequentSubtreeSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-3);
        root.right = new TreeNode(2);
        subtreeSum.findFrequentTreeSum(root);
    }
}
