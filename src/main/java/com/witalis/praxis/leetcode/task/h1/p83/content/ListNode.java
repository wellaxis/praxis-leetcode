package com.witalis.praxis.leetcode.task.h1.p83.content;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode clone() {
        ListNode current = this;
        ListNode cloning = null;
        ListNode tail = null;

        while (current != null) {
            if (cloning == null) {
                cloning = new ListNode(current.val, null);
                tail = cloning;
            } else {
                tail.next = new ListNode();
                tail = tail.next;
                tail.val = current.val;
                tail.next = null;
            }
            current = current.next;
        }
        return cloning;
    }

    public static ListNode initList(int size, int value) {
        var random = ThreadLocalRandom.current();

        int[] values = random.ints(
                random.nextInt(0, size + 1),
                -value, value + 1
            )
            .sorted()
            .toArray();

        ListNode mock = new ListNode();
        ListNode node = mock;
        for (int val: values) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return mock.next;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder("ListNode: [");
        builder.append(val);
        ListNode reference = next;
        while (reference != null) {
            builder.append(",").append(reference.val);
            reference = reference.next;
        }
        builder.append(']');
        return builder.toString();
    }
}
