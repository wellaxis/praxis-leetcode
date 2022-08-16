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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<Integer> process() {
        return rightSideView(root);
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return res;
    }
}
