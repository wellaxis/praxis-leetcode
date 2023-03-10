package com.witalis.praxis.leetcode.task.h4.p382.option;

import com.witalis.praxis.leetcode.task.h4.p382.content.ListNode;
import com.witalis.praxis.leetcode.task.h4.p382.content.RandomizableLinkedList;
import com.witalis.praxis.leetcode.task.h4.p382.content.RandomizedLinkedListHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;
import java.util.Random;

/**
 * ID: 382
 * Name: Linked List Random Node
 * URL: <a href="https://leetcode.com/problems/linked-list-random-node/">Linked List Random Node</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, ListNode>> operations;

    class RandomizedLinkedList implements RandomizableLinkedList<Integer> {
        private Random rnd;
        private ListNode head;
        private int length;

        public RandomizedLinkedList(ListNode head) {
            rnd = new Random();
            this.head = head;
            length = 0;
            ListNode tmp = head;
            while (tmp != null) {
                tmp = tmp.next;
                length++;
            }
        }

        @Override
        public Integer getRandom() {
            int index = rnd.nextInt(0, length);
            ListNode tmp = head;
            while (index > 0) {
                tmp = tmp.next;
                index--;
            }
            return tmp.val;
        }
    }

    public List<Integer> process() {
        final ListNode head = operations.get(0).getValue();
        return RandomizedLinkedListHandler.process(operations, new RandomizedLinkedList(head));
    }
}
