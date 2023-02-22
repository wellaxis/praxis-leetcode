package com.witalis.praxis.leetcode.task.h11.p1011;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1011.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1011,
    description = "Capacity To Ship Packages Within D Days",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class CapacityToShipPackagesWithinDDays extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 500;

    private int[] weights;
    private int days;

    public static final String INFORMATION = """

        Description:
            A conveyor belt has packages that must be shipped from one port to another within days days.

            The ith package on the conveyor belt has a weight of weights[i].
                Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
                We may not load more weight than the maximum weight capacity of the ship.

            Return the least weight capacity of the ship that will result in all the packages
                 on the conveyor belt being shipped within days days.

        Example:
            Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
            Output: 15
            Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
                1st day: 1, 2, 3, 4, 5
                2nd day: 6, 7
                3rd day: 8
                4th day: 9
                5th day: 10
                
                Note that the cargo must be shipped in the order given, so using a ship of capacity 14
                and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.""";

    public CapacityToShipPackagesWithinDDays(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.weights = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.days = random.nextInt(1, weights.length);

        log.info("Weights: {}", Arrays.toString(weights));
        log.info("Days: {}", days);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7631 ms
    @Override
    protected Integer original() {
        var original = new Original(weights, days);
        return original.process();
    }

    // time = 3272 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(weights, days);
        return practice.process();
    }

    // time = 4710 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(weights, days);
        return solution.process();
    }
}
