package com.witalis.praxis.leetcode.task.h10.p957.option;

import com.witalis.praxis.leetcode.task.h10.p957.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ID: 957
 * Name: Check Completeness of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/check-completeness-of-a-binary-tree/">Check Completeness of a Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Boolean process() {
        return isCompleteTree(root);
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;

        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        TreeNode node;
        boolean finalize = false;
        while (!queue.isEmpty()) {
            node = queue.poll();

            // validate
            if (finalize && (node.left != null || node.right != null)) return false;

            // continue
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                // incorrect
                if (node.left == null && node.right != null) return false;

                // last
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (!finalize) finalize = true;
            }
        }

        return true;
    }
}
