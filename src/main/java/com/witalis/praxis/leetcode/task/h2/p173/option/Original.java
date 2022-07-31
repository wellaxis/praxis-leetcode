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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private List<String> operations;

    public class BSTIterator implements IBSTIterator {
        public final List<Integer> values;
        public final Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            this.values = traverse(root);
            this.iterator = values.iterator();
        }

        @Override
        public int next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        private static List<Integer> traverse(TreeNode node) {
            if (node == null) return Collections.emptyList();

            List<Integer> values = new LinkedList<>();
            Deque<TreeNode> nodes = new ArrayDeque<>();

            while (node != null || !nodes.isEmpty()) {
                if (node != null) {
                    nodes.push(node);
                    node = node.left;
                } else {
                    TreeNode current = nodes.pop();
                    values.add(current.val);
                    node = current.right;
                }
            }

            return values;
        }
    }

    public List<String> process() {
        return BSTIteratorHandler.process(operations, new BSTIterator(root));
    }
}
