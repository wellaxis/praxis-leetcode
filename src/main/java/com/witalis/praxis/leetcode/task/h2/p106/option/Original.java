package com.witalis.praxis.leetcode.task.h2.p106.option;

import com.witalis.praxis.leetcode.task.h2.p106.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 106
 * Name: Construct Binary Tree from Inorder and Postorder Traversal
 * URL: <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct Binary Tree from Inorder and Postorder Traversal</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] inorder;
    private int[] postorder;

    public Original(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
    }

    public TreeNode process() {
        return buildTree(inorder, postorder);
    }

    private int counter = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return new TreeNode();
        if (inorder.length != postorder.length)
            throw new IllegalArgumentException("Incorrect input data.");

        return recursiveBuild(postorder, inorder);
    }

    private TreeNode recursiveBuild(int[] postorder, int[] inorder) {
        int value = postorder[postorder.length - 1 - counter];
        TreeNode node = new TreeNode(value);
        counter++;

        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == value) break;
        }

        if (index < inorder.length - 1)
            node.right = recursiveBuild(postorder, Arrays.copyOfRange(inorder, index + 1, inorder.length));
        if (index > 0)
            node.left = recursiveBuild(postorder, Arrays.copyOfRange(inorder, 0, index));

        return node;
    }
}
