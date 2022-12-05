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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return middleNode(head);
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
