package com.witalis.praxis.leetcode.task.h7.p662.option;

import com.witalis.praxis.leetcode.task.h7.p662.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ID: 662
 * Name: Maximum Width of Binary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">Maximum Width of Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Integer process() {
        return widthOfBinaryTree(root);
    }

    record Node(TreeNode node, int index) {}

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;

        final Deque<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));

        while (!queue.isEmpty()) {
            final int offset = queue.peek().index() * 2;

            maxWidth = Math.max(maxWidth, queue.peekLast().index() - queue.peek().index() + 1);
            for (int size = queue.size(); size > 0; --size) {
                final Node current = queue.poll();
                if (current != null) {
                    final TreeNode node = current.node();
                    final int index = current.index();

                    if (node.left != null)
                        queue.offer(new Node(node.left, index * 2 - offset));
                    if (node.right != null)
                        queue.offer(new Node(node.right, index * 2 + 1 - offset));
                }
            }
        }

        return maxWidth;
    }
}
