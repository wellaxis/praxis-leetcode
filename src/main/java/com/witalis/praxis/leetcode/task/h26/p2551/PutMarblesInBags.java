package com.witalis.praxis.leetcode.task.h26.p2551;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h26.p2551.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2551,
    description = "Put Marbles in Bags",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, GREEDY, SORTING, HEAP}
)
public class PutMarblesInBags extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] weights;
    private int bags;

    public static final String INFORMATION = """

        Description:
            You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble.
                You are also given the integer k.

            Divide the marbles into the k bags according to the following rules:
                * No bag is empty.
                * If the ith marble and jth marble are in a bag,
                  then all marbles with an index between the ith and jth indices should also be in that same bag.
                * If a bag consists of all the marbles with an index from i to j inclusively,
                  then the cost of the bag is weights[i] + weights[j].

            The score after distributing the marbles is the sum of the costs of all the k bags.

            Return the difference between the maximum and minimum scores among marble distributions.

        Example:
            Input: weights = [1,3,5,1], k = 2
            Output: 4
            Explanation:
                The distribution [1],[3,5,1] results in the minimal score of (1+1) + (3+1) = 6.
                The distribution [1,3],[5,1], results in the maximal score of (1+3) + (5+1) = 10.
                Thus, we return their difference 10 - 6 = 4.""";

    public PutMarblesInBags(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.weights = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.bags = random.nextInt(1, weights.length + 1);

        log.info("Weights: {}", Arrays.toString(weights));
        log.info("Bags K: {}", bags);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 42312 ms
    @Override
    protected Long original() {
        var original = new Original(weights.clone(), bags);
        return original.process();
    }

    // time = 7758 ms
    @Override
    protected Long practice() {
        var practice = new Practice(weights.clone(), bags);
        return practice.process();
    }

    // time = 3554 ms
    @Override
    protected Long solution() {
        var solution = new Solution(weights.clone(), bags);
        return solution.process();
    }
}
