package com.witalis.praxis.leetcode.task.h1.p99.option;

import com.witalis.praxis.leetcode.task.h1.p99.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 99
 * Name: Recover Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/recover-binary-search-tree/">Recover Binary Search Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Solution(TreeNode root) {
        this.root = root;
    }

    public TreeNode process() {
        recoverTree(root);
        return root;
    }

    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        findSwap(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void findSwap(TreeNode root){
        if (root == null) return;

        findSwap(root.left);

        if (previous != null){
            if (first == null && previous.val > root.val) {
                first = previous;
            }
            if (first != null && previous.val > root.val) {
                second = root;
            }
        }
        previous = root;

        findSwap(root.right);
    }
}
