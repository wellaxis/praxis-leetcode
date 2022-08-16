package com.witalis.praxis.leetcode.task.h2.p199.option;

import com.witalis.praxis.leetcode.task.h2.p199.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 199
 * Name: Binary Tree Right Side View
 * URL: <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Original(TreeNode root) {
        this.root = root;
    }

    public List<Integer> process() {
        return rightSideView(root);
    }

    private Map<Integer, Integer> cache = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        dfs(root, 0);

        List<Integer> values = new ArrayList<>(cache.size());
        cache.keySet().forEach(level -> values.add(level, cache.get(level)));

        return values;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        cache.put(level, node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
