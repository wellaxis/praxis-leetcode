package com.witalis.praxis.leetcode.task.h5.p412;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p412.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 412,
    description = "Fizz Buzz",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING, SIMULATION}
)
public class FizzBuzz extends LeetCodeTask<List<String>> {
    public static final int LEN = 10_000;
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return a string array answer (1-indexed) where:
            * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
            * answer[i] == "Fizz" if i is divisible by 3.
            * answer[i] == "Buzz" if i is divisible by 5.
            * answer[i] == i (as a string) if none of the above conditions are true.

        Example:
            Input: n = 15
            Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]""";

    public FizzBuzz(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        log.info("Number 'n' is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 828 ms
    @Override
    protected List<String> original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 489 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 407 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
