package com.witalis.praxis.leetcode.task.h1.p21.option;

import com.witalis.praxis.leetcode.task.h1.p21.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 21
 * Name: Merge Two Sorted Lists
 * URL: <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode l1;
    private ListNode l2;

    public ListNode process() {
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode();

        ListNode current = result;
        while (l1 != null && l2 != null) {
            ListNode tail;
            if (l2.val <= l1.val) {
                tail = l2.next;
                l2.next = null;
                current.next = l2;
                current = current.next;
                l2 = tail;
            } else {
                tail = l1.next;
                l1.next = null;
                current.next = l1;
                current = current.next;
                l1 = tail;
            }
        }
        if (l1 == null) current.next = l2;
        if (l2 == null) current.next = l1;

        return result.next;
    }
}
