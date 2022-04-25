package com.witalis.praxis.leetcode.task.h2.p109.content;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

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

    public static ListNode initRandom(int number, int value) {
        var random = ThreadLocalRandom.current();
        var size = random.nextInt(0, number);

        List<Integer> data = new ArrayList<>();
        while (size != 0) {
            data.add(random.nextInt(-value, value + 1));
            size--;
        }
        data.sort(Comparator.naturalOrder());

        ListNode top = null;
        ListNode node = null;
        for (Integer val: data) {
            if (top == null) {
                top = new ListNode(val);
                node = top;
            } else {
                node.next = new ListNode(val);
                node = node.next;
            }
        }
        return top;
    }

    public static ListNode initSerial(int number) {
        return IntStream.rangeClosed(-number, number)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .reduce(
                new ListNode(),
                (n, i) -> new ListNode(i, n),
                (n1, n2) -> new ListNode(n1.val, n2)
            );
    }

    public static ListNode[] initSerials(int number, int length) {
        ListNode[] nodes = new ListNode[length];
        while (length > 0) {
            nodes[length - 1] = initSerial(number);
            length--;
        }
        return nodes;
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
