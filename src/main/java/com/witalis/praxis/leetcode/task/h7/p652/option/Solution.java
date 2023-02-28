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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<TreeNode> process() {
        return findDuplicateSubtrees(root);
    }

    private final Map<MyTreeNode, Integer> countMap = new HashMap<>();
    private final List<TreeNode> duplicates = new LinkedList<>();

    private class MyTreeNode {
        private int hash;
        private int val;
        private MyTreeNode left;
        private MyTreeNode right;

        public MyTreeNode(int h, int v, MyTreeNode l, MyTreeNode r) {
            this.hash = h;
            this.val = v;
            this.left = l;
            this.right = r;
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            MyTreeNode node = (MyTreeNode) o;
            return this.hash == node.hash && this.val == node.val && equals(node.left, this.left) && equals(node.right, this.right);
        }

        private boolean equals(MyTreeNode a, MyTreeNode b) {
            if (a == null && b == null) {
                return true;
            }

            if (a == null || b == null) {
                return false;
            }

            return a.equals(b);
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return duplicates;
    }

    private MyTreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        MyTreeNode left = dfs(node.left);
        MyTreeNode right = dfs(node.right);

        int prime = 31;
        int hash = 1;
        hash = hash * prime + node.val;
        if (left != null) {
            hash = hash * prime + left.hash;
        }

        if (right != null) {
            hash = hash * prime + right.hash;
        }

        MyTreeNode myNode = new MyTreeNode(hash, node.val, left, right);
        int count = countMap.getOrDefault(myNode, 0) + 1;
        countMap.put(myNode, count);
        if (count == 2) {
            duplicates.add(node);
        }

        return myNode;
    }
}
