package com.witalis.praxis.leetcode.task.h2.p113.option;

import com.witalis.praxis.leetcode.task.h2.p113.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 113
 * Name: Path Sum II
 * URL: <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int sum;

    public List<List<Integer>> process() {
        return pathSum(root, sum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> paths = new ArrayList<>();
        recursivePathSum(root, targetSum, paths, new ArrayList<>());
        return paths;
    }

    private void recursivePathSum(TreeNode node, int targetSum, List<List<Integer>> paths, List<Integer> path) {
        if (node == null) return;

        targetSum -= node.val;
        List<Integer> targetPath = new ArrayList<>(path);
        targetPath.add(node.val);

        if (node.left == null && node.right == null && targetSum == 0) {
            paths.add(targetPath);
        } else {
            recursivePathSum(node.left, targetSum, paths, targetPath);
            recursivePathSum(node.right, targetSum, paths, targetPath);
        }
    }
}
