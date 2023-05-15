package com.witalis.praxis.leetcode.task.h18.p1721.option;

import com.witalis.praxis.leetcode.task.h18.p1721.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1721
 * Name: Swapping Nodes in a Linked List
 * URL: <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">Swapping Nodes in a Linked List</a>
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
        return swapNodes(head, value);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        ListNode rtemp = head;
        ListNode ctemp = head;

        int cnt = 1;
        while (cnt < k) {
            rtemp = rtemp.next;
            ctemp = ctemp.next;
            cnt++;
        }
        while (rtemp.next != null) {
            temp = temp.next;
            rtemp = rtemp.next;
        }

        int d = temp.val;
        temp.val = ctemp.val;
        ctemp.val = d;

        return head;
    }
}
