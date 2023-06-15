package com.witalis.praxis.leetcode.task.h12.p1161.option;

import com.witalis.praxis.leetcode.task.h12.p1161.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 1161
 * Name: Maximum Level Sum of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/">Maximum Level Sum of a Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return maxLevelSum(root);
    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int ans = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int sumAtCurrentLevel = 0;

            // iterate over all the nodes in the current level
            for (int sz = queue.size(); sz > 0; --sz) {
                TreeNode node = queue.poll();
                sumAtCurrentLevel += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (maxSum < sumAtCurrentLevel) {
                maxSum = sumAtCurrentLevel;
                ans = level;
            }
        }

        return ans;
    }
}
