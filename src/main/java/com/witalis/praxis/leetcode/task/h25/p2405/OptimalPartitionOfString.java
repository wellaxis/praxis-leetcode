package com.witalis.praxis.leetcode.task.h25.p2405;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2405.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2405,
    description = "Optimal Partition of String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, GREEDY}
)
public class OptimalPartitionOfString extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
                That is, no letter appears in a single substring more than once.

            Return the minimum number of substrings in such a partition.

            Note that each character should belong to exactly one substring in a partition.

        Example:
            Input: s = "abacaba"
            Output: 4
            Explanation:
                Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
                It can be shown that 4 is the minimum number of substrings needed.""";

    public OptimalPartitionOfString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final var len = random.nextInt(1, LEN + 1);
        final var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }

        this.string = builder.toString();

        log.info("String: {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2263 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 2075 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1692 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
