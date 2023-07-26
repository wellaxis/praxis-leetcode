package com.witalis.praxis.leetcode.task.h19.p1870;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1870.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1870,
    description = "Minimum Speed to Arrive on Time",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class MinimumSpeedToArriveOnTime extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] distances;
    private double hours;

    public static final String INFORMATION = """

        Description:
            You are given a floating-point number hour, representing the amount of time you have to reach the office.
                To commute to the office, you must take n trains in sequential order.
                You are also given an integer array dist of length n,
                where dist[i] describes the distance (in kilometers) of the ith train ride.

            Each train can only depart at an integer hour, so you may need to wait in between each train ride.
                * For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours
                  before you can depart on the 2nd train ride at the 2 hour mark.

            Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel
                at for you to reach the office on time, or -1 if it is impossible to be on time.

            Tests are generated such that the answer will not exceed 10^7
                and hour will have at most two digits after the decimal point.

        Example:
            Input: dist = [1,3,2], hour = 2.7
            Output: 3
            Explanation: At speed 3:
                - The first train ride takes 1/3 = 0.33333 hours.
                - Since we are not at an integer hour, we wait until the 1 hour mark to depart. The second train ride takes 3/3 = 1 hour.
                - Since we are already at an integer hour, we depart immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours.
                - You will arrive at the 2.66667 hour mark.""";

    public MinimumSpeedToArriveOnTime(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.distances = random.ints(
            random.nextInt(1, LEN + 1),
            1, LEN + 1
        ).toArray();
        this.hours = random.nextDouble(1D, VALUE + 1D);

        log.info("Distances: {}", Arrays.toString(distances));
        log.info("Hours: {}", hours);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7175 ms
    @Override
    protected Integer original() {
        var original = new Original(distances.clone(), hours);
        return original.process();
    }

    // time = 6903 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(distances.clone(), hours);
        return practice.process();
    }

    // time = 3402 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(distances.clone(), hours);
        return solution.process();
    }
}
