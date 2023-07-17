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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode list1;
    private ListNode list2;

    public ListNode process() {
        return addTwoNumbers(list1, list2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        final Deque<Integer> stack1 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        final Deque<Integer> stack2 = new ArrayDeque<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        final Deque<Integer> stack = new ArrayDeque<>();

        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();

            int sum = val1 + val2 + carry;
            stack.push(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) stack.push(1);

        ListNode sentinel = new ListNode();

        ListNode previous = sentinel;
        while (!stack.isEmpty()) {
            int val = stack.pop();

            ListNode current = new ListNode(val);
            previous.next = current;
            previous = current;
        }

        return sentinel.next;
    }
}
