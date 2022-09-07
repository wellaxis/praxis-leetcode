package com.witalis.praxis.leetcode.task.h3.p222.option;

import com.witalis.praxis.leetcode.task.h3.p222.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 222
 * Name: Count Complete Tree Nodes
 * URL: <a href="https://leetcode.com/problems/count-complete-tree-nodes/">Count Complete Tree Nodes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return countNodes(root);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
