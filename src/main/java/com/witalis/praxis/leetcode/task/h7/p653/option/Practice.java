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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private int target;

    public Practice(TreeNode root, int target) {
        this.root = root;
        this.target = target;
    }

    public Boolean process() {
        return findTarget(root, target);
    }

    private Set<Integer> values = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        if (values.contains(root.val)) return true;
        values.add(k - root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
