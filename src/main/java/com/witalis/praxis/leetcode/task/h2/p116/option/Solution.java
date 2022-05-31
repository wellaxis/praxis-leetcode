package com.witalis.praxis.leetcode.task.h2.p116.option;

import com.witalis.praxis.leetcode.task.h2.p116.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 116
 * Name: Populating Next Right Pointers in Each Node
 * URL: <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers in Each Node</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private Node root;

    public Node process() {
        return connect(root);
    }

    public Node connect(Node root) {
        if (root == null) return root;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);

        return root;
    }
}
