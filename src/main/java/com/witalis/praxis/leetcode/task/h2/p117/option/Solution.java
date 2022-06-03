package com.witalis.praxis.leetcode.task.h2.p117.option;

import com.witalis.praxis.leetcode.task.h2.p117.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 117
 * Name: Populating Next Right Pointers in Each Node II
 * URL: <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">Populating Next Right Pointers in Each Node II</a>
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

        Node current = root;
        while (current != null) {
            // when traversing the current layer, connect the nodes of the next layer
            Node dummy = new Node();
            Node previous = dummy;
            while (current != null) {
                if (current.left != null) {
                    // the next node of previous is current left
                    previous.next = current.left;
                    previous = previous.next;
                }
                if (current.right != null) {
                    // the next node of previous is current right
                    previous.next = current.right;
                    previous = previous.next;
                }
                current = current.next;
            }
            current = dummy.next;
        }

        return root;
    }
}
