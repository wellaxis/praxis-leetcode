package com.witalis.praxis.leetcode.task.h7.p606.option;

import com.witalis.praxis.leetcode.task.h7.p606.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 606
 * Name: Construct String from Binary Tree
 * URL: <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">Construct String from Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public String process() {
        return tree2str(root);
    }

    public String tree2str(TreeNode root) {
        if (root == null) return "";

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        Set<TreeNode> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (visited.contains(root)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(root);
                s.append("(").append(root.val);
                if (root.left == null && root.right != null) s.append("()");
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);
            }
        }

        return s.substring(1, s.length() - 1);
    }
}
