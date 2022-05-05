package com.witalis.praxis.leetcode.task.h3.p234.option;

import com.witalis.praxis.leetcode.task.h3.p234.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 234
 * Name: Palindrome Linked List
 * URL: <a href="https://leetcode.com/problems/palindrome-linked-list/">Palindrome Linked List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public Boolean process() {
        return isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find list center
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        // reverse second part of the list
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;

        while (p1 != null && p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next = null;

        // compare two sub-lists
        ListNode p = (p2 == null ? p1 : p2);
        ListNode q = head;
        while (p != null) {
            if (p.val != q.val) return false;

            p = p.next;
            q = q.next;
        }

        return true;
    }
}
