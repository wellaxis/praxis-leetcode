package com.witalis.praxis.leetcode.task.h3.p203.option;

import com.witalis.praxis.leetcode.task.h3.p203.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 203
 * Name: Remove Linked List Elements
 * URL: <a href="https://leetcode.com/problems/remove-linked-list-elements/">Remove Linked List Elements</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;
    private int value;

    public ListNode process() {
        return removeElements(head, value);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        if (head.val == val) {
            return removeElements(head.next , val);
        }

        head.next = removeElements(head.next , val);

        return head;
    }
}
