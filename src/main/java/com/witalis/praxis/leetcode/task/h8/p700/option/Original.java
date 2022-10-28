package com.witalis.praxis.leetcode.task.h8.p700.option;

import com.witalis.praxis.leetcode.task.h8.p700.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 700
 * Name: Search in a Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/">Search in a Binary Search Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int value;

    public TreeNode process() {
        return searchBST(root, value);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        return (root.val > val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
