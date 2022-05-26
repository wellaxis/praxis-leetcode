package com.witalis.praxis.leetcode.task.h2.p106.option;

import com.witalis.praxis.leetcode.task.h2.p106.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 106
 * Name: Construct Binary Tree from Inorder and Postorder Traversal
 * URL: <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct Binary Tree from Inorder and Postorder Traversal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] inorder;
    private int[] postorder;

    public Practice(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
    }

    public TreeNode process() {
        return buildTree(inorder, postorder);
    }

    private int index = 0;
    private Map<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return new TreeNode();
        if (inorder.length != postorder.length)
            throw new IllegalArgumentException("Incorrect input data.");

        for (int i = 0; i < inorder.length; i++) indices.put(inorder[i], i);

        return recursiveBuild(postorder, 0, inorder.length - 1);
    }

    private TreeNode recursiveBuild(int[] postorder, int left, int right) {
        int value = postorder[postorder.length - 1 - index++];
        TreeNode node = new TreeNode(value);

        int position = indices.get(value);

        if (position < right) node.right = recursiveBuild(postorder, position + 1, right);
        if (position > left) node.left = recursiveBuild(postorder, left, position - 1);

        return node;
    }
}
