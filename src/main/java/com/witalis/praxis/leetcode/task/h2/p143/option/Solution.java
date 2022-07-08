package com.witalis.praxis.leetcode.task.h2.p143.option;

import com.witalis.praxis.leetcode.task.h2.p143.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 143
 * Name: Reorder List
 * URL: <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        reorderList(head);
        return head;
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head;

        // find the middle of list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // half start from next node of the middle one
        ListNode tmp = slow.next;
        slow.next = null;

        // reverse last half of list
        ListNode newHead = reverseList(tmp);

        // connect 1st half to 2nd half
        ListNode current = head;
        while (current != null && newHead != null) {
            ListNode tmp1 = current.next;
            ListNode tmp2 = newHead.next;
            current.next = newHead;
            newHead.next = tmp1;
            current = tmp1;
            newHead = tmp2;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head.next;
        head.next = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = head;
            head = current;
            current = tmp;
        }

        return head;
    }
}
