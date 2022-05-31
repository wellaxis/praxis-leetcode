package com.witalis.praxis.leetcode.task.h2.p116.option;

import com.witalis.praxis.leetcode.task.h2.p116.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 116
 * Name: Populating Next Right Pointers in Each Node
 * URL: <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers in Each Node</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Node root;

    public Node process() {
        return connect(root);
    }

    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> nodes = new LinkedList<>(List.of(root));

        int counter = 0;
        Node current;
        Node previous = null;
        while (!nodes.isEmpty()) {
            current = nodes.poll();
            counter++;

            if (current.right != null) nodes.offer(current.right);
            if (current.left != null) nodes.offer(current.left);

            current.next = ((counter & (counter - 1)) == 0) ? null : previous;

            previous = current;
        }

        return root;
    }
}
