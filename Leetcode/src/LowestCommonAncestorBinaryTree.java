package com.anmol.service;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new LinkedList<>();
        List<TreeNode> path2 = new LinkedList<>();
        findPath(root, p, path1);
        findPath(root, q, path2);


        int min = Math.min(path1.size(), path2.size());
        TreeNode result=path1.get(0);
        for(int i = 1;i<min;i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
            result = path1.get(i);
        }
        return result;
    }

    public boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if(root == null) {
            return false;
        }

        path.add(root);
        if(root == p) {
            return true;
        }
        if(root.left!=null && findPath(root.left, p, path)){
            return true;
        }
        if(root.right!=null && findPath(root.right, p, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    private void printPath(List<TreeNode> path) {
        for(TreeNode node: path) {
            System.out.print(node.val + " ") ;
        }
    }


    public TreeNode lowestCommonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        if(root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left!=null && left !=p && left!=q) return left; // if we already found a node which is not same as the nodes then this is the lowest common ancestor

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null && right!=null) {
            return root;
        }

        return left!=null? left :right;

    }

}
