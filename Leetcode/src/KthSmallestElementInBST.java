package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    List<Integer> arr = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k == 0) return 0;
        inorder(root, k);
        return arr.get(k-1);

    }

    public void inorder(TreeNode root,int k) {
        if(root!=null) {
            inorder(root.left, k);
            arr.add(root.val);
            if(arr.size()==k) {
                return;
            }
            inorder(root.right, k);
        }
    }
}
