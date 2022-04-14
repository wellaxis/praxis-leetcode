package com.witalis.praxis.leetcode.task.h2.p112.option;

import com.witalis.praxis.leetcode.task.h2.p112.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 112
 * Name: Path Sum
 * URL: <a href="https://leetcode.com/problems/path-sum/">Path Sum</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private int sum;

    public Boolean process() {
        return hasPathSum(root, sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null)
            return targetSum == root.val;

        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }
}
