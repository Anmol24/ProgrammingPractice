package com.anmol.service;

import java.util.*;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 *
 *
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 */
public class AllNodesAtKDistance {

    /**
     * First do a bsf to mark all the parents of a node. Now start from the target node and do a bfs and add
     * all the elements at a current level to the queue. do teh same thing until u reach at level K from target
     * all the nodes at level k will be the solution.
     */
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new LinkedHashSet<>();
        visited.add(target);
        while(K > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size;i++) {
                TreeNode curr = queue.poll();
                if(curr.left!=null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.add(curr.right);
                }
                if(parent.get(curr)!=null && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    queue.add(parent.get(curr));
                }
            }
            K--;
        }
        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;

    }


    private void dfs(TreeNode root, TreeNode parentNode) {
        if(root!=null) {
            parent.put(root, parentNode);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
