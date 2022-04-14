package com.witalis.praxis.leetcode.task.h14.p1379.option;

import com.witalis.praxis.leetcode.task.h14.p1379.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 1379
 * Name: Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * URL: <a href="https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/">Find a Corresponding Node of a Binary Tree in a Clone of That Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode original;
    private TreeNode cloned;
    private TreeNode target;

    public TreeNode process() {
        return getTargetCopy(original, cloned, target);
    }

    private TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> queueOriginal = new ArrayDeque<>();
        queueOriginal.offer(original);

        Deque<TreeNode> queueCloned = new ArrayDeque<>();
        queueCloned.offer(cloned);

        while (!queueOriginal.isEmpty()) {
            TreeNode nodeOriginal = queueOriginal.poll();
            TreeNode nodeCloned = queueCloned.poll();

            if (nodeOriginal == target) {
                return nodeCloned;
            }

            if (nodeOriginal.left != null) {
                queueOriginal.offer(nodeOriginal.left);
                queueCloned.offer(nodeCloned.left);
            }
            if (nodeOriginal.right != null) {
                queueOriginal.offer(nodeOriginal.right);
                queueCloned.offer(nodeCloned.right);
            }
        }
        return null;
    }
}
