package com.witalis.praxis.leetcode.task.h22.p2130.content;

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

    public int size() {
        int size = 0;
        ListNode current = this;
        while (current != null) {
            current = current.next;
            size++;
        }

        return size;
    }

    public static ListNode initList(int length, int value) {
        var random = ThreadLocalRandom.current();
        var size = random.nextInt(2, 2 * length);

        ListNode top = new ListNode(random.nextInt(1, value + 1));
        ListNode node = top;
        while (size != 0) {
            node.next = new ListNode(random.nextInt(1, value + 1));
            node = node.next;
            size--;
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
