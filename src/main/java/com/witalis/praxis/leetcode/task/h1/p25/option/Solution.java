package com.witalis.praxis.leetcode.task.h1.p25.option;

import com.witalis.praxis.leetcode.task.h1.p25.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 25
 * Name: Reverse Nodes in k-Group
 * URL: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;
    private int group;

    public ListNode process() {
        return reverseKGroup(head, group);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // checking if there are enough elements
        ListNode tmp = head;
        for (int i = 1; i < k; i++) {
            tmp = tmp.next;
            if (tmp == null) return head;
        }

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        // reverse first k nodes of linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Next is now a pointer to (k+1)th node.
        // Recursively call for the list starting from current.
        // And make rest of the list as next of first node
        head.next = reverseKGroup(next, k);

        // prev is now head of input list
        return prev;
    }
}
