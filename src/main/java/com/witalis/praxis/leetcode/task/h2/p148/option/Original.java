package com.witalis.praxis.leetcode.task.h2.p148.option;

import com.witalis.praxis.leetcode.task.h2.p148.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 148
 * Name: Sort List
 * URL: <a href="https://leetcode.com/problems/sort-list/">Sort List</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return sortList(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // divide
        ListNode slow = new ListNode();
        ListNode fast = head;

        slow.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;

        // the 1st half
        slow = sortList(slow);
        // the 2nd half
        fast = sortList(fast);

        // conquer
        ListNode sentinel = new ListNode();
        ListNode tail;

        ListNode current = sentinel;
        while (slow != null && fast != null) {
            if (fast.val <= slow.val) {
                tail = fast.next;
                fast.next = null;
                current.next = fast;
                fast = tail;
            } else {
                tail = slow.next;
                slow.next = null;
                current.next = slow;
                slow = tail;
            }
            current = current.next;
        }
        if (slow == null) current.next = fast;
        if (fast == null) current.next = slow;

        return sentinel.next;
    }
}
