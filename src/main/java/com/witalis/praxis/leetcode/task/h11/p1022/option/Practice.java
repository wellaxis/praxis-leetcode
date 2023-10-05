package com.witalis.praxis.leetcode.task.h11.p1022.option;

import com.witalis.praxis.leetcode.task.h11.p1022.content.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1022
 * Name: Sum of Root To Leaf Binary Numbers
 * URL: <a href="https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/">Sum of Root To Leaf Binary Numbers</a>
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
        return sumRootToLeaf(root);
    }

    private List<String> binaries = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;

        dfs(root, new StringBuilder());

        int sum = 0;
        for (final String binary : binaries)
            sum += Integer.parseInt(binary, 2);

        return sum;
    }

    private void dfs (TreeNode node, StringBuilder builder) {
        builder.append(node.val);

        if (node.left == null && node.right == null)
            binaries.add(builder.toString());

        if (node.left != null) dfs(node.left, builder);
        if (node.right != null) dfs(node.right, builder);

        builder.deleteCharAt(builder.length() - 1);
    }
}
