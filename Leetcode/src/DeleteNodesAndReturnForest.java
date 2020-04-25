package com.anmol.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 */
public class DeleteNodesAndReturnForest {

    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null || to_delete== null || to_delete.length == 0) return new ArrayList<>();

        Set<Integer> delete = new LinkedHashSet<>();
        for(int i : to_delete) {
            delete.add(i);
        }

        dfs(root, delete);
        if(!delete.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> delete) {
        if(root== null) return null;

        root.left = dfs(root.left, delete);
        root.right = dfs(root.right, delete);

        if(delete.contains(root.val)) {
            if(root.left!=null) {
                result.add(root.left);
            }
            if(root.right!=null) {
                result.add(root.right);
            }
            return null;
        }

        return root;

    }
}
