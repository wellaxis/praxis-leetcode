package com.witalis.praxis.leetcode.task.h1.p61.option;

import com.witalis.praxis.leetcode.task.h1.p61.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 61
 * Name: Rotate List
 * URL: https://leetcode.com/problems/rotate-list/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;
    private int rotation;

    public ListNode process() {
        return rotateRight(head, rotation);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode fast = head;
        while (k > 0) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                fast = head;
            }
            k--;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (slow.next != null) {
                slow = slow.next;
            } else {
                slow = head;
            }
        }

        fast.next = head;
        fast = slow.next;
        slow.next = null;

        return fast;
    }
}
