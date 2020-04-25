package com.anmol.service;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 */
public class DeepestLeavesSum {
    Map<Integer, Integer> map = new HashMap<>();
    int maxLevel = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return map.get(maxLevel);
    }

    public void dfs(TreeNode root, int level) {
        if(root == null) return;
        if(root.left ==null && root.right == null) {
            maxLevel = Math.max(level, maxLevel);
            map.put(level, map.getOrDefault(level, 0) + root.val);
            return;
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }
}
