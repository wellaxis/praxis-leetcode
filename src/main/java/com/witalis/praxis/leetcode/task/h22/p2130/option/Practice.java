package com.witalis.praxis.leetcode.task.h22.p2130.option;

import com.witalis.praxis.leetcode.task.h22.p2130.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ID: 2130
 * Name: Maximum Twin Sum of a Linked List
 * URL: <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">Maximum Twin Sum of a Linked List</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public Integer process() {
        return pairSum(head);
    }

    public int pairSum(ListNode head) {
        if (head == null) return 0;

        int sum = 0;
        final Deque<Integer> stack = new ArrayDeque<>();

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);

            fast = fast.next.next;
            slow = slow.next;
        }

        while (slow != null) {
            sum = Math.max(sum, slow.val + stack.pop());
            slow = slow.next;
        }

        return sum;
    }
}
