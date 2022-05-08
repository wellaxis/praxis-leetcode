package com.witalis.praxis.leetcode.task.h3.p237.option;

import com.witalis.praxis.leetcode.task.h3.p237.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 237
 * Name: Delete Node in a Linked List
 * URL: <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode node;

    public ListNode process() {
        deleteNode(node);
        return node;
    }

    public void deleteNode(ListNode node) {
        ListNode temp = node.next.next;
        node.val = node.next.val;
        node.next = temp;
    }
}
