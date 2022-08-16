package com.witalis.praxis.leetcode.task.h2.p199.option;

import com.witalis.praxis.leetcode.task.h2.p199.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 199
 * Name: Binary Tree Right Side View
 * URL: <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View</a>
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

    public List<Integer> process() {
        return rightSideView(root);
    }

    private List<Integer> values = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        dfs(root, 0);

        return values;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (values.size() == level) values.add(node.val);

        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }
}
