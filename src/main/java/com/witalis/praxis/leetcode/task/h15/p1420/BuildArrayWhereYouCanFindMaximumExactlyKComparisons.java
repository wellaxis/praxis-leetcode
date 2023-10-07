package com.witalis.praxis.leetcode.task.h15.p1420;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1420.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1420,
    description = "Build Array Where You Can Find The Maximum Exactly K Comparisons",
    difficulty = TaskDifficulty.HARD,
    tags = {DYNAMIC_PROGRAMMING, PREFIX_SUM}
)
public class BuildArrayWhereYouCanFindMaximumExactlyKComparisons extends LeetCodeTask<Integer> {
    public static final int LEN = 50;
    public static final int VALUE = 100;

    private int size;
    private int edge;
    private int cost;

    public static final String INFORMATION = """

        Description:
            You are given three integers n, m and k.
                Consider the following algorithm to find the maximum element of an array of positive integers:
                --------------------------------------
                maximum_value = -1
                maximum_index = -1
                search_cost = 0
                n = arr.length
                for (i = 0; i < n; i++) {
                    if (maximum_value < arr[i]) {
                        maximum_value = arr[i]
                        maximum_index = i
                        search_cost = search_cost + 1
                    }
                }
                return maximum_index
                --------------------------------------

            You should build the array arr which has the following properties:
                * arr has exactly n integers.
                * 1 <= arr[i] <= m where (0 <= i < n).
                * After applying the mentioned algorithm to arr, the value search_cost is equal to k.

            Return the number of ways to build the array arr under the mentioned conditions.
                As the answer may grow large, the answer must be computed modulo 10^9 + 7.

        Example:
            Input: s = "1317", k = 2000
            Output: 8
            Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]""";

    public BuildArrayWhereYouCanFindMaximumExactlyKComparisons(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.size = random.nextInt(1, LEN + 1);
        this.edge = random.nextInt(1, VALUE + 1);
        this.cost = random.nextInt(0, size + 1);

        log.info("Size 'n': {}", size);
        log.info("Edge 'm': {}", edge);
        log.info("Cost 'k': {}", cost);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7038 ms
    @Override
    protected Integer original() {
        var original = new Original(size, edge, cost);
        return original.process();
    }

    // time = 6786 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(size, edge, cost);
        return practice.process();
    }

    // time = 3563 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(size, edge, cost);
        return solution.process();
    }
}
