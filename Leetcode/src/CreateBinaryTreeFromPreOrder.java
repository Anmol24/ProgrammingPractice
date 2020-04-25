package com.anmol.service;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Note:
 *
 * 1 <= preorder.length <= 100
 */
public class CreateBinaryTreeFromPreOrder {

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        if(preorder.length ==1) return new TreeNode(preorder[0]);
        //Use atomic integer as integer is passed by value in java and we need passed by reference.
        return bstHelper(preorder, new AtomicInteger(0), Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private TreeNode bstHelper(int[] preorder, AtomicInteger index, int minValue, int maxValue) {
        if(index.get() >= preorder.length) {
            return null;
        }
        int rootVal = preorder[index.get()];
        TreeNode root = null;
        if(rootVal > minValue && rootVal<maxValue) {
            index.incrementAndGet();
            root = new TreeNode(rootVal);
            root.left = bstHelper(preorder, index, minValue, root.val);
            root.right = bstHelper(preorder, index, root.val, maxValue);
        }
        return root;
    }

    public TreeNode bstFromPreorderI(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        if(preorder.length ==1) return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int rightIndex = rightTreeIndex(preorder, preorder[0], 1, preorder.length);
        if(rightIndex != -1) {
            root.left = bstFromPreorderI(Arrays.copyOfRange(preorder, 1, rightIndex));
            root.right = bstFromPreorderI(Arrays.copyOfRange(preorder, rightIndex, preorder.length));
        } else {
            root.left = bstFromPreorderI(Arrays.copyOfRange(preorder, 1, preorder.length));
        }
        return root;
    }

    private int rightTreeIndex(int[] preorder, int root, int start, int end) {
        for(int i = start;i<end;i++) {
            if(preorder[i]>root) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromPreOrder preOrder = new CreateBinaryTreeFromPreOrder();
        TreeNode treeNode = preOrder.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});

    }

}
