package com.witalis.praxis.leetcode.task.h1.p95.option;

import com.witalis.praxis.leetcode.task.h1.p95.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

/**
 * ID: 95
 * Name: Unique Binary Search Trees II
 * URL: <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Unique Binary Search Trees II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public List<TreeNode> process() {
        return generateTrees(number);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 0) return Collections.emptyList();
        if (n <= 1) return List.of(new TreeNode(n));

        List<TreeNode> trees = new ArrayList<>();
        generateTrees(
            n,
            trees,
            new TreeNode(0),
            new ArrayList<>(IntStream.rangeClosed(1, n).boxed().toList())
        );

        return trees;
    }

    private void generateTrees(int number, List<TreeNode> trees, TreeNode tree, List<Integer> values) {
        if (values.size() == 0) {
            if (checkNode(trees, tree.right)) {
                trees.add(cloneNode(tree.right));
            }
        } else {
            for (int i = 0; i < values.size(); i++) {
                Integer value = values.get(i);
                TreeNode node = new TreeNode(value);

                List<Integer> subValues = new ArrayList<>(values);
                subValues.remove(value);

                addNode(tree, node);
                generateTrees(number - 1, trees, tree, subValues);
                removeNode(tree, node);
            }
        }
    }

    private void addNode(TreeNode root, TreeNode node) {
        if (root == null || node == null) return;

        if (node.val < root.val) {
            if (root.left == null) root.left = node;
            else addNode(root.left, node);
        } else {
            if (root.right == null) root.right = node;
            else addNode(root.right, node);
        }
    }

    private void removeNode(TreeNode root, TreeNode node) {
        if (root == null || node == null) return;

        if (node.val < root.val) {
            if (root.left.val == node.val) root.left = null;
            else removeNode(root.left, node);
        } else {
            if (root.right.val == node.val) root.right = null;
            else removeNode(root.right, node);
        }
    }

    public TreeNode cloneNode(TreeNode root) {
        if (root == null) return null;

        TreeNode node = new TreeNode(root.val);

        node.left = cloneNode(root.left);
        node.right = cloneNode(root.right);

        return node;
    }

    public String showNode(TreeNode node) {
        if (node == null) return "";

        return node.val + showNode(node.left) + showNode(node.right);
    }

    public boolean checkNode(List<TreeNode> trees, TreeNode tree) {
        for (TreeNode node : trees) {
            if (showNode(node).equals(showNode(tree))) return false;
        }
        return true;
    }
}
