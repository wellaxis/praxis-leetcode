package com.witalis.praxis.leetcode.task.h7.p662.option;

import com.witalis.praxis.leetcode.task.h7.p662.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 662
 * Name: Maximum Width of Binary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">Maximum Width of Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return widthOfBinaryTree(root);
    }

    static class Pair {
        TreeNode first;
        int second;

        public Pair(TreeNode first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int ans = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int n = queue.size();
            int min = queue.peek().second;
            int first = 0;
            int last = 0;
            for (int i = 0; i < n; i++) {
                Pair pair = queue.poll();
                int currentIndex = pair.second - min;
                TreeNode node = pair.first;
                if (i == 0) {
                    first = currentIndex;
                }
                if (i == n - 1) {
                    last = currentIndex;
                }
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * currentIndex + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * currentIndex + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
