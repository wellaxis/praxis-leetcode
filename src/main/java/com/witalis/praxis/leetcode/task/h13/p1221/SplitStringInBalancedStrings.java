package com.witalis.praxis.leetcode.task.h13.p1221;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1221.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1221,
    description = "Split a String in Balanced Strings",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, GREEDY, COUNTING}
)
public class SplitStringInBalancedStrings extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

            Given a balanced string s, split it into some number of substrings such that:
                * Each substring is balanced.

            Return the maximum number of balanced strings you can obtain.

        Example:
            Input: s = "RLRRLLRLRL"
            Output: 4
            Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.""";

    public SplitStringInBalancedStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        var builder = new StringBuilder();
        while (len-- > 0) {
            if (random.nextBoolean()) {
                builder.append('L');
            } else {
                builder.append('R');
            }
        }
        this.string = builder.toString();

        log.info("String 's': {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 538 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 511 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 452 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
