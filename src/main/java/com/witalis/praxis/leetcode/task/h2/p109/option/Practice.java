package com.witalis.praxis.leetcode.task.h2.p109.option;

import com.witalis.praxis.leetcode.task.h2.p109.content.ListNode;
import com.witalis.praxis.leetcode.task.h2.p109.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 109
 * Name: Convert Sorted List to Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">Convert Sorted List to Binary Search Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private ListNode head;

    public TreeNode process() {
        return sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] values = list.stream().mapToInt(Integer::intValue).toArray();

        TreeNode sentinel = new TreeNode();
        recursiveConversion(sentinel, values, 0, values.length - 1, true);

        return sentinel.left;
    }

    private void recursiveConversion(TreeNode parent, int[] values, int begin, int end, boolean left) {
        if (begin > end || parent == null) return;

        int mid = (begin + end) / 2;
        TreeNode child = new TreeNode(values[mid]);

        if (left) parent.left = child; else parent.right = child;

        recursiveConversion(child, values, begin, mid - 1, true);
        recursiveConversion(child, values, mid + 1, end, false);
    }
}
