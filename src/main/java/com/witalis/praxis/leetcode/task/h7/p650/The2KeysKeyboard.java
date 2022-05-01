package com.witalis.praxis.leetcode.task.h7.p650;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p650.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 650,
    description = "2 Keys Keyboard",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, DYNAMIC_PROGRAMMING}
)
public class The2KeysKeyboard extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    private int number;

    public static final String INFORMATION = """

        There is only one character 'A' on the screen of a notepad.
            You can perform one of two operations on this notepad for each step:
            * Copy All: You can copy all the characters present on the screen
              (a partial copy is not allowed).
            * Paste: You can paste the characters which are copied last time.

        Given an integer n, return the minimum number of operations
            to get the character 'A' exactly n times on the screen.

        Example:
            Input: n = 3
            Output: 3
            Explanation: Initially, we have one character 'A'.
                In step 1, we use Copy All operation.
                In step 2, we use Paste operation to get 'AA'.
                In step 3, we use Paste operation to get 'AAA'.""";

    public The2KeysKeyboard(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1477 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 413 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 379 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
