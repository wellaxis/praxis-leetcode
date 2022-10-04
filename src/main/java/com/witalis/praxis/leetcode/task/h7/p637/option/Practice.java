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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Practice(TreeNode root) {
        this.root = root;
    }

    public List<Double> process() {
        return averageOfLevels(root);
    }

    private Map<Integer, long[]> frequency = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return Collections.emptyList();

        dfs(root, 0);

        List<Double> avgLevels = new ArrayList<>();
        frequency.forEach((key, value) -> avgLevels.add(key, (double) value[0] / value[1]));

        return avgLevels;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        frequency.computeIfPresent(
            level,
            (key, value) -> {
                value[0] += node.val;
                ++value[1];
                return value;
            }
        );
        frequency.putIfAbsent(
            level,
            new long[] {node.val, 1}
        );

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
