package com.witalis.praxis.leetcode.task.h7.p662.option;

import com.witalis.praxis.leetcode.task.h7.p662.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 662
 * Name: Maximum Width of Binary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">Maximum Width of Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return widthOfBinaryTree(root);
    }

    record Node(TreeNode node, int index) {}

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(root, 1));

        while (!deque.isEmpty()) {
            int offset = deque.peekFirst().index() * 2;

            maxWidth = Math.max(maxWidth, deque.peekLast().index() - deque.peekFirst().index() + 1);
            for (int size = deque.size(); size > 0; --size) {
                Node current = deque.pollFirst();
                if (current != null) {
                    TreeNode node = current.node();
                    int index = current.index();

                    if (node.left != null) {
                        deque.offer(new Node(node.left, index * 2 - offset));
                    }
                    if (node.right != null) {
                        deque.offer(new Node(node.right, index * 2 + 1 - offset));
                    }
                }
            }
        }

        return maxWidth;
    }
}
