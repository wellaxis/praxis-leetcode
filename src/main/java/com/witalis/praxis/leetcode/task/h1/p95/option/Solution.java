package com.witalis.praxis.leetcode.task.h1.p95.option;

import com.witalis.praxis.leetcode.task.h1.p95.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 95
 * Name: Unique Binary Search Trees II
 * URL: <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Unique Binary Search Trees II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public List<TreeNode> process() {
        return generateTrees(number);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        return helper(1, n);
    }

    public List<TreeNode> helper(int m, int n) {
        List<TreeNode> result = new ArrayList<>();
        if (m > n) {
            result.add(null);
            return result;
        }

        for (int i = m; i <= n; i++) {
            List<TreeNode> ls = helper(m, i - 1);
            List<TreeNode> rs = helper(i + 1, n);
            for (TreeNode l : ls) {
                for (TreeNode r : rs) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    result.add(curr);
                }
            }
        }

        return result;
    }
}
