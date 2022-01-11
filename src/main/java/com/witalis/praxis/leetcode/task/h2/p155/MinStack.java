package com.witalis.praxis.leetcode.task.h2.p155;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p155.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 155,
    description = "Min Stack",
    difficulty = TaskDifficulty.EASY,
    tags = {STACK, DESIGN}
)
public class MinStack extends LeetCodeTask<List<Integer>> {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Design a stack that supports push, pop, top,
            and retrieving the minimum element in constant time.

        Implement the MinStack class:
            * MinStack() initializes the stack object.
            * void push(int val) pushes the element val onto the stack.
            * void pop() removes the element on the top of the stack.
            * int top() gets the top element of the stack.
            * int getMin() retrieves the minimum element in the stack.

        Example:
            Input
                ["MinStack","push","push","push","getMin","pop","top","getMin"]
                [[],[-2],[0],[-3],[],[],[],[]]

            Output
                [null,null,null,null,-3,null,0,-2]

            Explanation
                MinStack minStack = new MinStack();
                minStack.push(-2);
                minStack.push(0);
                minStack.push(-3);
                minStack.getMin(); // return -3
                minStack.pop();
                minStack.top();    // return 0
                minStack.getMin(); // return -2""";

    public MinStack(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    @SuppressWarnings("unchecked")
    private void initialization() {
        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("MinStack", null));
        operations.add(new AbstractMap.SimpleEntry<>("push", -2));
        operations.add(new AbstractMap.SimpleEntry<>("push", 0));
        operations.add(new AbstractMap.SimpleEntry<>("push", -3));
        operations.add(new AbstractMap.SimpleEntry<>("getMin", null));
        operations.add(new AbstractMap.SimpleEntry<>("pop", null));
        operations.add(new AbstractMap.SimpleEntry<>("top", null));
        operations.add(new AbstractMap.SimpleEntry<>("getMin", null));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1326 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 881 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 826 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
