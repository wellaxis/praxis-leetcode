package com.witalis.praxis.leetcode.task.h4.p382;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p382.content.ListNode;
import com.witalis.praxis.leetcode.task.h4.p382.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 382,
    description = "Linked List Random Node",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, MATH, RESERVOIR_SAMPLING, RANDOMIZED}
)
public class LinkedListRandomNode extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private List<AbstractMap.SimpleEntry<String, ListNode>> operations;

    public static final String INFORMATION = """

        Description:
            Given a singly linked list, return a random node's value from the linked list.
                Each node must have the same probability of being chosen.

            Implement the Solution class:
                * Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
                * int getRandom() Chooses a node randomly from the list and returns its value.
                  All the nodes of the list should be equally likely to be chosen.

        Example:
            Input
                ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
                [[[1, 2, 3]], [], [], [], [], []]
            Output
                [null, 1, 3, 2, 2, 3]
            Explanation
                Solution solution = new Solution([1, 2, 3]);
                solution.getRandom(); // return 1
                solution.getRandom(); // return 3
                solution.getRandom(); // return 2
                solution.getRandom(); // return 2
                solution.getRandom(); // return 3
                // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.""";

    public LinkedListRandomNode(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final ListNode head = ListNode.initList(LEN, VALUE);

        log.info("Node is {}", head);

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("RandomizedLinkedList", head));

        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            operations.add(new AbstractMap.SimpleEntry<>("getRandom", null));
        }

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3876 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 3948 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 3636 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
