package com.anmol.service;

public class RangeSumBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    private void dfs(TreeNode root, int l, int r) {
        if(root == null) return;
        dfs(root.left, l, r);
        if(root.val>=l && root.val<=r) {
            sum+=root.val;
        }
        dfs(root.right, l , r);
    }

    public static void main(String[] args) {
        RangeSumBST rangeSumBST = new RangeSumBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST.rangeSumBST(root, 7,15));
    }
}
