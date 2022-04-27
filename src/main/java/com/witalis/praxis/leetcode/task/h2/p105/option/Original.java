package com.witalis.praxis.leetcode.task.h2.p105.option;

import com.witalis.praxis.leetcode.task.h2.p105.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 105
 * Name: Construct Binary Tree from Preorder and Inorder Traversal
 * URL: <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] preorder;
    private int[] inorder;

    public Original(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
    }

    public TreeNode process() {
        return buildTree(preorder, inorder);
    }

    private int counter = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return new TreeNode();
        if (preorder.length != inorder.length)
            throw new IllegalArgumentException("Incorrect input data.");

        return recursiveBuild(preorder, inorder);
    }

    private TreeNode recursiveBuild(int[] preorder, int[] inorder) {
        int value = preorder[counter];
        TreeNode node = new TreeNode(value);
        counter++;

        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == value) break;
        }

        if (index > 0)
            node.left = recursiveBuild(preorder, Arrays.copyOfRange(inorder, 0, index));
        if (index < inorder.length - 1)
            node.right = recursiveBuild(preorder, Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
    }
}
