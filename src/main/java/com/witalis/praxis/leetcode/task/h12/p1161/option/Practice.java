package com.witalis.praxis.leetcode.task.h12.p1161.option;

import com.witalis.praxis.leetcode.task.h12.p1161.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1161
 * Name: Maximum Level Sum of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/">Maximum Level Sum of a Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Practice(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return maxLevelSum(root);
    }

    public static final int MAX_LEN = 10_000;
    private int[] sums = new int[MAX_LEN];
    private int levels = 0;

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0);

        int minLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int level = 0; level <= levels; level++)
            if (sums[level] > maxSum) {
                minLevel = level;
                maxSum = sums[level];
            }

        return minLevel + 1;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > levels) levels = level;

        sums[level] += node.val;

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
