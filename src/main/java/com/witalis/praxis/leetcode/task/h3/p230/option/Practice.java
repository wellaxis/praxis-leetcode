package com.witalis.praxis.leetcode.task.h3.p230.option;

import com.witalis.praxis.leetcode.task.h3.p230.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 230
 * Name: Kth Smallest Element in a BST
 * URL: <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private int index;

    public Integer process() {
        return kthSmallest(root, index);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }

        return -1;
    }
}
