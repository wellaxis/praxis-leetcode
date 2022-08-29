package com.witalis.praxis.leetcode.task.h6.p559.option;

import com.witalis.praxis.leetcode.task.h6.p559.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 559
 * Name: Maximum Depth of N-ary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree/">Maximum Depth of N-ary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private Node root;

    public Integer process() {
        return maxDepth(root);
    }

    public int maxDepth(Node root) {
        return dfs(root);
    }

    private int dfs(Node root) {
        if (root == null) return 0;

        int maxHeight = 0;
        for (Node child : root.children) {
            maxHeight = Math.max(maxHeight, dfs(child));
        }

        return maxHeight + 1;
    }
}
