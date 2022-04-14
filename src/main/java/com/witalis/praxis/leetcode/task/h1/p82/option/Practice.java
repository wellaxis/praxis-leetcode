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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public ListNode process() {
        return deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode sentinel = new ListNode(Integer.MAX_VALUE, head);

        ListNode unique = sentinel;
        ListNode current = sentinel;
        while (current.next != null) {
            int value = current.val;

            if (value == current.next.val) {
                current = current.next;
                while (current != null && current.val == value) {
                    current = current.next;
                }
                unique.next = current;

                if (current == null) break;

                if (current.next != null && current.val != current.next.val) {
                    unique = current;
                } else {
                    continue;
                }
            } else {
                unique = current;
            }
            current = current.next;
        }

        return sentinel.next;
    }
}
