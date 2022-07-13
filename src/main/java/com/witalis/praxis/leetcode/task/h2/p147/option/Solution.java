package com.witalis.praxis.leetcode.task.h2.p147.option;

import com.witalis.praxis.leetcode.task.h2.p147.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 147
 * Name: Insertion Sort List
 * URL: <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return insertionSortList(head);
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        ListNode next;
        while (head != null) {
            next = head.next;

            if (prev.val >= head.val) prev = dummy;
            while (prev.next != null && prev.next.val < head.val) prev = prev.next;
            head.next = prev.next;
            prev.next = head;

            head = next;
        }

        return dummy.next;
    }
}
