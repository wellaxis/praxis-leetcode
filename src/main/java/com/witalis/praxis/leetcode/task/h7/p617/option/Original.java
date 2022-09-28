package com.witalis.praxis.leetcode.task.h7.p617.option;

import com.witalis.praxis.leetcode.task.h7.p617.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 617
 * Name: Merge Two Binary Trees
 * URL: <a href="https://leetcode.com/problems/merge-two-binary-trees/">Merge Two Binary Trees</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root1;
    private TreeNode root2;

    public TreeNode process() {
        return mergeTrees(root1, root2);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);

        return node;
    }
}
