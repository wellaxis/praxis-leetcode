package com.witalis.praxis.leetcode.task.h1.p61.option;

import com.witalis.praxis.leetcode.task.h1.p61.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * ID: 61
 * Name: Rotate List
 * URL: <a href="https://leetcode.com/problems/rotate-list/">Rotate List</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;
    private int rotation;

    public ListNode process() {
        return rotateRight(head, rotation);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode slow = head;
        ListNode fast = head;

        int counter = 0;
        while (fast != null) {
            fast = fast.next;
            counter++;
        }

        fast = head;

        k = k % counter;
        while (k-- > 0) fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = Objects.requireNonNullElse(slow.next, head);
        }

        fast.next = head;
        fast = slow.next;
        slow.next = null;

        return fast;
    }
}
