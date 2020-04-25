package com.anmol.service;

import java.util.HashMap;

public class HouseRobberIII {

    int sum = 0;
    public int rob(TreeNode root) {
        return rob(root, new HashMap<TreeNode, Integer>());
    }

    private int rob(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;

        if(map.containsKey(root)) {
            return map.get(root);
        }
        int leftSum = 0;
        if(root.left!=null) {
            leftSum = rob(root.left.left, map) + rob(root.left.right, map);
        }
        int rightSum = 0;
        if(root.right!=null) {
            rightSum = rob(root.right.left, map) + rob(root.right.right, map);
        }

        int max = root.val + leftSum + rightSum;
        max = Math.max(max, rob(root.left, map) + rob(root.right, map));

        map.put(root, max);
        return max;

    }

    /**
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        houseRobberIII.rob(root);
    }
}
