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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return sortList(head);
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode start, ListNode end) {
        if (start == null || start.next == null || start == end) {
            return start;
        }

        int pivot = start.val;
        ListNode left = start;
        ListNode right = start;
        ListNode curr = start.next;
        boolean sorted = true;

        while (curr != null && curr != end) {
            ListNode temp = curr.next;
            if (curr.val < pivot) {
                sorted = false;
                curr.next = left;
                left = curr;
                right.next = temp;
            } else if (curr.val < right.val) {
                sorted = false;
                right = curr;
            } else {
                right = curr;
            }
            curr = temp;
        }
        if (sorted) return start;

        start.next = sortList(start.next, end);
        left = sortList(left, start);

        return left;
    }
}
