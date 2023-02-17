package com.witalis.praxis.leetcode.task.h8.p783.option;

import com.witalis.praxis.leetcode.task.h8.p783.content.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 783
 * Name: Minimum Distance Between BST Nodes
 * URL: <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">Minimum Distance Between BST Nodes</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Original(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return minDiffInBST(root);
    }

    private List<Integer> values;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;

        values = new ArrayList<>();
        bfs(root);
        Collections.sort(values);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            min = Math.min(min, values.get(i) - values.get(i - 1));
        }

        return min;
    }

    private void bfs(TreeNode node) {
        if (node == null) return;

        values.add(node.val);
        bfs(node.left);
        bfs(node.right);
    }
}
