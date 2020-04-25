package com.anmol.service;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateTreeFromInandPreorder {

    int curr = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        if (inorder == null || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndex(preorder[0], inorder);
        int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
        int[] preorder1 = Arrays.copyOfRange(preorder, 1, inorder1.length+1);
        root.left = buildTree(preorder1, inorder1);
        int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] preorder2 = Arrays.copyOfRange(preorder, 1+preorder1.length, preorder.length);
        root.right = buildTree(preorder2, inorder2);
        return root;

    }

    public int findIndex(int val, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,3,4,5,6,7};
        int[] inorder = new int[]{3,2,4,1,6,5,7};
        CreateTreeFromInandPreorder inandPreorder = new CreateTreeFromInandPreorder();
        inandPreorder.buildTree(preorder, inorder);
    }
}
