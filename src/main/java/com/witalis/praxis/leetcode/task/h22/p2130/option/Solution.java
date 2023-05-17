package com.witalis.praxis.leetcode.task.h22.p2130.option;

import com.witalis.praxis.leetcode.task.h22.p2130.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2130
 * Name: Maximum Twin Sum of a Linked List
 * URL: <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">Maximum Twin Sum of a Linked List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public Integer process() {
        return pairSum(head);
    }

    public int pairSum(ListNode head) {
        int maximumSum = 0;

        // get middle of the linked list
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half of the linked list
        ListNode next;
        ListNode prev = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode start = head;
        while (prev != null) {
            maximumSum = Math.max(maximumSum, start.val + prev.val);
            prev = prev.next;
            start = start.next;
        }

        return maximumSum;
    }
}
