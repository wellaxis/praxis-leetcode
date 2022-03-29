package com.witalis.praxis.leetcode.task.h1.p92.option;

import com.witalis.praxis.leetcode.task.h1.p92.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 92
 * Name: Reverse Linked List II
 * URL: https://leetcode.com/problems/reverse-linked-list-ii/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;
    private int left;
    private int right;

    public ListNode process() {
        return reverseBetween(head, left, right);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // empty list
        if (head == null) {
            return null;
        }

        // move the two pointers until they reach the proper starting point in the list
        ListNode cur = head;
        ListNode prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        // the two pointers that will fix the final connections
        ListNode con = prev;
        ListNode tail = cur;

        // iteratively reverse the nodes until n becomes 0
        ListNode third = null;
        while (right > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            right--;
        }

        // adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
