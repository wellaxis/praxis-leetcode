package com.witalis.praxis.leetcode.task.p2.option;

import com.witalis.praxis.leetcode.task.p2.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2
 * Name: Add Two Numbers
 * URL: https://leetcode.com/problems/add-two-numbers/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode l1;
    private ListNode l2;

    public ListNode process() {
        return addTwoNumbers(l1, l2);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode top = null;
        ListNode nodeNext = null;
        ListNode node;

        int oversize = 0;
        while (l1 != null || l2 != null) {
            int value1 = (l1 != null) ? l1.val : 0;
            int value2 = (l2 != null) ? l2.val : 0;

            int value = value1 + value2 + oversize;
            oversize = value / 10;
            node = new ListNode(value % 10);
            if (nodeNext != null)
                nodeNext.next = node;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            if (top == null)
                top = node;
            nodeNext = node;
        }
        if (oversize > 0)
            nodeNext.next = new ListNode(oversize);

        return top;
    }
}
