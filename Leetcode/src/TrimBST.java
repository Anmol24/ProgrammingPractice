package com.anmol.service;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;

    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(0);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(1);
        TrimBST trimBST = new TrimBST();
        trimBST.trimBST(node, 1, 3);
    }

}
