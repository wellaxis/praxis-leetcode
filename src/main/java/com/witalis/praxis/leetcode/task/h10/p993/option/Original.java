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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int value1;
    private int value2;

    public Original(TreeNode root, int value1, int value2) {
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

        dfs(root, root, x, y, 0);

        if (cousins.size() != 2) return false;

        final Node the1st = cousins.get(0);
        final Node the2nd = cousins.get(1);

        return the1st.depth() == the2nd.depth() && the1st.parentValue() != the2nd.parentValue();
    }

    private void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) return;

        if (node.val == x || node.val == y) {
            cousins.add(new Node(node.val, parent.val, depth));
        }

        if (cousins.size() == 2) return;
        dfs(node.left, node, x, y, depth + 1);
        dfs(node.right, node, x, y, depth + 1);
    }
}
