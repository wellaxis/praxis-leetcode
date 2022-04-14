package com.witalis.praxis.leetcode.task.h2.p100.option;

import com.witalis.praxis.leetcode.task.h2.p100.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 100
 * Name: Same Tree
 * URL: <a href="https://leetcode.com/problems/same-tree/">Same Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode p;
    private TreeNode q;

    public Boolean process() {
        return isSameTree(p, q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursiveIsSame(p, q);
    }

    private boolean recursiveIsSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p != null && q != null && p.val == q.val) {
            return recursiveIsSame(p.left, q.left)
                && recursiveIsSame(p.right, q.right);
        } else {
            return false;
        }
    }
}
