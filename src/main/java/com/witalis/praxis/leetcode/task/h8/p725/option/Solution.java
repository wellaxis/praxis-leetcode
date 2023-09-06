package com.witalis.praxis.leetcode.task.h8.p725.option;

import com.witalis.praxis.leetcode.task.h8.p725.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 725
 * Name: Split Linked List in Parts
 * URL: <a href="https://leetcode.com/problems/split-linked-list-in-parts/">Split Linked List in Parts</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;
    private int parts;

    public ListNode[] process() {
        return splitListToParts(head, parts);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];

        final int length = getLength(root);
        final int subLength = length / k;
        int remainder = length % k;

        ListNode prev = null;
        ListNode head = root;
        for (int i = 0; i < k; ++i, --remainder) {
            ans[i] = head;
            for (int j = 0; j < subLength + (remainder > 0 ? 1 : 0); ++j) {
                prev = head;
                head = head.next;
            }
            if (prev != null)
                prev.next = null;
        }

        return ans;
    }

    private int getLength(ListNode root) {
        int length = 0;
        for (ListNode curr = root; curr != null; curr = curr.next)
            ++length;
        return length;
    }
}
