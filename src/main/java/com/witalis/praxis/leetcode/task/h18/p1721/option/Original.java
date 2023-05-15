package com.witalis.praxis.leetcode.task.h18.p1721.option;

import com.witalis.praxis.leetcode.task.h18.p1721.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1721
 * Name: Swapping Nodes in a Linked List
 * URL: <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">Swapping Nodes in a Linked List</a>
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
        return swapNodes(head, value);
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || k < 0) return new ListNode();

        ListNode first = head;
        ListNode last = head;

        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            if (count == k) first = current;
            current = current.next;
        }

        current = head;
        for (int i = 1; i <= count; i++) {
            if (i == (count + 1 - k)) {
                last = current;
                break;
            }
            current = current.next;
        }

        int t = first.val;
        first.val = last.val;
        last.val = t;

        return head;
    }
}
