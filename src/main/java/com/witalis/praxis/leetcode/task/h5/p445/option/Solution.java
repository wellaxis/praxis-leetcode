package com.witalis.praxis.leetcode.task.h5.p445.option;

import com.witalis.praxis.leetcode.task.h5.p445.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 445
 * Name: Add Two Numbers II
 * URL: <a href="https://leetcode.com/problems/add-two-numbers-ii/">Add Two Numbers II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode list1;
    private ListNode list2;

    public ListNode process() {
        return addTwoNumbers(list1, list2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);

        int totalSum = 0;
        int carry = 0;
        ListNode ans = new ListNode();
        while (r1 != null || r2 != null) {
            if (r1 != null) totalSum += r1.val;
            if (r2 != null) totalSum += r2.val;

            ans.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;

            r1 = r1 != null ? r1.next : null;
            r2 = r2 != null ? r2.next : null;
        }

        return carry == 0 ? ans.next: ans;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp;

        while (head != null) {
            // keep the next node
            temp = head.next;
            // reverse the link
            head.next = prev;
            // update the previous node and the current node
            prev = head;
            head = temp;
        }

        return prev;
    }
}
