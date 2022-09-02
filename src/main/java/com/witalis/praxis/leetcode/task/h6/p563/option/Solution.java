package com.witalis.praxis.leetcode.task.h6.p563.option;

import com.witalis.praxis.leetcode.task.h6.p563.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 563
 * Name: Binary Tree Tilt
 * URL: <a href="https://leetcode.com/problems/binary-tree-tilt/">Binary Tree Tilt</a>
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
        return findTilt(root);
    }

    private int tilt = 0;

    public int findTilt(TreeNode root) {
        postorder(root);

        return tilt;
    }

    public int postorder(TreeNode root) {
        if (root == null) return 0;

        int leftSum = postorder(root.left);
        int rightSum = postorder(root.right);
        tilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val;
    }
}
