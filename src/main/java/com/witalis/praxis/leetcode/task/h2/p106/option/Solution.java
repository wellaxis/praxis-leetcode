package com.witalis.praxis.leetcode.task.h2.p106.option;

import com.witalis.praxis.leetcode.task.h2.p106.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * ID: 106
 * Name: Construct Binary Tree from Inorder and Postorder Traversal
 * URL: <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct Binary Tree from Inorder and Postorder Traversal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] inorder;
    private int[] postorder;

    public TreeNode process() {
        return buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0 || len != postorder.length) return null;

        TreeNode root = new TreeNode(postorder[len - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = null;

        for (int i = len - 2, j = len - 1; i >= 0; i--) {
            TreeNode cur = new TreeNode(postorder[i]);
            while (!stack.isEmpty() &&
                stack.peek().val == inorder[j]) {
                node = stack.pop();
                j--;
            }
            if (node != null) {
                node.left = cur;
                node = null;
            } else {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }

        return root;
    }
}
