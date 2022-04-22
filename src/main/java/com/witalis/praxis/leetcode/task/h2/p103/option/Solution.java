package com.witalis.praxis.leetcode.task.h2.p103.option;

import com.witalis.praxis.leetcode.task.h2.p103.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 103
 * Name: Binary Tree Zigzag Level Order Traversal
 * URL: <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Binary Tree Zigzag Level Order Traversal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<List<Integer>> process() {
        return zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        boolean rightToLeft = false;
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();

            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode current = nodesQueue.remove();
                if (current.left != null) nodesQueue.add(current.left);
                if (current.right != null) nodesQueue.add(current.right);
                level.add(current.val);
            }

            if (rightToLeft) Collections.reverse(level);
            rightToLeft = !rightToLeft;
            ans.add(level);
        }

        return ans;
    }
}
