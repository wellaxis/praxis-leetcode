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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int start;

    public Original(TreeNode root, int start) {
        this.root = root;
        this.start = start;
    }

    public Integer process() {
        return amountOfTime(root, start);
    }

    private int traverseTime = 0;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return traverseTime;
    }

    private int dfs(TreeNode root, int start) {
        if (root == null) return 0;

        int left = dfs(root.left, start);
        int right = dfs(root.right, start);

        int depth;
        if (root.val == start) {
            traverseTime = Math.max(left, right);
            depth = -1;
        } else if (left >= 0 && right >= 0) {
            depth = Math.max(left, right) + 1;
        } else {
            int distance = Math.abs(left) + Math.abs(right);
            traverseTime = Math.max(traverseTime, distance);
            depth = Math.min(left, right) - 1;
        }

        return depth;
    }
}
