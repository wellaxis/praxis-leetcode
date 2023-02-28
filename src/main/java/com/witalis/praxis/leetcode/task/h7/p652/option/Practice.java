package com.witalis.praxis.leetcode.task.h7.p652.option;

import com.witalis.praxis.leetcode.task.h7.p652.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 652
 * Name: Find Duplicate Subtrees
 * URL: <a href="https://leetcode.com/problems/find-duplicate-subtrees/">Find Duplicate Subtrees</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public List<TreeNode> process() {
        return findDuplicateSubtrees(root);
    }

    private final List<TreeNode> duplicates = new LinkedList<>();
    private final Map<HashNode, Long> cache = new HashMap<>();

    record HashNode(int hash, int val, HashNode left, HashNode right) {

        public HashNode(int val, HashNode left, HashNode right) {
            this(initHash(val, left, right), val, left, right);
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            final HashNode node = (HashNode) obj;

            return this.hash == node.hash && this.val == node.val && equals(node.left, this.left) && equals(node.right, this.right);
        }

        @Override
        public String toString() {
            return "Node [hash = " + hashCode() + ", value = " + val() + "]";
        }

        private static int initHash(int value, HashNode left, HashNode right) {
            final int prime = 11;

            int hash = 7;

            hash = hash * prime + Objects.hash(value);
            if (left != null) {
                hash = hash * prime + left.hash;
            }
            if (right != null) {
                hash = hash * prime + right.hash;
            }

            return hash;
        }

        private static boolean equals(HashNode the1st, HashNode the2nd) {
            if (the1st == null && the2nd == null) return true;
            if (the1st == null || the2nd == null) return false;

            return the1st.equals(the2nd);
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return Collections.emptyList();

        dfs(root);

        return duplicates;
    }

    private HashNode dfs(TreeNode node) {
        if (node == null) return null;

        final HashNode hashNode = new HashNode(node.val, dfs(node.left), dfs(node.right));

        cache.put(hashNode, cache.getOrDefault(hashNode, 0L) + 1);
        if (cache.get(hashNode) == 2) duplicates.add(node);

        return hashNode;
    }
}
