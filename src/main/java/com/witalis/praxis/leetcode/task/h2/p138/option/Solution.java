package com.witalis.praxis.leetcode.task.h2.p138.option;

import com.witalis.praxis.leetcode.task.h2.p138.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 138
 * Name: Copy List with Random Pointer
 * URL: <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Copy List with Random Pointer</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private Node head;

    public Node process() {
        return copyRandomList(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // create new nodes (between)
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }

        // set random link
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node dummyHead = new Node(0);

        // separate new nodes to new list
        curr = head;
        Node currCopy = dummyHead;
        while (curr != null) {
            currCopy.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return dummyHead.next;
    }
}
