package com.witalis.praxis.leetcode.task.h6.p563.option;

import com.witalis.praxis.leetcode.task.h6.p563.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 563
 * Name: Binary Tree Tilt
 * URL: <a href="https://leetcode.com/problems/binary-tree-tilt/">Binary Tree Tilt</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return findTilt(root);
    }

    public int findTilt(TreeNode root) {
        int[] tilt = new int[] {0};
        dfs(root, tilt);

        return tilt[0];
    }

    private int dfs(TreeNode node, int[] tilt) {
        if (node == null) return 0;

        int l = dfs(node.left, tilt);
        int r = dfs(node.right, tilt);

        tilt[0] += Math.abs(l - r);

        return l + r + node.val;
    }
}
