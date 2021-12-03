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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode[] lists;

    public ListNode process() {
        return mergeKLists(lists);
    }

    /**
     * All nodes are the same - original.
     * Algorithm doesn't create new nodes.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        List<ListNode> nodes = new ArrayList<>(Arrays.asList(lists));
        nodes.removeIf(Objects::isNull);

        Set<Integer> indexes;

        ListNode root = new ListNode();
        ListNode current = root;
        while (!nodes.isEmpty()) {
            indexes = new HashSet<>();

            ListNode min = null;
            for (int i = 0; i < nodes.size(); i++) {
                if (min == null) {
                    min = nodes.get(i);
                    indexes.add(i);
                } else {
                    if (nodes.get(i).val < min.val) {
                        indexes.clear();
                        min = nodes.get(i);
                        indexes.add(i);
                    } else if (nodes.get(i).val == min.val) {
                        indexes.add(i);
                    }
                }
            }
            if (min == null) break;

            List<Integer> tails = new ArrayList<>();
            for (Integer index: indexes) {
                var node = nodes.get(index);
                if (node.next == null) {
                    tails.add(index);
                } else {
                    nodes.set(index, node.next);
                }
                current.next = node;
                current = current.next;
            }
            tails.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(i -> nodes.remove(i.intValue()));
        }

        return root.next;
    }
}
