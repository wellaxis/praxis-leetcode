package com.witalis.praxis.leetcode.task.h2.p142.option;

import com.witalis.praxis.leetcode.task.h2.p142.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 142
 * Name: Linked List Cycle II
 * URL: <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked List Cycle II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return detectCycle(head);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        List<ListNode> nodes = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            if (nodes.contains(node)) {
                return nodes.get(nodes.indexOf(node));
            } else {
                nodes.add(node);
                node = node.next;
            }
        }

        return null;
    }
}
