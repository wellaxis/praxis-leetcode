package com.witalis.praxis.leetcode.task.h2.p147.option;

import com.witalis.praxis.leetcode.task.h2.p147.InsertionSortList;
import com.witalis.praxis.leetcode.task.h2.p147.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 147
 * Name: Insertion Sort List
 * URL: <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort List</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public ListNode process() {
        return insertionSortList(head);
    }

    public static final int SIZE = InsertionSortList.LEN;

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode[] nodes = new ListNode[2 * SIZE + 1];

        ListNode current;
        while (head != null) {
            current = head.next;

            head.next = nodes[SIZE + head.val];
            nodes[SIZE + head.val] = head;

            head = current;
        }

        ListNode sentinel = new ListNode();

        current = sentinel;
        for (ListNode node: nodes) {
            if (node == null) continue;
            current.next = node;
            while (node.next != null) node = node.next;
            current = node;
        }

        return sentinel.next;
    }
}
