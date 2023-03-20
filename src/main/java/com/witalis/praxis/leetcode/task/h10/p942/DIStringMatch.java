package com.witalis.praxis.leetcode.task.h10.p942;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p942.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 942,
    description = "DI String Match",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS, STRING, GREEDY}
)
public class DIStringMatch extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            A permutation perm of n + 1 integers of all the integers in the range [0, n]
                can be represented as a string s of length n where:
                * s[i] == 'I' if perm[i] < perm[i + 1], and
                * s[i] == 'D' if perm[i] > perm[i + 1].

            Given a string s, reconstruct the permutation perm and return it
                If there are multiple valid permutations perm, return any of them.

        Example:
            Input: s = "IDID"
            Output: [0,4,1,3,2]""";

    public DIStringMatch(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(random.nextBoolean() ? 'D' : 'I');
        }
        this.string = builder.toString();

        log.info("String: {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2430 ms
    @Override
    protected int[] original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 2158 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 2789 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
