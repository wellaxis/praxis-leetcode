package com.witalis.praxis.leetcode.task.h10.p938.option;

import com.witalis.praxis.leetcode.task.h10.p938.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 938
 * Name: Range Sum of BST
 * URL: <a href="https://leetcode.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int low;
    private int high;

    public Integer process() {
        return rangeSumBST(root, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return root == null ? 0 : dfs(root, low, high, 0);
    }

    private int dfs(TreeNode node, int low, int high, int sum) {
        return ((low <= node.val && node.val <= high) ? sum + node.val : sum)
            + ((node.val >= low && node.left != null) ? dfs(node.left, low, high, sum) : 0)
            + ((node.val <= high && node.right != null) ? dfs(node.right, low, high, sum) : 0);
    }
}
