package com.witalis.praxis.leetcode.task.h2.p107.option;

import com.witalis.praxis.leetcode.task.h2.p107.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ID: 107
 * Name: Binary Tree Level Order Traversal II
 * URL: <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">Binary Tree Level Order Traversal II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<List<Integer>> process() {
        return levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode popNode = queue.remove();
                levelList.add(popNode.val);
                if (popNode.left != null) {
                    queue.add(popNode.left);
                }
                if (popNode.right != null) {
                    queue.add(popNode.right);
                }
            }
            res.add(0, levelList);
        }

        return res;
    }
}
