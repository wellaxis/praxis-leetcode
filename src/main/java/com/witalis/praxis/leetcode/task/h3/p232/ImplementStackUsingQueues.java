package com.witalis.praxis.leetcode.task.h3.p232;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p232.option.*;
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
    id = 232,
    description = "Implement Queue using Stacks",
    difficulty = TaskDifficulty.EASY,
    tags = {STACK, DESIGN, QUEUE}
)
public class ImplementStackUsingQueues extends LeetCodeTask<List<String>> {
    public static final int LEN = 100;
    public static final int VALUE = 9;
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Implement a first in first out (FIFO) queue using only two stacks.
            The implemented queue should support all the functions
            of a normal queue (push, peek, pop, and empty).

        Implement the MyQueue class:
            * void push(int x) Pushes element x to the back of the queue.
            * int pop() Removes the element on the front of the queue and returns it.
            * int peek() Returns the element on the front of the queue.
            * boolean empty() Returns true if the queue is empty, false otherwise.

        Notes:
            * You must use only standard operations of a stack,
              which means that only push to top, peek/pop from top,
              size and is empty operations are valid.
            * Depending on your language, the stack may not be supported natively.
              You may simulate a stack using a list or deque (double-ended queue)
              as long as you use only a queue's standard operations.

        Example:
            Input
                ["MyQueue", "push", "push", "peek", "pop", "empty"]
                [[], [1], [2], [], [], []]

            Output
                [null, null, null, 1, 1, false]
                                               
            Explanation
                MyQueue myQueue = new MyQueue();
                myQueue.push(1); // queue is: [1]
                myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
                myQueue.peek();  // return 1
                myQueue.pop();   // return 1, queue is [2]
                myQueue.empty(); // return false""";

    public ImplementStackUsingQueues(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(0, LEN + 1);

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("MyQueue", null));
        operations.add(new AbstractMap.SimpleEntry<>("empty", null));
        for (int i = 1; i <= 9; i++) {
            operations.add(new AbstractMap.SimpleEntry<>("push", i));
        }
        for (int i = 0; i < len; i++) {
            int operation = random.nextInt(0, 4);
            switch (operation) {
                case 0 -> {
                    int value = random.nextInt(1, VALUE + 1);
                    operations.add(new AbstractMap.SimpleEntry<>("push", value));
                }
                case 1 -> operations.add(new AbstractMap.SimpleEntry<>("pop", null));
                case 2 -> operations.add(new AbstractMap.SimpleEntry<>("peek", null));
                case 3 -> operations.add(new AbstractMap.SimpleEntry<>("empty", null));
                default -> throw new IllegalArgumentException("Unexpected operation");
            }
        }
        operations.add(new AbstractMap.SimpleEntry<>("empty", null));

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2103 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 823 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 1449 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
