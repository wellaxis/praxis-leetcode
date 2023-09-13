package com.witalis.praxis.leetcode.task.h9.p894.option;

import com.witalis.praxis.leetcode.task.h9.p894.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 894
 * Name: All Possible Full Binary Trees
 * URL: <a href="https://leetcode.com/problems/all-possible-full-binary-trees/">All Possible Full Binary Trees</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Original {
    private int nodes;

    public Original(int nodes) {
        this.nodes = nodes;
    }

    public List<TreeNode> process() {
        nodes = 19;
        return allPossibleFBT(nodes);
    }

    static class TreeEdge {
        TreeNode root;
        List<TreeNode> leaves;

        public TreeEdge(TreeNode root, List<TreeNode> leaves) {
            this.root = root;
            this.leaves = leaves;
        }

        public TreeNode getRoot() {
            return root;
        }

        public List<TreeNode> getLeaves() {
            return leaves;
        }
    }

    private List<TreeEdge>[] dp;

    public List<TreeNode> allPossibleFBT(int n) {
        if (n <= 0 || n % 2 == 0) return Collections.emptyList();

        final int m = n / 2 + 1;
        this.dp = new ArrayList[m];
        TreeNode root = new TreeNode(0);
        TreeEdge edge = new TreeEdge(root, new ArrayList<>(List.of(root)));
        dp[0] = new ArrayList<>(List.of(edge));
        for (int i = 1; i < m; i++)
            solver(i);

        List<TreeNode> fullBinaryTrees = new ArrayList<>();
        for (TreeEdge treeEdge : dp[m - 1])
            fullBinaryTrees.add(treeEdge.getRoot());

        return fullBinaryTrees;
    }

    private void solver(int i) {
        dp[i] = new ArrayList<>();

        List<TreeEdge> previousTrees = dp[i - 1];
        for (TreeEdge treeEdge : previousTrees) {
            TreeNode root = treeEdge.getRoot();
            for (TreeNode leaf : treeEdge.getLeaves()) {
                List<TreeNode> cloneLeaves = new ArrayList<>();
                TreeNode cloneRoot = clone(root, leaf, cloneLeaves);
                dp[i].add(new TreeEdge(cloneRoot, cloneLeaves));
            }
        }
    }

    private static TreeNode clone(TreeNode root, TreeNode leaf, List<TreeNode> leaves) {
        if (root == null) return null;

        TreeNode clone = new TreeNode(root.val);
        if (root.equals(leaf)) {
            clone.left = new TreeNode(0);
            clone.right = new TreeNode(0);
            leaves.add(clone.left);
            leaves.add(clone.right);
        } else {
            clone.left = clone(root.left, leaf, leaves);
            clone.right = clone(root.right, leaf, leaves);
        }
        if (clone.left == null && clone.right == null)
            leaves.add(clone);

        return clone;
    }
}
