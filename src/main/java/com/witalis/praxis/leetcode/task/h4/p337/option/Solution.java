package com.witalis.praxis.leetcode.task.h4.p337.option;

import com.witalis.praxis.leetcode.task.h4.p337.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 337
 * Name: House Robber III
 * URL: <a href="https://leetcode.com/problems/house-robber-iii/">House Robber III</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return rob(root);
    }

    public int rob(TreeNode root) {
        int[] result = robSubTree(root);

        return Math.max(result[0], result[1]);
    }

    public int[] robSubTree(TreeNode root) {
        if (root == null) return new int[] {0, 0};

        int[] robLeft = robSubTree(root.left);
        int[] robRight = robSubTree(root.right);

        int robThisNode = root.val + robLeft[1] + robRight[1];
        int notRobThisNode = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);

        return new int[] {robThisNode, notRobThisNode};
    }
}
