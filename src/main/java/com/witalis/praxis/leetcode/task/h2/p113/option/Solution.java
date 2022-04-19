package com.witalis.praxis.leetcode.task.h2.p113.option;

import com.witalis.praxis.leetcode.task.h2.p113.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 113
 * Name: Path Sum II
 * URL: <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private int sum;

    public List<List<Integer>> process() {
        return pathSum(root, sum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(res, path, root, sum);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == root.val) res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        dfs(res, path, root.left, sum - root.val);
        dfs(res, path, root.right, sum - root.val);

        path.remove(path.size() - 1);
    }
}
