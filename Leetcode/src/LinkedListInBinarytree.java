package com.anmol.service;

/**
 * Given a binary tree root and a linked list with head as the first node.
 *
 * Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
 *
 * In this context downward path means a path that starts at some node and goes downwards.
 *
 *
 *
 * Example 1:
 *  https://leetcode.com/problems/linked-list-in-binary-tree/
 *
 *
 * Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * Output: true
 * Explanation: Nodes in blue form a subpath in the binary Tree.
 */
public class LinkedListInBinarytree {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        if(root == null)
            return false;

        if(isIdentical(head,root)){
            return true;
        }


        return isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    private boolean isIdentical(ListNode head, TreeNode root){
        if(head == null)
            return true;

        if(root == null || root.val != head.val)
            return false;

        return isIdentical(head.next, root.left) || isIdentical(head.next, root.right);
    }
}
