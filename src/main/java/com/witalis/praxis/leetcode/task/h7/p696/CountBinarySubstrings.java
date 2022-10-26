package com.witalis.praxis.leetcode.task.h7.p696;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p696.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 696,
    description = "Count Binary Substrings",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, TWO_POINTERS}
)
public class CountBinarySubstrings extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's,
                and all the 0's and all the 1's in these substrings are grouped consecutively.

            Substrings that occur multiple times are counted the number of times they occur.

        Example:
            Input: s = "00110011"
            Output: 6
            Explanation:
                There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
                Notice that some of these substrings repeat and are counted the number of times they occur.
                Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.""";

    public CountBinarySubstrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < LEN; i++) {
            if (random.nextBoolean()) {
                builder.append('0');
            } else {
                builder.append('1');
            }
        }
        this.string = builder.toString();

        log.info("String is '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3765 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 3517 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 3486 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
