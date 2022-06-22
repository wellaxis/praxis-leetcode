package com.witalis.praxis.leetcode.task.h5.p404.option;

import com.witalis.praxis.leetcode.task.h5.p404.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 404
 * Name: Sum of Left Leaves
 * URL: <a href="https://leetcode.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return sumOfLeftLeaves(root);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + dfs(root.right);
        }

        return dfs(root.left) + dfs(root.right);
    }
}
