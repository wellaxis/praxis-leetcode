package com.witalis.praxis.leetcode.task.h2.p160.option;

import com.witalis.praxis.leetcode.task.h2.p160.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 160
 * Name: Intersection of Two Linked Lists
 * URL: <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode headA;
    private ListNode headB;

    public ListNode process() {
        return getIntersectionNode(headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA > lenB)
            headA = skipNodes(headA, lenA - lenB);
        if (lenB > lenA)
            headB = skipNodes(headB, lenB - lenA);

        while (headA != null && headB != null) {
            if (headA.equals(headB)) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private ListNode skipNodes(ListNode node, int skip) {
        while (skip > 0) {
            node = node.next;
            skip--;
        }
        return node;
    }
}
