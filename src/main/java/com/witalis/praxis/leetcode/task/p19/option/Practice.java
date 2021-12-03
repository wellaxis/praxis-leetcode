package com.witalis.praxis.leetcode.task.p19.option;

import com.witalis.praxis.leetcode.task.p19.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 19
 * Name: Remove Nth Node From End of List
 * URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;
    private int index;

    public ListNode process() {
        return removeNthFromEnd(head, index);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return null;

        ListNode node = head;

        int counter = 0;
        while (counter < n) {
            if (node.next == null) {
                if (counter == n - 1) head = head.next;
                return head;
            }
            node = node.next;
            counter++;
        }

        ListNode previous = head;
        while (node.next != null) {
            node = node.next;
            previous = previous.next;
        }

        if (previous.next != null) {
            previous.next = previous.next.next;
        }

        return head;
    }
}
