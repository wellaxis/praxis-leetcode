package com.witalis.praxis.leetcode.task.h2.p143.option;

import com.witalis.praxis.leetcode.task.h2.p143.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 143
 * Name: Reorder List
 * URL: <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        reorderList(head);
        return head;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow;
        while (slow.next != null) {
            stack.push(slow.next);
            slow = slow.next;
        }
        fast.next = null;

        ListNode current = head;
        ListNode stacked;
        while (!stack.isEmpty()) {
            stacked = stack.pop();
            stacked.next = current.next;
            current.next = stacked;
            current = stacked.next;
        }
    }
}
