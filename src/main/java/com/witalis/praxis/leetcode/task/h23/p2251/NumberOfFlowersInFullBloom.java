package com.witalis.praxis.leetcode.task.h23.p2251;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2251.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2251,
    description = "Number of Flowers in Full Bloom",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE, BINARY_SEARCH, SORTING, PREFIX_SUM, ORDERED_SET}
)
public class NumberOfFlowersInFullBloom extends LeetCodeTask<int[]> {
    public static final int LEN = 50_000;
    public static final int VALUE = 1_000_000_000;

    private int[][] flowers;
    private int[] people;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed 2D integer array flowers, where flowers[i] = [start[i], end[i]] means
                the i^th flower will be in full bloom from start[i] to end[i] (inclusive).
                You are also given a 0-indexed integer array people of size n,
                where people[i] is the time that the i^th person will arrive to see the flowers.

            Return an integer array answer of size n, where answer[i] is the number of flowers
                that are in full bloom when the i^th person arrives.

        Example:
            Input: flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
            Output: [1,2,2,2]
            Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
                For each person, we return the number of flowers in full bloom during their arrival.""";

    public NumberOfFlowersInFullBloom(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int n = random.nextInt(1, LEN + 1);
        this.flowers = new int[n][2];
        for (int i = 0; i < n; i++) {
            int start = random.nextInt(1, VALUE + 1);
            int end = random.nextInt(1, VALUE + 1);
            flowers[i] = new int[] {
                Math.min(start, end),
                Math.max(start, end)
            };
        }
        this.people = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Flowers: {}", Arrays.deepToString(flowers));
        log.info("People: {}", Arrays.toString(people));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    // time = 36611 ms
    @Override
    protected int[] original() {
        var original = new Original(cloneMatrix(flowers), people.clone());
        return original.process();
    }

    // time = 35902 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(cloneMatrix(flowers), people.clone());
        return practice.process();
    }

    // time = 19170 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(cloneMatrix(flowers), people.clone());
        return solution.process();
    }
}
