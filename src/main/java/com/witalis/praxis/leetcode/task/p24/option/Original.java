package com.witalis.praxis.leetcode.task.p24.option;

import com.witalis.praxis.leetcode.task.p24.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 24
 * Name: Swap Nodes in Pairs
 * URL: https://leetcode.com/problems/swap-nodes-in-pairs/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;
        ListNode previous = null;
        while (true) {
            slow.next = fast.next;
            fast.next = slow;
            if (previous == null) {
                head = fast;
            } else {
                previous.next = fast;
            }

            if (slow.next == null || slow.next.next == null) break;
            previous = slow;
            fast = slow.next.next;
            slow = slow.next;
        }

        return head;
    }
}
