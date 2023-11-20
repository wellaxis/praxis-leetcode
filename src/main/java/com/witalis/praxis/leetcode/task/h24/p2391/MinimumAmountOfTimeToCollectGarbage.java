package com.witalis.praxis.leetcode.task.h24.p2391;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2391.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2391,
    description = "Minimum Amount of Time to Collect Garbage",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STRING, PREFIX_SUM}
)
public class MinimumAmountOfTimeToCollectGarbage extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int SIZE = 10;
    public static final int TIME = 100;

    private String[] garbage;
    private int[] travel;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed array of strings garbage where garbage[i]
                represents the assortment of garbage at the ith house.
                garbage[i] consists only of the characters 'M', 'P' and 'G' representing
                one unit of metal, paper and glass garbage respectively.
                Picking up one unit of any type of garbage takes 1 minute.

            You are also given a 0-indexed integer array travel where travel[i]
                is the number of minutes needed to go from house i to house i + 1.

            There are three garbage trucks in the city, each responsible for picking up
                one type of garbage. Each garbage truck starts at house 0 and must visit each house in order;
                however, they do not need to visit every house.

            Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.

            Return the minimum number of minutes needed to pick up all the garbage.

        Example:
            Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]
            Output: 21
            Explanation:
                The paper garbage truck:
                    1. Travels from house 0 to house 1
                    2. Collects the paper garbage at house 1
                    3. Travels from house 1 to house 2
                    4. Collects the paper garbage at house 2
                    Altogether, it takes 8 minutes to pick up all the paper garbage.
                The glass garbage truck:
                    1. Collects the glass garbage at house 0
                    2. Travels from house 0 to house 1
                    3. Travels from house 1 to house 2
                    4. Collects the glass garbage at house 2
                    5. Travels from house 2 to house 3
                    6. Collects the glass garbage at house 3
                    Altogether, it takes 13 minutes to pick up all the glass garbage.
                Since there is no metal garbage, we do not need to consider the metal garbage truck.
                Therefore, it takes a total of 8 + 13 = 21 minutes to collect all the garbage.""";

    public MinimumAmountOfTimeToCollectGarbage(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        this.garbage = new String[len];
        for (int i = 0; i < len; i++) {
            StringBuilder builder = new StringBuilder();
            int size = random.nextInt(1, SIZE + 1);
            for (int j = 0; j < size; j++) {
                int type = random.nextInt(0, 3);
                switch (type) {
                    case 0 -> builder.append('M');
                    case 1 -> builder.append('P');
                    case 2 -> builder.append('G');
                    default -> throw new IllegalArgumentException("Unexpected garbage type");
                }
            }
            garbage[i] = builder.toString();
        }
        this.travel = random.ints(
            len - 1L, 1, TIME + 1
        ).toArray();

        log.info("Garbage: {}", Arrays.toString(garbage));
        log.info("Travel: {}", Arrays.toString(travel));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 14651 ms
    @Override
    protected Integer original() {
        var original = new Original(garbage, travel);
        return original.process();
    }

    // time = 11107 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(garbage, travel);
        return practice.process();
    }

    // time = 4925 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(garbage, travel);
        return solution.process();
    }
}
