package com.witalis.praxis.leetcode.task.h12.p1128;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1128.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1128,
    description = "Number of Equivalent Domino Pairs",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, COUNTING}
)
public class NumberOfEquivalentDominoPairs extends LeetCodeTask<Integer> {
    public static final int LEN = 40_000;
    public static final int VALUE = 9;

    private int[][] dominoes;

    public static final String INFORMATION = """

        Description:
            Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
                if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

            Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

        Example:
            Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
            Output: 3""";

    public NumberOfEquivalentDominoPairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.dominoes = new int[len][2];
        for (int i = 0; i < len; i++) {
            dominoes[i] = new int[] {
                random.nextInt(1, VALUE + 1),
                random.nextInt(1, VALUE + 1)
            };
        }

        log.info("Dominoes: {}", Arrays.deepToString(dominoes));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 12479 ms
    @Override
    protected Integer original() {
        var original = new Original(dominoes);
        return original.process();
    }

    // time = 1568 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(dominoes);
        return practice.process();
    }

    // time = 1483 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(dominoes);
        return solution.process();
    }
}
