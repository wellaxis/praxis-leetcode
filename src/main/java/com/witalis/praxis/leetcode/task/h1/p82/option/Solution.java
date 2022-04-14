package com.witalis.praxis.leetcode.task.h1.p82.option;

import com.witalis.praxis.leetcode.task.h1.p82.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 82
 * Name: Remove Duplicates from Sorted List II
 * URL: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Remove Duplicates from Sorted List II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }
}
