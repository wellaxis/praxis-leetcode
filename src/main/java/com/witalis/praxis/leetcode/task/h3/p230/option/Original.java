package com.witalis.praxis.leetcode.task.h3.p230.option;

import com.witalis.praxis.leetcode.task.h3.p230.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 230
 * Name: Kth Smallest Element in a BST
 * URL: <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int index;

    public Original(TreeNode root, int index) {
        this.root = root;
        this.index = index;
    }

    public Integer process() {
        return kthSmallest(root, index);
    }

    private List<Integer> elements = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;

        dfs(root, k);

        return elements.get(k - 1);
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || elements.size() >= k) return;

        dfs(node.left, k);
        elements.add(node.val);
        dfs(node.right, k);
    }
}
