package com.witalis.praxis.leetcode.task.h2.p173.option;

import com.witalis.praxis.leetcode.task.h2.p173.content.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 173
 * Name: Binary Search Tree Iterator
 * URL: <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private List<String> operations;

    public class BSTIterator implements IBSTIterator {
        private final Deque<TreeNode> nodes;
        public TreeNode next;

        public BSTIterator(TreeNode root) {
            this.nodes = new ArrayDeque<>();
            this.next = root;
            iterate();
        }

        @Override
        public int next() {
            int value = -1;
            if (next != null) {
                value = next.val;
                next = next.right;
                iterate();
            }
            return value;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        private void iterate() {
            TreeNode node = next;
            while (node != null || !nodes.isEmpty()) {
                if (node != null) {
                    nodes.push(node);
                    node = node.left;
                } else {
                    next = nodes.pop();
                    break;
                }
            }
        }
    }

    public List<String> process() {
        return BSTIteratorHandler.process(operations, new BSTIterator(root));
    }
}
