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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;
    private int index;

    public ListNode process() {
        return removeNthFromEnd(head, index);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Two pointers - fast and slow
        ListNode slow = head;
        ListNode fast = head;
        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.next == null) {
                // If n is equal to the number of nodes, delete the head node
                if (i == n - 1) {
                    head = head.next;
                }
                return head;
            }
            fast = fast.next;
        }
        // Loop until we reach to the end.
        // Now we will move both fast and slow pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Delink the nth node from last
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }
}
