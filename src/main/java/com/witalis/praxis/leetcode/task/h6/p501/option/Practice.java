package com.witalis.praxis.leetcode.task.h6.p501.option;

import com.witalis.praxis.leetcode.task.h6.p501.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * ID: 501
 * Name: Find Mode in Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">Find Mode in Binary Search Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public int[] process() {
        return findMode(root);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<Integer> modes = new HashSet<>();

        int mode = 0;
        int counter = -1;
        TreeNode previous = new TreeNode(Integer.MIN_VALUE);
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                if (previous.val == node.val) {
                    counter++;
                } else {
                    if (counter > mode) {
                        mode = counter;
                        modes.clear();
                        modes.add(previous.val);
                    } else if (counter == mode) {
                        modes.add(previous.val);
                    }
                    previous = node;
                    counter = 1;
                }
                current = node.right;
            }
        }
        if (counter >= mode) {
            if (counter > mode) modes.clear();
            modes.add(previous.val);
        }

        return modes.stream().mapToInt(Integer::intValue).toArray();
    }
}
