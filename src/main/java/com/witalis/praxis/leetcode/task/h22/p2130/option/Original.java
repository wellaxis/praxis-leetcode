package com.witalis.praxis.leetcode.task.h22.p2130.option;

import com.witalis.praxis.leetcode.task.h22.p2130.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 2130
 * Name: Maximum Twin Sum of a Linked List
 * URL: <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">Maximum Twin Sum of a Linked List</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public Integer process() {
        return pairSum(head);
    }

    public int pairSum(ListNode head) {
        if (head == null) return 0;

        int sum = 0;

        final List<Integer> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node.val);
            node = node.next;
        }

        final int n = nodes.size();
        for (int i = 0; i < n / 2; i++) {
            sum = Math.max(sum, nodes.get(i) + nodes.get(n - 1 - i));
        }

        return sum;
    }
}
