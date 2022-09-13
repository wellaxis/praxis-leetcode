package com.witalis.praxis.leetcode.task.h6.p589.option;

import com.witalis.praxis.leetcode.task.h6.p589.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 589
 * Name: N-ary Tree Preorder Traversal
 * URL: <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">N-ary Tree Preorder Traversal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private Node root;

    public Solution(Node root) {
        this.root = root;
    }

    public List<Integer> process() {
        return preorder(root);
    }

    private List<Integer> output = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return output;

        output.add(root.val);
        for (Node node : root.children) {
            if (node != null) {
                preorder(node);
            }
        }

        return output;
    }
}
