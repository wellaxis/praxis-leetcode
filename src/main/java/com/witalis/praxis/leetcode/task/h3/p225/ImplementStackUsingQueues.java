package com.witalis.praxis.leetcode.task.h3.p225;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p225.option.*;
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
    id = 225,
    description = "Implement Stack using Queues",
    difficulty = TaskDifficulty.EASY,
    tags = {STACK, DESIGN, QUEUE}
)
public class ImplementStackUsingQueues extends LeetCodeTask<List<String>> {
    public static final int LEN = 100;
    public static final int VALUE = 9;
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Implement a last-in-first-out (LIFO) stack using only two queues.
            The implemented stack should support all the functions
            of a normal stack (push, top, pop, and empty).

        Implement the MyStack class:
            * void push(int x) Pushes element x to the top of the stack.
            * int pop() Removes the element on the top of the stack and returns it.
            * int top() Returns the element on the top of the stack.
            * boolean empty() Returns true if the stack is empty, false otherwise.

        Notes:
            * You must use only standard operations of a queue,
              which means that only push to back, peek/pop from front,
              size and is empty operations are valid.
            * Depending on your language, the queue may not be supported natively.
              You may simulate a queue using a list or deque (double-ended queue)
              as long as you use only a queue's standard operations.

        Example:
            Input
                ["MyStack", "push", "push", "top", "pop", "empty"]
                [[], [1], [2], [], [], []]

            Output
                [null, null, null, 2, 2, false]
                                               
            Explanation
                MyStack myStack = new MyStack();
                myStack.push(1);
                myStack.push(2);
                myStack.top(); // return 2
                myStack.pop(); // return 2
                myStack.empty(); // return false""";

    public ImplementStackUsingQueues(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(0, LEN + 1);

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("MyStack", null));
        operations.add(new AbstractMap.SimpleEntry<>("empty", null));
        for (int i = 0; i < 9; i++) {
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
                case 2 -> operations.add(new AbstractMap.SimpleEntry<>("top", null));
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

    // time = 1577 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 797 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 1149 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
