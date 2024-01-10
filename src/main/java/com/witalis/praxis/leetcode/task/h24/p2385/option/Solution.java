package com.witalis.praxis.leetcode.task.h24.p2385.option;

import com.witalis.praxis.leetcode.task.h24.p2385.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2385
 * Name: Amount of Time for Binary Tree to Be Infected
 * URL: <a href="https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/">Amount of Time for Binary Tree to Be Infected</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private int start;

    public Solution(TreeNode root, int start) {
        this.root = root;
        this.start = start;
    }

    public Integer process() {
        return amountOfTime(root, start);
    }

    private int result;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return result;
    }

    private int dfs(TreeNode node, int start) {
        if (node == null) return 0;

        int leftDepth = dfs(node.left, start);
        int rightDepth = dfs(node.right, start);

        if (node.val == start) {
            result = Math.max(leftDepth, rightDepth);
            return -1;
        } else if (leftDepth >= 0 && rightDepth >= 0)
            return Math.max(leftDepth, rightDepth) + 1;

        result = Math.max(result, Math.abs(leftDepth - rightDepth));
        return Math.min(leftDepth, rightDepth) - 1;
    }
}
