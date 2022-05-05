package com.witalis.praxis.leetcode.task.h3.p234.option;

import com.witalis.praxis.leetcode.task.h3.p234.content.ListNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 234
 * Name: Palindrome Linked List
 * URL: <a href="https://leetcode.com/problems/palindrome-linked-list/">Palindrome Linked List</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private ListNode head;

    public Boolean process() {
        return isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        int[] values = nodes.stream().mapToInt(Integer::intValue).toArray();

        int l = 0;
        int r = values.length - 1;
        while (l < r) {
            if (values[l++] != values[r--]) return false;
        }

        return true;
    }
}
