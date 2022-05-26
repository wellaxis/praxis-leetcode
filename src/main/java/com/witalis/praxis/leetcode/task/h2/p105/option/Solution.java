package com.witalis.praxis.leetcode.task.h2.p105.option;

import com.witalis.praxis.leetcode.task.h2.p105.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * ID: 105
 * Name: Construct Binary Tree from Preorder and Inorder Traversal
 * URL: <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] preorder;
    private int[] inorder;

    public TreeNode process() {
        return buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0 || len != inorder.length) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        TreeNode node = null;

        for (int i = 1, j = 0; i < len; i++) {
            TreeNode cur = new TreeNode(preorder[i]);
            while (!stack.isEmpty() &&
                stack.peek().val == inorder[j]) {
                node = stack.pop();
                j++;
            }
            if (node != null) {
                node.right = cur;
                node = null;
            } else {
                stack.peek().left = cur;
            }
            stack.push(cur);
        }

        return root;
    }
}
