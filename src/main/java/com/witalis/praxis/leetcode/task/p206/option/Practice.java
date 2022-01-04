package com.witalis.praxis.leetcode.task.p206.option;

import com.witalis.praxis.leetcode.task.p206.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 206
 * Name: Reverse Linked List
 * URL: https://leetcode.com/problems/reverse-linked-list/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public ListNode process() {
        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        ListNode previous = reverseList(head.next);
        head.next = null;
        next.next = head;

        return previous;
    }
}
