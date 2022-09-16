package com.witalis.praxis.leetcode.task.h3.p230.option;

import com.witalis.praxis.leetcode.task.h3.p230.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * ID: 230
 * Name: Kth Smallest Element in a BST
 * URL: <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private int index;

    public Integer process() {
        return kthSmallest(root, index);
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
