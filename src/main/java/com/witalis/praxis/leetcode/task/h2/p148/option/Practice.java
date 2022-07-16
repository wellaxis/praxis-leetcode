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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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

        // conquer
        return merge(sortList(slow), sortList(fast));
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode sentinel = new ListNode();
        ListNode tail;

        ListNode current = sentinel;
        while (left != null && right != null) {
            if (right.val <= left.val) {
                tail = right.next;
                right.next = null;
                current.next = right;
                right = tail;
            } else {
                tail = left.next;
                left.next = null;
                current.next = left;
                left = tail;
            }
            current = current.next;
        }
        if (left == null) current.next = right;
        if (right == null) current.next = left;

        return sentinel.next;
    }
}
