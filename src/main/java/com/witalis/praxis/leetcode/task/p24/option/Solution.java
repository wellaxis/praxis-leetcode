package com.witalis.praxis.leetcode.task.p24.option;

import com.witalis.praxis.leetcode.task.p24.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 24
 * Name: Swap Nodes in Pairs
 * URL: https://leetcode.com/problems/swap-nodes-in-pairs/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public ListNode process() {
        return swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        // Dummy node
        ListNode dummy = new ListNode(0);
        // Point the next of dummy node to the head
        dummy.next = head;
        // This node will be used to traverse the list
        ListNode current = dummy;
        // Loop until we reach to the second last node
        while (current.next != null && current.next.next != null) {
            // First node of the pair
            ListNode first = current.next;
            // Second node of the pair
            ListNode second = current.next.next;
            // Point the next of first node to the node after second node
            first.next = second.next;
            // Now the current node's next should be the second node
            current.next = second;
            // Linking the original second node to the first node
            current.next.next = first;
            // Move the pointer two nodes ahead
            current = current.next.next;
        }
        return dummy.next;
    }
}
