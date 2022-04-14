package com.witalis.praxis.leetcode.task.h1.p82.option;

import com.witalis.praxis.leetcode.task.h1.p82.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 82
 * Name: Remove Duplicates from Sorted List II
 * URL: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Remove Duplicates from Sorted List II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode sentinel = new ListNode(Integer.MAX_VALUE);
        sentinel.next = head;

        ListNode unique = sentinel;
        ListNode current = sentinel;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                if (unique.next != null) {
                    unique.next = null;
                }
            } else {
                if (unique.next == null) {
                    if (current.next.next == null || current.next.val != current.next.next.val) {
                        unique.next = current.next;
                        unique = unique.next;
                    }
                } else {
                    unique = current;
                }
            }
            current = current.next;
        }

        return sentinel.next;


    }
}
