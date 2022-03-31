package com.witalis.praxis.leetcode.task.h3.p203.option;

import com.witalis.praxis.leetcode.task.h3.p203.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 203
 * Name: Remove Linked List Elements
 * URL: https://leetcode.com/problems/remove-linked-list-elements/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;
    private int value;

    public ListNode process() {
        return removeElements(head, value);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null || val < 0) return head;

        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode previous = sentinel;
        while (head != null) {
            if (head.val == val) {
                previous.next = head.next;
            } else {
                previous = head;
            }
            head = head.next;
        }

        return sentinel.next;
    }
}
