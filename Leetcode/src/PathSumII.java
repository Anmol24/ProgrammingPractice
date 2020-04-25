package com.anmol.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PathSumII {


    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();

        helper(root, 0, sum, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int currSum, int sum, ArrayList<Integer> list) {
        if(root!=null) {
            currSum += root.val;
            list.add(root.val);
            if(root.left == null && root.right == null) {
                if(currSum== sum) {
                    result.add(new ArrayList<>(list));
                }
            }
            helper(root.left, currSum, sum, list);
            helper(root.right, currSum, sum, list);
            list.remove(list.size()-1);
        }
    }


    /*public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, st, sum, result);
        return result;
    }

    private void helper(TreeNode root, int curr, Stack<Integer> st, int sum, List<List<Integer>> result) {
        if(root == null) return;

        curr += root.val;
        st.push(root.val);
        if(root.left == null && root.right == null && curr == sum) {
            printStack(st, result);
        }
        helper(root.left, curr, st, sum, result);
        helper(root.right, curr, st, sum, result);
        st.pop();


    }

    private void printStack(Stack<Integer> st, List<List<Integer>> result) {
        List<Integer> temp = new ArrayList();
        for(int i : st) {
            temp.add(i);
        }
        result.add(temp);
    }*/

    /**
     *
     /**
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \    / \
     * 7    2  5   1
     *
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSumII pathSumII = new PathSumII();
        pathSumII.pathSum(root, 22);

    }
}
