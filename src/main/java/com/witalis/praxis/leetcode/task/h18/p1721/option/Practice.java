package com.witalis.praxis.leetcode.task.h18.p1721.option;

import com.witalis.praxis.leetcode.task.h18.p1721.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1721
 * Name: Swapping Nodes in a Linked List
 * URL: <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">Swapping Nodes in a Linked List</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;
    private int value;

    public ListNode process() {
        return swapNodes(head, value);
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || k <= 0) return new ListNode();

        ListNode node = head;

        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            if (count == k) node = current;
            current = current.next;
        }

        current = head;
        for (int i = 1; i <= count; i++) {
            if (i == (count + 1 - k)) {
                int value = node.val;
                node.val = current.val;
                current.val = value;
                break;
            }
            current = current.next;
        }

        return head;
    }
}
