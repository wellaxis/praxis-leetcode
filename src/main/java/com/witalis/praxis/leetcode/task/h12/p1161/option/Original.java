package com.witalis.praxis.leetcode.task.h12.p1161.option;

import com.witalis.praxis.leetcode.task.h12.p1161.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1161
 * Name: Maximum Level Sum of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/">Maximum Level Sum of a Binary Tree</a>
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

    public Integer process() {
        return maxLevelSum(root);
    }

    private Map<Integer, Integer> levels = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 1);

        final Comparator<Map.Entry<Integer, Integer>> levelComparator = Map.Entry.comparingByKey(Comparator.naturalOrder());
        final Comparator<Map.Entry<Integer, Integer>> sumComparator = Map.Entry.comparingByValue(Comparator.reverseOrder());

        return levels.entrySet().stream().min(sumComparator.thenComparing(levelComparator)).map(Map.Entry::getKey).orElse(0);
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        levels.put(level, levels.getOrDefault(level, 0) + node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
