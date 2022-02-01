package com.witalis.praxis.leetcode.task.h2.p141.option;

import com.witalis.praxis.leetcode.task.h2.p141.content.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 141
 * Name: Linked List Cycle
 * URL: https://leetcode.com/problems/linked-list-cycle/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public Boolean process() {
        return hasCycle(head);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        Set<ListNode> nodes = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (nodes.contains(node)) {
                return true;
            } else {
                nodes.add(node);
                node = node.next;
            }
        }

        return false;
    }
}
