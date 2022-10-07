package com.witalis.praxis.leetcode.task.h7.p653.option;

import com.witalis.praxis.leetcode.task.h7.p653.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 653
 * Name: Two Sum IV - Input is a BST
 * URL: <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">Two Sum IV - Input is a BST</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private int target;

    public Boolean process() {
        return findTarget(root, target);
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        return dfs(root, k, new HashSet<>());
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> values) {
        if (node == null) {
            return false;
        } else if (values.contains(node.val)) {
            return true;
        } else {
            values.add(k - node.val);
            return dfs(node.left, k, values) || dfs(node.right, k, values);
        }
    }
}
