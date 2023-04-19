package com.witalis.praxis.leetcode.task.h14.p1372.option;

import com.witalis.praxis.leetcode.task.h14.p1372.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1372
 * Name: Longest ZigZag Path in a Binary Tree
 * URL: <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/">Longest ZigZag Path in a Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Original(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return longestZigZag(root);
    }

    private int longestPath = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0, true);
        dfs(root, 0, false);

        return longestPath;
    }

    private void dfs(TreeNode node, int path, boolean toLeft) {
        if (node == null) {
            longestPath = Math.max(longestPath, path - 1);
        } else {
            dfs(toLeft ? node.left : node.right, path + 1, !toLeft);
            dfs(toLeft ? node.right : node.left, 1, toLeft);
        }
    }
}
