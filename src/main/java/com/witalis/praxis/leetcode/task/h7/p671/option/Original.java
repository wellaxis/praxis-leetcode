package com.witalis.praxis.leetcode.task.h7.p671.option;

import com.witalis.praxis.leetcode.task.h7.p671.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ID: 671
 * Name: Second Minimum Node In a Binary Tree
 * URL: <a href="https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/">Second Minimum Node In a Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return findSecondMinimumValue(root);
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        int secondMinimum = -1;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (root.val < node.val && (secondMinimum < 0 || node.val < secondMinimum)) secondMinimum = node.val;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return secondMinimum;
    }
}
