package com.witalis.praxis.leetcode.task.h6.p515.option;

import com.witalis.praxis.leetcode.task.h6.p515.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 515
 * Name: Find Largest Value in Each Tree Row
 * URL: <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">Find Largest Value in Each Tree Row</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Solution(TreeNode root) {
        this.root = root;
    }

    public List<Integer> process() {
        return largestValues(root);
    }

    List<Integer> ans;

    public List<Integer> largestValues(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root, 0);

        return ans;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) return;

        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
