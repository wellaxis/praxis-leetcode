package com.witalis.praxis.leetcode.task.h23.p2265.option;

import com.witalis.praxis.leetcode.task.h23.p2265.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2265
 * Name: Count Nodes Equal to Average of Subtree
 * URL: <a href="https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/">Count Nodes Equal to Average of Subtree</a>
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

    public Integer process() {
        return averageOfSubtree(root);
    }

    private int counter;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        this.counter = 0;
        dfs(root);

        return counter;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = root.val + left[0] + right[0];
        int qty = 1 + left[1] + right[1];

        if (root.val == sum / qty) counter++;

        return new int[] {sum, qty};
    }
}
