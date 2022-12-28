package com.witalis.praxis.leetcode.task.h20.p1962;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1962.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1962,
    description = "Remove Stones to Minimize the Total",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HEAP}
)
public class RemoveStonesToMinimizeTotal extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    private int[] piles;
    private int operations;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array piles, where piles[i] represents
                the number of stones in the ith pile, and an integer k.
                You should apply the following operation exactly k times:
                * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.

            Notice that you can apply the operation on the same pile more than once.

            Return the minimum possible total number of stones remaining after applying the k operations.

            floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).

        Example:
            Input: piles = [5,4,9], k = 2
            Output: 12
            Explanation: Steps of a possible scenario are:
                - Apply the operation on pile 2. The resulting piles are [5,4,5].
                - Apply the operation on pile 0. The resulting piles are [3,4,5].
                The total number of stones in [3,4,5] is 12.""";

    public RemoveStonesToMinimizeTotal(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.piles = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.operations = random.nextInt(1, LEN + 1);

        log.info("Piles: {}", Arrays.toString(piles));
        log.info("Operations 'k': {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 68581 ms
    @Override
    protected Integer original() {
        var original = new Original(piles.clone(), operations);
        return original.process();
    }

    // time = 64322 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(piles.clone(), operations);
        return practice.process();
    }

    // time = 5868 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(piles.clone(), operations);
        return solution.process();
    }
}
