package com.witalis.praxis.leetcode.task.h2.p138.option;

import com.witalis.praxis.leetcode.task.h2.p138.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 138
 * Name: Copy List with Random Pointer
 * URL: <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Copy List with Random Pointer</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private Node head;

    public Node process() {
        return copyRandomList(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Map<Node, Node> pointers = new HashMap<>();
        Map<Node, List<Node>> forwards = new HashMap<>();

        Node sentinel = new Node(0);

        Node previous = sentinel;
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.val);
            previous.next = clone;

            pointers.put(current, clone);
            if (current.random != null) {
                if (pointers.containsKey(current.random)) {
                    clone.random = pointers.get(current.random);
                } else {
                    if (forwards.containsKey(current.random)) {
                        forwards.get(current.random).add(clone);
                    } else {
                        forwards.put(current.random, new ArrayList<>(List.of(clone)));
                    }
                }
            }

            if (forwards.containsKey(current)) {
                forwards.get(current).forEach(
                    node -> node.random = clone
                );
                forwards.remove(current);
            }

            previous = clone;
            current = current.next;
        }

        return sentinel.next;
    }
}
