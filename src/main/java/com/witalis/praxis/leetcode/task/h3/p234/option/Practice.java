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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public Boolean process() {
        return isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        // move - one step
        ListNode slow = head;
        // move - two steps
        ListNode fast = head;

        // reverse first half
        ListNode prev = null;
        ListNode next = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // even vs odd nodes
        if (fast.next != null) {
            if (slow.val != slow.next.val) return false;
            slow = slow.next;
        }
        slow = slow.next;
        fast = prev;

        // compare reverse vs second half
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}
