package com.witalis.praxis.leetcode.task.h2.p141.option;

import com.witalis.praxis.leetcode.task.h2.p141.content.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 141
 * Name: Linked List Cycle
 * URL: https://leetcode.com/problems/linked-list-cycle/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public Boolean process() {
        return hasCycle(head);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
