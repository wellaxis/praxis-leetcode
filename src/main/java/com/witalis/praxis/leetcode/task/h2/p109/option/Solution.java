package com.witalis.praxis.leetcode.task.h2.p109.option;

import com.witalis.praxis.leetcode.task.h2.p109.content.ListNode;
import com.witalis.praxis.leetcode.task.h2.p109.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 109
 * Name: Convert Sorted List to Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">Convert Sorted List to Binary Search Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private ListNode head;

    public TreeNode process() {
        return sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;

        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        return treeify(p, 0, count - 1);
    }

    private TreeNode treeify(ListNode p, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode left = treeify(p, start, mid - 1);
        TreeNode root = new TreeNode(p.next.val);
        p.next = p.next.next;

        TreeNode right = treeify(p, mid + 1, end);
        root.left = left;
        root.right = right;

        return root;
    }
}
