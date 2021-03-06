package com.witalis.praxis.leetcode.task.h14.p1379.option;

import com.witalis.praxis.leetcode.task.h14.p1379.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1379
 * Name: Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * URL: <a href="https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/">Find a Corresponding Node of a Binary Tree in a Clone of That Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode originalTree;
    private TreeNode clonedTree;
    private TreeNode targetNode;

    public TreeNode process() {
        return getTargetCopy(originalTree, clonedTree, targetNode);
    }

    private TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original != null) {
            if (original == target) return cloned;
            TreeNode n = getTargetCopy(original.left, cloned.left, target);
            if (n == null) {
                n = getTargetCopy(original.right, cloned.right, target);
            }
            if (n != null) {
                return n;
            }
        }
        return null;
    }
}
