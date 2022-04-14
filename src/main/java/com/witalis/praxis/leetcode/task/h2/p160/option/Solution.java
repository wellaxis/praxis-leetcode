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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode headA;
    private ListNode headB;

    public ListNode process() {
        return getIntersectionNode(headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
