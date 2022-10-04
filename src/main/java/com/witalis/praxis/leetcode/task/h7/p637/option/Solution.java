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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<Double> process() {
        return averageOfLevels(root);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            long count = 0;

            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                sum += node.val;
                count++;
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
            }

            queue = temp;
            res.add(sum * 1.0 / count);
        }

        return res;
    }
}
