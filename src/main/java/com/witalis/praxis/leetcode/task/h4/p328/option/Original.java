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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public ListNode process() {
        return oddEvenList(head);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        ListNode node = evenHead.next;
        boolean isOdd = true;
        while (node != null) {
            if (isOdd) {
                oddTail.next = node;
                evenTail.next = null;
                oddTail = node;
            } else {
                evenTail.next = node;
                oddTail.next = null;
                evenTail = node;
            }
            node = node.next;
            isOdd = !isOdd;
        }
        oddTail.next = evenHead;

        return oddHead;
    }
}
