package com.witalis.praxis.leetcode.task.h23.p2265.option;

import com.witalis.praxis.leetcode.task.h23.p2265.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2265
 * Name: Count Nodes Equal to Average of Subtree
 * URL: <a href="https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/">Count Nodes Equal to Average of Subtree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Solution(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return averageOfSubtree(root);
    }

    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);

        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int countSum = left[0] + right[0] + root.val;
        int currCount = left[1] + right[1] + 1;

        if (root.val == (countSum / currCount)) {
            res++;
        }

        return new int[]{countSum, currCount};
    }
}
