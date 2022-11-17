package com.witalis.praxis.leetcode.task.h4.p328.option;

import com.witalis.praxis.leetcode.task.h4.p328.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 328
 * Name: Odd Even Linked List
 * URL: <a href="https://leetcode.com/problems/odd-even-linked-list/">Odd Even Linked List</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public ListNode process() {
        return oddEvenList(head);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode sentinel = head.next;
        ListNode odd = head;
        ListNode even = sentinel;
        ListNode node = even.next;
        while (node != null) {
            odd.next = node;
            odd = node;
            even.next = node.next;
            even = node.next;

            node = node.next;
            if (node != null) node = node.next;
        }
        odd.next = sentinel;

        return head;
    }
}
