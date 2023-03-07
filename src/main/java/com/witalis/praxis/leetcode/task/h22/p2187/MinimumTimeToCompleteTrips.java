package com.witalis.praxis.leetcode.task.h22.p2187;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2187.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2187,
    description = "Minimum Time to Complete Trips",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class MinimumTimeToCompleteTrips extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = (int) 10e7;

    private int[] time;
    private int totalTrips;

    public static final String INFORMATION = """

        Description:
            You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

            Each bus can make multiple trips successively;
                that is, the next trip can start immediately after completing the current trip.
            Also, each bus operates independently;
                that is, the trips of one bus do not influence the trips of any other bus.

            You are also given an integer totalTrips, which denotes the number of trips all buses should make in total.
                Return the minimum time required for all buses to complete at least totalTrips trips.

        Example:
            Input: time = [1,2,3], totalTrips = 5
            Output: 3
            Explanation:
                - At time t = 1, the number of trips completed by each bus are [1,0,0].
                  The total number of trips completed is 1 + 0 + 0 = 1.
                - At time t = 2, the number of trips completed by each bus are [2,1,0].
                  The total number of trips completed is 2 + 1 + 0 = 3.
                - At time t = 3, the number of trips completed by each bus are [3,1,1].
                  The total number of trips completed is 3 + 1 + 1 = 5.
                So the minimum time needed for all buses to complete at least 5 trips is 3.""";

    public MinimumTimeToCompleteTrips(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.time = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.totalTrips = random.nextInt(1, VALUE + 1);

        log.info("Time: {}", Arrays.toString(time));
        log.info("Total trips: {}", totalTrips);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8222 ms
    @Override
    protected Long original() {
        var original = new Original(time, totalTrips);
        return original.process();
    }

    // time = 7996 ms
    @Override
    protected Long practice() {
        var practice = new Practice(time, totalTrips);
        return practice.process();
    }

    // time = 7506 ms
    @Override
    protected Long solution() {
        var solution = new Solution(time, totalTrips);
        return solution.process();
    }
}
