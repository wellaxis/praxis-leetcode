package com.witalis.praxis.leetcode.task.h7.p637.option;

import com.witalis.praxis.leetcode.task.h7.p637.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 637
 * Name: Average of Levels in Binary Tree
 * URL: <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">Average of Levels in Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public List<Double> process() {
        return averageOfLevels(root);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Map<Integer, List<Integer>> frequency = new HashMap<>();
        dfs(frequency, root, 0);

        List<Double> avgLevels = new ArrayList<>();
        frequency.forEach(
            (key, value) -> avgLevels.add(key, value.stream().mapToDouble(Integer::intValue).sum() / value.size())
        );

        return avgLevels;
    }

    private void dfs(Map<Integer, List<Integer>> frequency, TreeNode node, int level) {
        if (node == null) return;

        frequency.computeIfPresent(level, (key, value) -> {value.add(node.val); return value;});
        frequency.putIfAbsent(level, new ArrayList<>(List.of(node.val)));

        dfs(frequency, node.left, level + 1);
        dfs(frequency, node.right, level + 1);
    }
}
