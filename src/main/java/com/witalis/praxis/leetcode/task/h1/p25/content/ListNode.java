package com.witalis.praxis.leetcode.task.h1.p25.content;

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

    public static ListNode initList(int number, int value) {
        var random = ThreadLocalRandom.current();
        var size = random.nextInt(1, number + 1);

        ListNode top = new ListNode(random.nextInt(0, value + 1));
        ListNode node = top;
        while (size != 0) {
            node.next = new ListNode(random.nextInt(0, value + 1));
            node = node.next;
            size--;
        }
        return top;
    }

    public static int size(ListNode node) {
        if (node == null) return 0;

        int counter = 1;
        while (node.next != null) {
            node = node.next;
            counter++;
        }
        return counter;
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
