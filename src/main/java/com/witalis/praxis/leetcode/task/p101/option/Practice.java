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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Boolean process() {
        return isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        return recursiveIsSymmetric(root, root);
    }

    private boolean recursiveIsSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 != null && n2 != null && n1.val == n2.val) {
            return recursiveIsSymmetric(n1.left, n2.right)
                && recursiveIsSymmetric(n1.right, n2.left);
        } else {
            return false;
        }
    }
}
