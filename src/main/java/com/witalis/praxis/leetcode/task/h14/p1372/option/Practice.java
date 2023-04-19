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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Integer process() {
        return longestZigZag(root);
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        return Math.max(dfs(root, 0, true), dfs(root, 0, false));
    }

    private int dfs(TreeNode node, int path, boolean toLeft) {
        if (node == null) {
            return path - 1;
        } else {
            int keep = dfs(toLeft ? node.left : node.right, path + 1, !toLeft);
            int anew = dfs(toLeft ? node.right : node.left, 1, toLeft);

            return Math.max(keep, anew);
        }
    }
}
