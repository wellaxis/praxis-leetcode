package com.witalis.praxis.leetcode.task.h2.p112.option;

import com.witalis.praxis.leetcode.task.h2.p112.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 112
 * Name: Path Sum
 * URL: https://leetcode.com/problems/path-sum/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int sum;

    public Boolean process() {
        return hasPathSum(root, sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        targetSum -= root.val;
        if (root.left == null && root.right == null) return targetSum == 0;

        if (hasPathSum(root.left, targetSum)) return true;
        return hasPathSum(root.right, targetSum);
    }
}
