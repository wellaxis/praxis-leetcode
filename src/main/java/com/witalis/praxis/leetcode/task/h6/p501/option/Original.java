package com.witalis.praxis.leetcode.task.h6.p501.option;

import com.witalis.praxis.leetcode.task.h6.p501.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 501
 * Name: Find Mode in Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">Find Mode in Binary Search Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public int[] process() {
        return findMode(root);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<Integer> modes = new HashSet<>();

        int mode = 0;
        int counter = 0;
        TreeNode previous = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                if (previous != null && previous.val == node.val) {
                    counter++;
                } else {
                    counter = 1;
                }
                if (counter > mode) {
                    mode = counter;
                    modes.clear();
                    modes.add(node.val);
                } else if (counter == mode) {
                    modes.add(node.val);
                }
                previous = node;
                current = node.right;
            }
        }

        return modes.stream().mapToInt(Integer::intValue).toArray();
    }
}
