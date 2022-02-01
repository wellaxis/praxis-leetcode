package com.witalis.praxis.leetcode.task.h2.p141.option;

import com.witalis.praxis.leetcode.task.h2.p141.content.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 141
 * Name: Linked List Cycle
 * URL: https://leetcode.com/problems/linked-list-cycle/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public Boolean process() {
        return hasCycle(head);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode mock = new ListNode();
        ListNode previous = head;
        ListNode current = head.next;

        while (current != null) {
            if (previous.equals(current))
                return true;
            if (current.next != null && current.next.equals(mock))
                return true;
            previous.next = mock;
            previous = current;
            current = current.next;
        }

        return false;
    }
}
