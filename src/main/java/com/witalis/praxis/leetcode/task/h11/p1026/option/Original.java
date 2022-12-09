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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return maxAncestorDiff(root);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, root.val, root.val);
    }

    private static int dfs(TreeNode node, int min, int max) {
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        if (node.left == null && node.right == null) {
            return Math.abs(max - min);
        }

        int leftDiff = node.left == null ? 0 : dfs(node.left, min, max);
        int rightDiff = node.right == null ? 0 : dfs(node.right, min, max);

        return Math.max(leftDiff, rightDiff);
    }
}
