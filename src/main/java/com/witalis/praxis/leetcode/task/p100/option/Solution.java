package com.witalis.praxis.leetcode.task.p100.option;

import com.witalis.praxis.leetcode.task.p100.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 100
 * Name: Same Tree
 * URL: https://leetcode.com/problems/same-tree/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode p;
    private TreeNode q;

    public Boolean process() {
        return isSameTree(p, q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
            isSameTree(p.left, q.left);
    }
}
