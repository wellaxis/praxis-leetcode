package com.witalis.praxis.leetcode.task.h2.p138.option;

import com.witalis.praxis.leetcode.task.h2.p138.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 138
 * Name: Copy List with Random Pointer
 * URL: <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Copy List with Random Pointer</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Node head;

    public Node process() {
        return copyRandomList(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Map<Node, Node> pointers = new HashMap<>();

        Node sentinel = new Node(0);

        Node previous = sentinel;
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.val);
            previous.next = clone;

            pointers.put(current, clone);

            previous = clone;
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                Node clone = pointers.get(current);
                clone.random = pointers.get(current.random);
            }

            current = current.next;
        }

        return sentinel.next;
    }
}
