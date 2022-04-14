package com.witalis.praxis.leetcode.task.h3.p257.option;

import com.witalis.praxis.leetcode.task.h3.p257.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 257
 * Name: Binary Tree Paths
 * URL: <a href="https://leetcode.com/problems/binary-tree-paths/">Binary Tree Paths</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public List<String> process() {
        return binaryTreePaths(root);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<String> paths = new ArrayList<>();
        Deque<Object[]> stack = new ArrayDeque<>();

        StringBuilder path = new StringBuilder();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                Object[] data = stack.pop();
                root = (TreeNode) data[0];
                path = (StringBuilder) data[1];
            }

            path.append(root.val);

            if (root.left == null && root.right == null) {
                paths.add(path.toString());
                root = null;
            } else {
                path.append("->");
                if (root.right != null) {
                    stack.push(new Object[] {root.right, new StringBuilder(path)});
                }
                root = root.left;
            }
        }

        return paths;
    }
}
