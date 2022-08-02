package com.witalis.praxis.leetcode.task.h6.p501.option;

import com.witalis.praxis.leetcode.task.h6.p501.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 501
 * Name: Find Mode in Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">Find Mode in Binary Search Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Solution(TreeNode root) {
        this.root = root;
    }

    public int[] process() {
        return findMode(root);
    }

    int count = 0;
    int maxFreq = 1;
    TreeNode previous = null;
    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) result[i] = modes.get(i);
        return result;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (previous != null && node.val == previous.val) this.count++;
        else this.count = 1;

        if (this.count > this.maxFreq) {
            this.maxFreq = this.count;
            this.modes.clear();
            this.modes.add(node.val);
        } else if (this.count == this.maxFreq) modes.add(node.val);


        previous = node;
        inorder(node.right);
    }
}
