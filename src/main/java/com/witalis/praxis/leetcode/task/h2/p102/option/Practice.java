package com.witalis.praxis.leetcode.task.h2.p102.option;

import com.witalis.praxis.leetcode.task.h2.p102.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 102
 * Name: Binary Tree Level Order Traversal
 * URL: <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public List<List<Integer>> process() {
        return levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> level;
        Queue<TreeNode> order;
        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            order = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) order.offer(node.left);
                if (node.right != null) order.offer(node.right);
            }
            levels.add(level);
            queue = order;
        }

        return levels;
    }
}
