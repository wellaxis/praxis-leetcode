package com.witalis.praxis.leetcode.task.h2.p142.option;

import com.witalis.praxis.leetcode.task.h2.p142.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 142
 * Name: Linked List Cycle II
 * URL: <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked List Cycle II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return detectCycle(head);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode curr = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (curr != slow) {
                    curr = curr.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }
}
