package com.witalis.praxis.leetcode.task.h9.p863.option;

import com.witalis.praxis.leetcode.task.h9.p863.content.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 863
 * Name: All Nodes Distance K in Binary Tree
 * URL: <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/">All Nodes Distance K in Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private TreeNode target;
    private int distance;

    public List<Integer> process() {
        return distanceK(root, target, distance);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        // distances to target
        Map<TreeNode, Integer> nodeToDist = new HashMap<>();

        getDistances(root, target, nodeToDist);
        dfs(root, k, 0, nodeToDist, ans);

        return ans;
    }

    private void getDistances(TreeNode root, TreeNode target, Map<TreeNode, Integer> nodeToDist) {
        if (root == null)
            return;
        if (root == target) {
            nodeToDist.put(root, 0);
            return;
        }

        getDistances(root.left, target, nodeToDist);
        if (nodeToDist.containsKey(root.left)) {
            // the target is in the left subtree
            nodeToDist.put(root, nodeToDist.get(root.left) + 1);
            return;
        }

        getDistances(root.right, target, nodeToDist);
        if (nodeToDist.containsKey(root.right))
            // the target is in the right subtree
            nodeToDist.put(root, nodeToDist.get(root.right) + 1);
    }

    private void dfs(TreeNode root, int k, int dist, Map<TreeNode, Integer> nodeToDist, List<Integer> ans) {
        if (root == null)
            return;
        if (nodeToDist.containsKey(root))
            dist = nodeToDist.get(root);
        if (dist == k)
            ans.add(root.val);

        dfs(root.left, k, dist + 1, nodeToDist, ans);
        dfs(root.right, k, dist + 1, nodeToDist, ans);
    }
}
