package com.witalis.praxis.leetcode.task.h1.p86.option;

import com.witalis.praxis.leetcode.task.h1.p86.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 86
 * Name: Partition List
 * URL: https://leetcode.com/problems/partition-list/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;
    private int x;

    public ListNode process() {
        return partition(head, x);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;

        while (p != null) {
            if (p.val < x) {
                p = p.next;
                prev = prev.next;
            } else {

                p2.next = p;
                prev.next = p.next;

                p = prev.next;
                p2 = p2.next;
            }
        }

        // close the list
        p2.next = null;

        prev.next = fakeHead2.next;

        return fakeHead1.next;
    }
}

