package com.witalis.praxis.leetcode.task.h1.p83.option;

import com.witalis.praxis.leetcode.task.h1.p83.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 83
 * Name: Remove Duplicates from Sorted List
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }
}
