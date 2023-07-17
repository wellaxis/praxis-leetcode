package com.witalis.praxis.leetcode.task.h5.p445.option;

import com.witalis.praxis.leetcode.task.h5.p445.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 445
 * Name: Add Two Numbers II
 * URL: <a href="https://leetcode.com/problems/add-two-numbers-ii/">Add Two Numbers II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode list1;
    private ListNode list2;

    public ListNode process() {
        return addTwoNumbers(list1, list2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        final Deque<Integer> stack1 = convert(l1);
        final Deque<Integer> stack2 = convert(l2);

        int carry = 0;
        ListNode current = null;
        ListNode previous = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();

            int sum = val1 + val2 + carry;
            current = new ListNode(sum % 10);
            current.next = previous;
            previous = current;
            carry = sum / 10;
        }
        if (carry == 1) {
            current = new ListNode(1);
            current.next = previous;
        }

        return current;
    }

    private static Deque<Integer> convert(ListNode listNode) {
        Deque<Integer> stack = new ArrayDeque<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        return stack;
    }
}
