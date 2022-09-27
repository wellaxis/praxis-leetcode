package com.witalis.praxis.leetcode.task.h7.p606.option;

import com.witalis.praxis.leetcode.task.h7.p606.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 606
 * Name: Construct String from Binary Tree
 * URL: <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">Construct String from Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public String process() {
        return tree2str(root);
    }

    public String tree2str(TreeNode root) {
        if (root == null) return "";

        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    private void dfs(TreeNode node, StringBuilder builder) {
        if (node == null) return;

        builder.append(node.val);

        if (node.left == null && node.right == null) return;

        builder.append("(");
        dfs(node.left, builder);
        builder.append(")");

        if (node.right != null) {
            builder.append("(");
            dfs(node.right, builder);
            builder.append(")");
        }
    }
}
