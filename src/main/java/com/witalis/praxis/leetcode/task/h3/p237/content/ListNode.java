package com.witalis.praxis.leetcode.task.h3.p237.content;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Definition for singly-linked list.
 */
public class ListNode implements Cloneable {
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

    public static ListNode initList(int length, int value) {
        var random = ThreadLocalRandom.current();
        var size = random.nextInt(2, length);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(random.nextInt(-value, value));
        }

        int[] values = set.stream().distinct().mapToInt(Integer::intValue).toArray();
        ListNode top = new ListNode(values[0]);
        ListNode node = top;
        for (int i = 1; i < values.length; i++) {
            node.next = new ListNode(values[i]);
            node = node.next;
        }
        return top;
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
