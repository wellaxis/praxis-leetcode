package com.witalis.praxis.leetcode.task.h3.p236.option;

import com.witalis.praxis.leetcode.task.h3.p236.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 236
 * Name: Lowest Common Ancestor of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest Common Ancestor of a Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private TreeNode node1;
    private TreeNode node2;

    public TreeNode process() {
        return lowestCommonAncestor(root, node1, node2);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return root;
        if (p.equals(q)) return p;

        TreeNode ancestor = null;

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        if (!findNode(root, p, pPath) || !findNode(root, q, qPath)) return root;

        for (int index = 0; index < pPath.size() && index < qPath.size(); index++) {
            if (pPath.get(index) != qPath.get(index)) break;
            ancestor = pPath.get(index);
        }

        return ancestor;
    }

    public boolean findNode(TreeNode node, TreeNode descendant, List<TreeNode> chain) {
        if (node == null) return false;

        chain.add(node);
        if (node.val == descendant.val) return true;
        if (findNode(node.left, descendant, chain)) return true;
        if (findNode(node.right, descendant, chain)) return true;
        chain.remove(node);

        return false;
    }
}
