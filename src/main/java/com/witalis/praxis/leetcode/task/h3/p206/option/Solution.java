package com.witalis.praxis.leetcode.task.h3.p206.option;

import com.witalis.praxis.leetcode.task.h3.p206.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 206
 * Name: Reverse Linked List
 * URL: <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // get second node
        ListNode second = head.next;
        // set first's next to be null
        head.next = null;

        ListNode rest = reverseList(second);
        second.next = head;

        return rest;
    }
}
