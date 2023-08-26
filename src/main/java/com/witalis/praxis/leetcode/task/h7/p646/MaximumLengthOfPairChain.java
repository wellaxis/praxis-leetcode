package com.witalis.praxis.leetcode.task.h7.p646;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p646.option.Original;
import com.witalis.praxis.leetcode.task.h7.p646.option.Practice;
import com.witalis.praxis.leetcode.task.h7.p646.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 646,
    description = "Maximum Length of Pair Chain",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GREEDY, SORTING}
)
public class MaximumLengthOfPairChain extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private int[][] pairs;

    public static final String INFORMATION = """

        Description:
            You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

            A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

            Return the length longest chain which can be formed.

            You do not need to use up all the given intervals. You can select pairs in any order.

        Example:
            Input: pairs = [[1,2],[2,3],[3,4]]
            Output: 2
            Explanation: The longest chain is [1,2] -> [3,4].""";

    public MaximumLengthOfPairChain(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);
        this.pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(-VALUE, VALUE + 1);
            int b = random.nextInt(-VALUE, VALUE + 1);
            if (a == b) b += 1;
            pairs[i] = new int[] {
                Math.min(a, b),
                Math.max(a, b),
            };
        }

        log.info("Pairs: {}", Arrays.deepToString(pairs));
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1656 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(pairs));
        return original.process();
    }

    // time = 1513 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(pairs));
        return practice.process();
    }

    // time = 1238 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(pairs));
        return solution.process();
    }
}
