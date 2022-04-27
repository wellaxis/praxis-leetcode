package com.witalis.praxis.leetcode.task.h2.p105.option;

import com.witalis.praxis.leetcode.task.h2.p105.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 105
 * Name: Construct Binary Tree from Preorder and Inorder Traversal
 * URL: <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] preorder;
    private int[] inorder;

    public Practice(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
    }

    public TreeNode process() {
        return buildTree(preorder, inorder);
    }

    private int index = 0;
    private Map<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return new TreeNode();
        if (preorder.length != inorder.length)
            throw new IllegalArgumentException("Incorrect input data.");

        for (int i = 0; i < inorder.length; i++) indices.put(inorder[i], i);

        return recursiveBuild(preorder, 0, inorder.length - 1);
    }


    private TreeNode recursiveBuild(int[] preorder, int left, int right) {
        int value = preorder[index++];
        TreeNode node = new TreeNode(value);

        int position = indices.get(value);

        if (position > left) node.left = recursiveBuild(preorder, left, position - 1);
        if (position < right) node.right = recursiveBuild(preorder, position + 1, right);

        return node;
    }
}
