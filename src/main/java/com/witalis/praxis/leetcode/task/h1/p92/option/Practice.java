package com.witalis.praxis.leetcode.task.h1.p92.option;

import com.witalis.praxis.leetcode.task.h1.p92.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 92
 * Name: Reverse Linked List II
 * URL: https://leetcode.com/problems/reverse-linked-list-ii/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;
    private int left;
    private int right;

    public ListNode process() {
        return reverseBetween(head, left, right);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left <= 0 || right <= 0 || left >= right) return head;

        int counter = 1;

        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode previous = sentinel;
        ListNode current = head;
        while (current.next != null && counter < right) {
            if (counter < left) {
                previous = current;
                current = current.next;
            } else {
                ListNode next = previous.next;
                previous.next = current.next;
                current.next = current.next.next;
                previous.next.next = next;
            }
            counter++;
        }

        return sentinel.next;
    }
}
