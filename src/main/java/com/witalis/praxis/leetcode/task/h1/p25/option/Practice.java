package com.witalis.praxis.leetcode.task.h1.p25.option;

import com.witalis.praxis.leetcode.task.h1.p25.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 25
 * Name: Reverse Nodes in k-Group
 * URL: <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in k-Group</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;
    private int group;

    public ListNode process() {
        return reverseKGroup(head, group);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        int counter = 0;

        ListNode sentinel = new ListNode(-1);
        ListNode grouping = sentinel;

        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            if (counter % k == 0) {
                if (previous != null) {
                    grouping.next = reverseGroup(previous, k - 1);
                    grouping = previous;
                }
                previous = current;
            }
            current = current.next;
            counter++;
        }
        grouping.next = (counter % k == 0) ? reverseGroup(previous, k) : previous;

        return sentinel.next;
    }

    private ListNode reverseGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode next = head.next;
        ListNode previous = reverseGroup(head.next, k - 1);
        head.next = null;
        next.next = head;

        return previous;
    }
}
