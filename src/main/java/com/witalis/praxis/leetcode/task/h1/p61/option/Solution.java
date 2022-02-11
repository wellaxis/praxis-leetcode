package com.witalis.praxis.leetcode.task.h1.p61.option;

import com.witalis.praxis.leetcode.task.h1.p61.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 61
 * Name: Rotate List
 * URL: https://leetcode.com/problems/rotate-list/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;
    private int rotation;

    public ListNode process() {
        return rotateRight(head,rotation);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            ++len;
        }

        k %= len;
        if (k == 0) return head;

        ListNode prev = head;
        for (int i = 0; i < len - k - 1; ++i) {
            prev = prev.next;
        }

        ListNode result = prev.next;
        prev.next = null;
        tail.next = head;

        return result;
    }
}
