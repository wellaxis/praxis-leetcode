package com.witalis.praxis.leetcode.task.h1.p24.option;

import com.witalis.praxis.leetcode.task.h1.p24.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 24
 * Name: Swap Nodes in Pairs
 * URL: https://leetcode.com/problems/swap-nodes-in-pairs/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public ListNode process() {
        return swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fake = new ListNode();
        fake.next = head;

        ListNode fast = fake.next.next;
        ListNode slow = fake.next;
        ListNode previous = fake;

        while (true) {
            slow.next = fast.next;
            fast.next = slow;
            previous.next = fast;

            if (slow.next == null || slow.next.next == null) break;

            previous = slow;
            fast = slow.next.next;
            slow = slow.next;
        }

        return fake.next;
    }
}
