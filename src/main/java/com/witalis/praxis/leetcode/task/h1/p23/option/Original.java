package com.witalis.praxis.leetcode.task.h1.p23.option;

import com.witalis.praxis.leetcode.task.h1.p23.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 23
 * Name: Merge k Sorted Lists
 * URL: <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode[] lists;

    public ListNode process() {
        return mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode root = new ListNode();

        ListNode current = root;
        while (hasNodes(lists)) {

            ListNode min = new ListNode(Integer.MAX_VALUE);
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min.val) {
                    min = lists[i];
                    index = i;
                }
            }
            lists[index] = min.next;
            current.next = min;
            current = current.next;
        }

        return root.next;
    }

    private boolean hasNodes(ListNode[] nodes) {
        int index = 0;
        while (index < nodes.length) {
            if (nodes[index] != null) return true;
            index++;
        }
        return false;
    }
}
