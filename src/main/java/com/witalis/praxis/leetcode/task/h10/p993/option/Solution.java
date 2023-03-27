package com.witalis.praxis.leetcode.task.h10.p993.option;

import com.witalis.praxis.leetcode.task.h10.p993.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 993
 * Name: Cousins in Binary Tree
 * URL: <a href="https://leetcode.com/problems/cousins-in-binary-tree/">Cousins in Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private int value1;
    private int value2;

    public Solution(TreeNode root, int value1, int value2) {
        this.root = root;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Boolean process() {
        return isCousins(root, value1, value2);
    }

    private List<TreeNode> nodes = new ArrayList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        int xDepth = findDepth(root, x);
        int yDepth = findDepth(root, y);

        return xDepth == yDepth && nodes.get(0) != nodes.get(1);
    }

    private int findDepth(TreeNode node, int value) {
        if (node == null) return 0;
        if (node.val == value) return 1;

        int leftSubtree = findDepth(node.left, value);
        int rightSubtree = findDepth(node.right, value);

        if (leftSubtree == 0 && rightSubtree == 0) return 0;
        if (leftSubtree == 1 || rightSubtree == 1) nodes.add(node);

        return leftSubtree + rightSubtree + 1;
    }
}
