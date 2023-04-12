package com.witalis.praxis.leetcode.task.h10.p965.option;

import com.witalis.praxis.leetcode.task.h10.p965.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ID: 965
 * Name: Univalued Binary Tree
 * URL: <a href="https://leetcode.com/problems/univalued-binary-tree/">Univalued Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Boolean process() {
        return isUnivalTree(root);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;

        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        final int value = root.val;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.val != value) return false;

            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offer(root.right);
        }

        return true;
    }
}
