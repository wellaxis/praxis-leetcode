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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return averageOfSubtree(root);
    }

    record Node(int sum, int qty) {}

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        int[] counter = new int[] {0};
        dfs(root, counter);

        return counter[0];
    }

    public Node dfs(TreeNode root, int[] counter) {
        if (root == null) return new Node(0, 0);

        Node left = dfs(root.left, counter);
        Node right = dfs(root.right, counter);

        int sum = root.val + left.sum + right.sum;
        int qty = 1 + left.qty + right.qty;

        if (root.val == sum / qty) counter[0]++;

        return new Node(sum, qty);
    }
}
