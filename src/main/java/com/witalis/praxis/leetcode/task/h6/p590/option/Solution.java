package com.witalis.praxis.leetcode.task.h6.p590.option;

import com.witalis.praxis.leetcode.task.h6.p590.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 590
 * Name: N-ary Tree Postorder Traversal
 * URL: <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">N-ary Tree Postorder Traversal</a>
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
        return postorder(root);
    }

    private List<Integer> output = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return output;

        for (Node node : root.children) postorder(node);
        output.add(root.val);

        return output;
    }
}
