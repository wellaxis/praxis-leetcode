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
        return findTilt(root);
    }

    private int tilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);

        return tilt;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        tilt += Math.abs(l - r);

        return l + r + node.val;
    }
}
