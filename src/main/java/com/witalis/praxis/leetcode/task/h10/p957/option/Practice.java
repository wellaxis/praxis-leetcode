package com.witalis.praxis.leetcode.task.h10.p957.option;

import com.witalis.praxis.leetcode.task.h10.p957.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 957
 * Name: Check Completeness of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/check-completeness-of-a-binary-tree/">Check Completeness of a Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Boolean process() {
        return isCompleteTree(root);
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;

        final Queue<TreeNode> queue = new LinkedList<>(Collections.singleton(root));

        boolean finalize = false;
        while (!queue.isEmpty()) {
            root = queue.poll();

            // validate structure
            if (root.left == null && root.right != null) return false;

            // verify finalization
            if (finalize && root.left != null) return false;
            if (!finalize && root.right == null) finalize = true;

            // queue children
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }

        return true;
    }
}
