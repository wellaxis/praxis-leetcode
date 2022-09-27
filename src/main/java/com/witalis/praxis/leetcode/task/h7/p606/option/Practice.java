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

    public String process() {
        return tree2str(root);
    }

    private StringBuilder builder = new StringBuilder();

    public String tree2str(TreeNode root) {
        if (root == null) return "";

        dfs(root);
        return builder.toString();
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        builder.append(node.val);

        if (node.left == null && node.right == null) return;

        builder.append("(");
        dfs(node.left);
        builder.append(")");

        if (node.right != null) {
            builder.append("(");
            dfs(node.right);
            builder.append(")");
        }
    }
}
