package com.witalis.praxis.leetcode.task.h2.p129.option;

import com.witalis.praxis.leetcode.task.h2.p129.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 129
 * Name: Sum Root to Leaf Numbers
 * URL: <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">Sum Root to Leaf Numbers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return sumNumbers(root);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        while (root != null || !queue.isEmpty()) {
            if (root == null) root = queue.pop();

            if (root.left == null && root.right == null) {
                sum += root.val;
                root = null;
            } else {
                if (root.left != null) {
                    root.left.val += root.val * 10;
                    if (root.right != null) {
                        root.right.val += root.val * 10;
                        queue.push(root.right);
                    }
                    root = root.left;
                } else {
                    root.right.val += root.val * 10;
                    root = root.right;
                }
            }
        }

        return sum;
    }
}
