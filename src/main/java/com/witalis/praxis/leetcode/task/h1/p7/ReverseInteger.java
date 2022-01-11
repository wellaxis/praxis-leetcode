package com.witalis.praxis.leetcode.task.h1.p7;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p7.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 7,
    description = "Reverse Integer",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH}
)
public class ReverseInteger extends LeetCodeTask<Integer> {
    private int number;

    public static final String INFORMATION = """

        Given a signed 32-bit integer x, return x with its digits reversed.
            If reversing x causes the value to go outside
            the signed 32-bit integer range [-231, 231 - 1], then return 0.
                                                                          
        Assume the environment does not allow you
            to store 64-bit integers (signed or unsigned).
        
        Example:
            Input: x = 123
            Output: 321""";

    public ReverseInteger(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = 15323469;
        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1219 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 945 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 885 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
