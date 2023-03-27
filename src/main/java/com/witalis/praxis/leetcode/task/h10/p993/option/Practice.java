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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private int value1;
    private int value2;

    public Practice(TreeNode root, int value1, int value2) {
        this.root = root;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Boolean process() {
        return isCousins(root, value1, value2);
    }

    record Node(int value, int parentValue, int depth) {}

    private List<Node> cousins = new ArrayList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || x < 0 || y < 0) return false;

        return dfs(root, root, x, y, 0);
    }

    private boolean dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) return false;

        if (node.val == x || node.val == y) {
            cousins.add(new Node(node.val, parent.val, depth));
        }

        if (cousins.size() == 2) {
            return cousins.get(0).depth() == cousins.get(1).depth() && cousins.get(0).parentValue() != cousins.get(1).parentValue();
        }

        return dfs(node.left, node, x, y, depth + 1) || dfs(node.right, node, x, y, depth + 1);
    }
}
