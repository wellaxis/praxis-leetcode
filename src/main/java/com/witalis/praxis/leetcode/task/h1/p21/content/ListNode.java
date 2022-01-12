package com.witalis.praxis.leetcode.task.h1.p21.content;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public static ListNode initList(int number) {
        var random = ThreadLocalRandom.current();
        var size = random.nextInt(0, number);

        List<Integer> data = new ArrayList<>();
        while (size != 0) {
            data.add(random.nextInt(-100, 101));
            size--;
        }
        data.sort(Comparator.naturalOrder());

        ListNode top = null;
        ListNode node = null;
        for (Integer value: data) {
            if (top == null) {
                top = new ListNode(value);
                node = top;
            } else {
                node.next = new ListNode(value);
                node = node.next;
            }
        }
        return top;
    }

    public static ListNode reverseList(ListNode node) {
        ListNode previous = null;
        ListNode current;
        do {
            current = node.next;
            node.next = previous;
            previous = node;
            node = current;
        } while (node != null);
        return previous;
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
