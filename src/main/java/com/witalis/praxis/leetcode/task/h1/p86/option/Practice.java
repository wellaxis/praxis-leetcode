package com.witalis.praxis.leetcode.task.h1.p86.option;

import com.witalis.praxis.leetcode.task.h1.p86.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 86
 * Name: Partition List
 * URL: https://leetcode.com/problems/partition-list/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;
    private int x;

    public ListNode process() {
        return partition(head, x);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode less = new ListNode();
        ListNode more = new ListNode();

        ListNode currentLess = less;
        ListNode currentMore = more;
        while (head != null) {
            if (head.val < x) {
                currentLess.next = head;
                currentLess = currentLess.next;
            } else {
                currentMore.next = head;
                currentMore = currentMore.next;
            }
            head = head.next;
        }
        currentMore.next = null;
        currentLess.next = more.next;

        return less.next;
    }
}
