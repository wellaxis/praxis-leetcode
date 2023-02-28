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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public List<TreeNode> process() {
        return findDuplicateSubtrees(root);
    }

    record HashNode(int hash, int val, HashNode left, HashNode right) {

        public HashNode(int val, HashNode left, HashNode right) {
            this(initHash(val, left, right), val, left, right);
        }

        public static int initHash(int value, HashNode left, HashNode right) {
            final int prime = 31;

            int hash = 1;

            hash = hash * prime + Objects.hash(value);
            if (left != null) {
                hash = hash * prime + left.hash;
            }
            if (right != null) {
                hash = hash * prime + right.hash;
            }

            return hash;
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            HashNode node = (HashNode) obj;

            return this.hash == node.hash && this.val == node.val && equals(node.left, this.left) && equals(node.right, this.right);
        }

        private boolean equals(HashNode the1st, HashNode the2nd) {
            if (the1st == null && the2nd == null) return true;
            if (the1st == null || the2nd == null) return false;

            return the1st.equals(the2nd);
        }

        @Override
        public String toString() {
            return "Node [hash = " + hashCode() + ", value = " + val() + "]";
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return Collections.emptyList();

        final List<TreeNode> duplicates = new LinkedList<>();
        final Map<HashNode, Long> cache = new HashMap<>();

        dfs(duplicates, cache, root);

        return duplicates;
    }

    private HashNode dfs(List<TreeNode> duplicates, Map<HashNode, Long> cache, TreeNode node) {
        if (node == null) return null;

        HashNode leftNode = dfs(duplicates, cache, node.left);
        HashNode rightNode = dfs(duplicates, cache, node.right);

        HashNode hashNode = new HashNode(node.val, leftNode, rightNode);

        long count = cache.getOrDefault(hashNode, 0L) + 1;
        cache.put(hashNode, count);

        if (count == 2) duplicates.add(node);

        return hashNode;
    }
}
