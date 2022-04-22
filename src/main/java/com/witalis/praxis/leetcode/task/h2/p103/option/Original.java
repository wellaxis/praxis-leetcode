package com.witalis.praxis.leetcode.task.h2.p103.option;

import com.witalis.praxis.leetcode.task.h2.p103.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 103
 * Name: Binary Tree Zigzag Level Order Traversal
 * URL: <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Binary Tree Zigzag Level Order Traversal</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public List<List<Integer>> process() {
        return zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> levels = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> order = new ArrayDeque<>();
        boolean direction = false;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            level.add(node.val);
            if (direction) {
                if (node.right != null) order.push(node.right);
                if (node.left != null) order.push(node.left);
            } else {
                if (node.left != null) order.push(node.left);
                if (node.right != null) order.push(node.right);
            }
            if (stack.isEmpty()) {
                levels.add(level);
                stack.addAll(order);
                level = new ArrayList<>();
                order = new ArrayDeque<>();
                direction = !direction;
            }
        }

        return levels;
    }
}
