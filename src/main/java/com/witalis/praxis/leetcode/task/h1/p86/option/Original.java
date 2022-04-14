package com.witalis.praxis.leetcode.task.h1.p86.option;

import com.witalis.praxis.leetcode.task.h1.p86.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 86
 * Name: Partition List
 * URL: <a href="https://leetcode.com/problems/partition-list/">Partition List</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;
    private int x;

    public ListNode process() {
        return partition(head, x);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode less = new ListNode();
        ListNode more = new ListNode();
        less.next = head;

        ListNode current = head;
        ListNode previous = less;
        ListNode tailing = more;
        while (current != null) {
            if (current.val >= x) {
                previous.next = current.next;
                current.next = null;
                tailing.next = current;
                tailing = tailing.next;
                current = previous.next;
            } else {
                previous = current;
                current = current.next;
            }
        }

        previous.next = more.next;

        return less.next;
    }
}
