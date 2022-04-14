package com.witalis.praxis.leetcode.task.h1.p95.option;

import com.witalis.praxis.leetcode.task.h1.p95.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 95
 * Name: Unique Binary Search Trees II
 * URL: <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Unique Binary Search Trees II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public List<TreeNode> process() {
        return generateTrees(number);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 0) return Collections.emptyList();
        if (n <= 1) return List.of(new TreeNode(n));

        List<List<TreeNode>> result = new ArrayList<>();
        result.add(0, new ArrayList<>() {{ add(null); }});

        for (int i = 1; i <= n; i++) {
            result.add(i, new ArrayList<>());
            for (int j = 0; j < i; j++) {
                List<TreeNode> lefts = result.get(j);
                List<TreeNode> rights = result.get(i - 1 - j);
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = cloneNode(right, j + 1);
                        result.get(i).add(root);
                    }
                }
            }
        }
        return result.get(n);
    }

    public TreeNode cloneNode(TreeNode root, int offset) {
        if (root == null) return null;

        TreeNode node = new TreeNode(root.val + offset);

        node.left = cloneNode(root.left, offset);
        node.right = cloneNode(root.right, offset);

        return node;
    }
}