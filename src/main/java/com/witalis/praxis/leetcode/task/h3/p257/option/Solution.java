package com.witalis.praxis.leetcode.task.h3.p257.option;

import com.witalis.praxis.leetcode.task.h3.p257.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * ID: 257
 * Name: Binary Tree Paths
 * URL: <a href="https://leetcode.com/problems/binary-tree-paths/">Binary Tree Paths</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<String> process() {
        return binaryTreePaths(root);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root != null) {
            dfs(result, root, String.valueOf(root.val));
        }
        return result;
    }

    private void dfs(List<String> res, TreeNode n, String path) {
        if (n.left == null && n.right == null) res.add(path);
        if (n.left != null) dfs(res, n.left, path + "->" + n.left.val);
        if (n.right != null) dfs(res, n.right, path + "->" + n.right.val);
    }
}
