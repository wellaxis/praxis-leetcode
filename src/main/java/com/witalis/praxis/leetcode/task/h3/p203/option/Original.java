package com.witalis.praxis.leetcode.task.h3.p203.option;

import com.witalis.praxis.leetcode.task.h3.p203.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 203
 * Name: Remove Linked List Elements
 * URL: <a href="https://leetcode.com/problems/remove-linked-list-elements/">Remove Linked List Elements</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;
    private int value;

    public ListNode process() {
        return removeElements(head, value);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode previous = sentinel;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return sentinel.next;
    }
}
