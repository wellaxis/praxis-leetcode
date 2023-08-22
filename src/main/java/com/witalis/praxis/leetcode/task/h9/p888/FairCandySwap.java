package com.witalis.praxis.leetcode.task.h9.p888;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p888.option.Original;
import com.witalis.praxis.leetcode.task.h9.p888.option.Practice;
import com.witalis.praxis.leetcode.task.h9.p888.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 888,
    description = "Fair Candy Swap",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, BINARY_SEARCH, SORTING}
)
public class FairCandySwap extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;

    private int[] aliceSizes;
    private int[] bobSizes;

    public static final String INFORMATION = """

        Description:
            Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes
                where aliceSizes[i] is the number of candies of the ith box of candy that Alice has
                and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

            Since they are friends, they would like to exchange one candy box each so that after the exchange,
                they both have the same total amount of candy. The total amount of candy a person has
                is the sum of the number of candies in each box they have.

            Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange,
                and answer[1] is the number of candies in the box that Bob must exchange.
                If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.

        Example:
            Input: aliceSizes = [1,1], bobSizes = [2,2]
            Output: [1,2]""";

    public FairCandySwap(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.aliceSizes = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.bobSizes = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Alice sizes: {}", Arrays.toString(aliceSizes));
        log.info("Bob sizes: {}", Arrays.toString(bobSizes));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3560 ms
    @Override
    protected int[] original() {
        var original = new Original(aliceSizes.clone(), bobSizes.clone());
        return original.process();
    }

    // time = 3144 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(aliceSizes.clone(), bobSizes.clone());
        return practice.process();
    }

    // time = 3058 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(aliceSizes.clone(), bobSizes.clone());
        return solution.process();
    }
}
