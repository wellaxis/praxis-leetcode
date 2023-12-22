package com.witalis.praxis.leetcode.task.h15.p1422;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1422.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1422,
    description = "Maximum Score After Splitting a String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class MaximumScoreAfterSplittingString extends LeetCodeTask<Integer> {
    public static final int LEN = 500;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s of zeros and ones, return the maximum score after splitting the string
                into two non-empty substrings (i.e. left substring and right substring).

            The score after splitting a string is the number of zeros in the left substring
                plus the number of ones in the right substring.

        Example:
            Input: s = "011101"
            Output: 5
            Explanation:
                All possible ways of splitting s into two non-empty substrings are:
                left = "0" and right = "11101", score = 1 + 4 = 5
                left = "01" and right = "1101", score = 1 + 3 = 4
                left = "011" and right = "101", score = 1 + 2 = 3
                left = "0111" and right = "01", score = 1 + 1 = 2
                left = "01110" and right = "1", score = 2 + 1 = 3""";

    public MaximumScoreAfterSplittingString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(2, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (random.nextBoolean())
                builder.append('1');
            else
                builder.append('0');
        this.string = builder.toString();

        log.info("String 's': {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 523 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 473 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 438 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
