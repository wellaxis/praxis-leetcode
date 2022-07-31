package com.witalis.praxis.leetcode.task.h2.p173.option;

import com.witalis.praxis.leetcode.task.h2.p173.content.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * ID: 173
 * Name: Binary Search Tree Iterator
 * URL: <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private List<String> operations;

    public class BSTIterator implements IBSTIterator {
        private final Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushLeftsUntilNull(root);
        }

        @Override
        public int next() {
            TreeNode node = stack.pop();
            pushLeftsUntilNull(node.right);
            return node.val;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeftsUntilNull(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public List<String> process() {
        return BSTIteratorHandler.process(operations, new BSTIterator(root));
    }
}
