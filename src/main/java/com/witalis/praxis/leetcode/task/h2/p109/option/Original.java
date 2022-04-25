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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public TreeNode process() {
        return sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        TreeNode sentinel = new TreeNode();
        recursiveConversion(sentinel, values, true);

        return sentinel.left;
    }

    private void recursiveConversion(TreeNode parent, List<Integer> values, boolean left) {
        if (values.isEmpty() || parent == null) return;

        int mid = values.size() / 2;
        TreeNode child = new TreeNode(values.get(mid));

        if (mid >= 1) {
            recursiveConversion(child, values.subList(0, mid), true);
            recursiveConversion(child, values.subList(mid + 1, values.size()), false);
        }

        if (left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
}
