package com.witalis.praxis.leetcode.task.h3.p257.option;

import com.witalis.praxis.leetcode.task.h3.p257.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 257
 * Name: Binary Tree Paths
 * URL: https://leetcode.com/problems/binary-tree-paths/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public List<String> process() {
        return binaryTreePaths(root);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<String> paths = new ArrayList<>();
        recursiveTreePaths(root, paths, new StringBuilder());

        return paths;
    }

    private void recursiveTreePaths(TreeNode node, List<String> paths, StringBuilder path) {
        if (node == null) return;

        path.append(node.val);
        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            path.append("->");
            recursiveTreePaths(node.left, paths, new StringBuilder(path));
            recursiveTreePaths(node.right, paths, new StringBuilder(path));
        }
    }
}
