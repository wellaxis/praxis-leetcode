package com.witalis.praxis.leetcode.task.h2.p160.option;

import com.witalis.praxis.leetcode.task.h2.p160.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 160
 * Name: Intersection of Two Linked Lists
 * URL: <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode headA;
    private ListNode headB;

    public ListNode process() {
        return getIntersectionNode(headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Set<ListNode> nodes = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (nodes.contains(headA)) return headA;
                nodes.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (nodes.contains(headB)) return headB;
                nodes.add(headB);
                headB = headB.next;
            }
        }

        return null;
    }
}
