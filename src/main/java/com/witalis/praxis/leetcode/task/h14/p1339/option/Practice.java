package com.witalis.praxis.leetcode.task.h14.p1339.option;

import com.witalis.praxis.leetcode.task.h14.p1339.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1026
 * Name: Maximum Difference Between Node and Ancestor
 * URL: <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/">Maximum Difference Between Node and Ancestor</a>
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
        return maxProduct(root);
    }

    private long sum = 0;
    private long product = 1;

    public int maxProduct(TreeNode root) {
        sum = dfsSum(root);
        dfsProduct(root);

        return (int) (product % (Math.pow(10, 9) + 7));
    }

    private static long dfsSum(TreeNode node) {
        return node == null ? 0 : node.val + dfsSum(node.left) + dfsSum(node.right);
    }

    private long dfsProduct(TreeNode node) {
        if (node == null) return 0;

        final long nodeSum = node.val + dfsProduct(node.left) + dfsProduct(node.right);
        final long nodeProduct = nodeSum * (sum - nodeSum);
        if (nodeProduct > product) product = nodeProduct;

        return nodeSum;
    }
}
