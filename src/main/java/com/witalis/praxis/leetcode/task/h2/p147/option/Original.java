package com.witalis.praxis.leetcode.task.h2.p147.option;

import com.witalis.praxis.leetcode.task.h2.p147.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.TreeMap;

/**
 * ID: 147
 * Name: Insertion Sort List
 * URL: <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort List</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return insertionSortList(head);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        Map<Integer, ListNode> nodes = new TreeMap<>(Integer::compareTo);

        ListNode next;
        while (head != null) {
            next = head.next;

            int value = head.val;
            head.next = nodes.getOrDefault(value, null);
            nodes.put(value, head);

            head = next;
        }

        ListNode sentinel = new ListNode();

        final ListNode[] current = {sentinel};
        nodes.values().forEach(
            node -> {
                current[0].next = node;
                while (node.next != null) node = node.next;
                current[0] = node;
            }
        );

        return sentinel.next;
    }
}
