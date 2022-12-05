package com.witalis.praxis.leetcode.task.h9.p876.option;

import com.witalis.praxis.leetcode.task.h9.p876.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 876
 * Name: Middle of the Linked List
 * URL: <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Middle of the Linked List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return middleNode(head);
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode temp = head.next.next;
        while (temp != null) {
            if (temp.next == null) break;
            head = head.next;
            temp = temp.next.next;
        }

        return head.next;
    }
}
