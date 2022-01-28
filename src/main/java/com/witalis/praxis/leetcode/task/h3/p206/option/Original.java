package com.witalis.praxis.leetcode.task.h3.p206.option;

import com.witalis.praxis.leetcode.task.h3.p206.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 206
 * Name: Reverse Linked List
 * URL: https://leetcode.com/problems/reverse-linked-list/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next;
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
