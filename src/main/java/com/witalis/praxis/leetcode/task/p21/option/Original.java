package com.witalis.praxis.leetcode.task.p21.option;

import com.witalis.praxis.leetcode.task.p21.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 21
 * Name: Merge Two Sorted Lists
 * URL: https://leetcode.com/problems/merge-two-sorted-lists/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                break;
            } else if (l2 == null) {
                current.next = l1;
                break;
            } else {
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
        }
        return result.next;
    }
}
