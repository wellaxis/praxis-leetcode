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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Original(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return maxProduct(root);
    }

    static final class SummingTreeNode extends TreeNode {
        private final long sum;

        public SummingTreeNode(int val, TreeNode left, TreeNode right, long sum) {
            super(val, left, right);
            this.sum = sum;
        }
    }

    private long sum = 0;
    private long product = 1;

    public int maxProduct(TreeNode root) {
        SummingTreeNode summingRoot = dfsSum(root);
        if (summingRoot != null) {
            sum = summingRoot.sum;
            dfsProduct(summingRoot);
        }

        return (int) (product % (Math.pow(10, 9) + 7));
    }

    private SummingTreeNode dfsSum(TreeNode node) {
        if (node == null) return null;

        SummingTreeNode leftSumNode = dfsSum(node.left);
        SummingTreeNode rightSumNode = dfsSum(node.right);

        return new SummingTreeNode(
            node.val, leftSumNode, rightSumNode,
            node.val
                + (leftSumNode != null ? leftSumNode.sum : 0)
                + (rightSumNode != null ? rightSumNode.sum : 0)
        );
    }

    private void dfsProduct(SummingTreeNode node) {
        if (node != null) {
            long nodeProduct = node.sum * (sum - node.sum);
            if (nodeProduct > product) product = nodeProduct;

            dfsProduct((SummingTreeNode) node.left);
            dfsProduct((SummingTreeNode) node.right);
        }
    }
}
