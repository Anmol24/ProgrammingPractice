package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRootToLEafNumbers {
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return 0;
        dfs(root, result, new ArrayList<>());
        int res = 0;

        for(List<Integer> list : result) {
            int temp = 0;
            for(int val : list) {
                System.out.print(val +" ");
                temp = temp*10+val;
            }
            System.out.println();

            res+=temp;
        }
        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> result, ArrayList<Integer> temp) {
        if(root.left == null && root.right == null) {
            temp.add(root.val);
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(root.val);
        if(root.left!=null) {
            dfs(root.left, result, temp);
            temp.remove(temp.size()-1);
        }
        if(root.right!=null) {
            dfs(root.right, result, temp);
            temp.remove(temp.size()-1);
        }


    }
    public static void main(String[] args) {
        SumRootToLEafNumbers lEafNumbers = new SumRootToLEafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        lEafNumbers.sumNumbers(root);
    }
}
