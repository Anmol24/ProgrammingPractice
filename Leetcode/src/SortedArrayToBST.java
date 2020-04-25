package com.anmol.service;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length ==0) return null;
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if(start<=end) {
            int mid = (start+end)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, start, mid-1);
            root.right = helper(nums, mid+1, end);
            return root;
        }
        return null;

    }
}
