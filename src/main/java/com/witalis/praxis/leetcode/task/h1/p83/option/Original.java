package com.witalis.praxis.leetcode.task.h1.p83.option;

import com.witalis.praxis.leetcode.task.h1.p83.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 83
 * Name: Remove Duplicates from Sorted List
 * URL: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates from Sorted List</a>
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

        ListNode previous = head;
        ListNode current = head.next;
        while (current != null) {
            int value = current.val;
            if (previous.val != value) {
                if (previous.next != current) {
                    previous.next = current;
                }
                previous = current;
            }
            current = current.next;
        }
        previous.next = null;

        return head;
    }
}
