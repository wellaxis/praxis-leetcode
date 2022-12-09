package com.witalis.praxis.leetcode.task.h11.p1026.option;

import com.witalis.praxis.leetcode.task.h11.p1026.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1026
 * Name: Maximum Difference Between Node and Ancestor
 * URL: <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/">Maximum Difference Between Node and Ancestor</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return maxAncestorDiff(root);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return curMax - curMin;
        }

        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);

        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);

        return Math.max(left, right);
    }
}
