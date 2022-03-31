package com.witalis.praxis.leetcode.task.h1.p25.option;

import com.witalis.praxis.leetcode.task.h1.p25.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 25
 * Name: Reverse Nodes in k-Group
 * URL: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;
    private int group;

    public ListNode process() {
        return reverseKGroup(head, group);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        int size = getListNodeSize(head);
        int counter = 0;

        ListNode sentinel = new ListNode(-1);
        ListNode grouping = sentinel;
        ListNode first = null;

        ListNode next;
        ListNode previous = null;
        ListNode current = head;
        while (current != null && size >= k) {
            if (counter == 0) first = current;
            counter++;
            // swap
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            // group
            if (counter == k) {
                grouping.next = previous;
                grouping = first;
                previous = null;
                size -= k;
                counter = 0;
            }
        }
        if (current != null) {
            grouping.next = current;
        }

        return sentinel.next;

    }

    private int getListNodeSize(ListNode node) {
        int counter = 0;
        while (node != null) {
            node = node.next;
            counter++;
        }
        return counter;
    }
}
