package com.witalis.praxis.leetcode.task.h1.p98.option;

import com.witalis.praxis.leetcode.task.h1.p98.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 98
 * Name: Validate Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Practice(TreeNode root) {
        this.root = root;
    }

    public Boolean process() {
        return isValidBST(root);
    }

    private TreeNode previous;

    public boolean isValidBST(TreeNode root) {
        return recursiveIsValidBST(root);
    }

    private boolean recursiveIsValidBST(TreeNode current) {
        if (current == null) return true;

        if (!recursiveIsValidBST(current.left)) return false;

        if (previous != null && previous.val >= current.val) return false;

        previous = current;

        return recursiveIsValidBST(current.right);
    }
}
