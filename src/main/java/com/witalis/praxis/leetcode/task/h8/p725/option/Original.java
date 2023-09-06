package com.witalis.praxis.leetcode.task.h8.p725.option;

import com.witalis.praxis.leetcode.task.h8.p725.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 725
 * Name: Split Linked List in Parts
 * URL: <a href="https://leetcode.com/problems/split-linked-list-in-parts/">Split Linked List in Parts</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;
    private int parts;

    public ListNode[] process() {
        return splitListToParts(head, parts);
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];

        if (head == null || k <= 0) return parts;

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int quotient = length / k;
        int remainder = length % k;

        current = head;
        ListNode previous = null;
        for (int i = 0; current != null && i < k; i++, remainder--) {
            parts[i] = current;

            for (int j = 0; j < quotient + (remainder > 0 ? 1 : 0); j++) {
                previous = current;
                current = current.next;
            }

            if (previous != null) {
                previous.next = null;
            }
        }

        return parts;
    }
}
