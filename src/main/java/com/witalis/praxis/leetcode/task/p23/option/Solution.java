package com.witalis.praxis.leetcode.task.p23.option;

import com.witalis.praxis.leetcode.task.p23.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 23
 * Name: Merge k Sorted Lists
 * URL: https://leetcode.com/problems/merge-k-sorted-lists/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode[] lists;
    private static boolean isQueue = true;

    public ListNode process() {
        return mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (isQueue) {
            Comparator<ListNode> cmp = Comparator.comparingInt(o -> o.val);
            Queue<ListNode> q = new PriorityQueue<>(cmp);
            for (ListNode ln : lists) {
                if (ln != null) {
                    q.add(ln);
                }
            }

            ListNode head = new ListNode(0);
            ListNode current = head;
            while (!q.isEmpty()) {
                current.next = q.poll();
                current = current.next;
                ListNode next = current.next;
                if (next != null) {
                    q.add(next);
                }
            }
            return head.next;
        } else {
            List<Integer> l = new ArrayList<>();
            for (ListNode ln : lists) {
                while (ln != null) {
                    l.add(ln.val);
                    ln = ln.next;
                }
            }
            Collections.sort(l);

            ListNode head = new ListNode(0);
            ListNode current = head;
            for (int i : l) {
                ListNode t = new ListNode(i);
                current.next = t;
                current = current.next;
            }
            current.next = null;
            return head.next;
        }
    }
}
