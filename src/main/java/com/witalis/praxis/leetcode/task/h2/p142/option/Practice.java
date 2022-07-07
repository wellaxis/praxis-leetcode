package com.witalis.praxis.leetcode.task.h2.p142.option;

import com.witalis.praxis.leetcode.task.h2.p142.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 142
 * Name: Linked List Cycle II
 * URL: <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked List Cycle II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public ListNode process() {
        return detectCycle(head);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        Set<ListNode> nodes = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (nodes.contains(node)) {
                return node;
            } else {
                nodes.add(node);
                node = node.next;
            }
        }

        return null;
    }
}
