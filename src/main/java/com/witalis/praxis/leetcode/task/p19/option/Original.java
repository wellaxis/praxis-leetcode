package com.witalis.praxis.leetcode.task.p19.option;

import com.witalis.praxis.leetcode.task.p19.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 19
 * Name: Remove Nth Node From End of List
 * URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;
    private int index;

    public ListNode process() {
        return removeNthFromEnd(head, index);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return null;

        Map<Integer, ListNode> nodes = new HashMap<>();

        ListNode node = head;
        int counter = 0;
        while (node != null) {
            nodes.put(counter, node);
            node = node.next;
            counter++;
        }

        if (n > counter ) {
            return head;
        } else if (n == counter) {
            return head.next;
        } else {
            ListNode previous = nodes.get(counter - n - 1);
            previous.next = previous.next.next;
        }

        return head;
    }
}
