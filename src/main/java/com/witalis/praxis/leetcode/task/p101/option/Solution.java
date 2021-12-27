package com.witalis.praxis.leetcode.task.p101.option;

import com.witalis.praxis.leetcode.task.p101.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 101
 * Name: Symmetric Tree
 * URL: https://leetcode.com/problems/symmetric-tree/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Boolean process() {
        return isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isMirror(p.right, q.left)
            && isMirror(p.left, q.right);
    }
}
