package com.witalis.praxis.leetcode.task.h4.p382.option;

import com.witalis.praxis.leetcode.task.h4.p382.content.ListNode;
import com.witalis.praxis.leetcode.task.h4.p382.content.RandomizableLinkedList;
import com.witalis.praxis.leetcode.task.h4.p382.content.RandomizedLinkedListHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ID: 382
 * Name: Linked List Random Node
 * URL: <a href="https://leetcode.com/problems/linked-list-random-node/">Linked List Random Node</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, ListNode>> operations;

    class RandomizedLinkedList implements RandomizableLinkedList<Integer> {
        private static final Random random = ThreadLocalRandom.current();
        private final int[] values;

        public RandomizedLinkedList(ListNode head) {
            List<Integer> list = new LinkedList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            this.values = list.stream().mapToInt(Integer::intValue).toArray();
        }

        @Override
        public Integer getRandom() {
            return values[random.nextInt(0, values.length)];
        }
    }

    public List<Integer> process() {
        final ListNode head = operations.get(0).getValue();
        return RandomizedLinkedListHandler.process(operations, new RandomizedLinkedList(head));
    }
}
