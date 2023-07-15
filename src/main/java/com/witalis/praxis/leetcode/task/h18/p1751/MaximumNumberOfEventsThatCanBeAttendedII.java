package com.witalis.praxis.leetcode.task.h18.p1751;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1751.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1751,
    description = "Maximum Number of Events That Can Be Attended II",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, DYNAMIC_PROGRAMMING, SORTING}
)
public class MaximumNumberOfEventsThatCanBeAttendedII extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000_000;

    private int[][] events;
    private int attendance;

    public static final String INFORMATION = """

        Description:
            You are given an array of events where events[i] = [startDayi, endDayi, valuei].
                The ith event starts at startDayi and ends at endDayi, and if you attend this event,
                you will receive a value of valuei. You are also given an integer k
                which represents the maximum number of events you can attend.

            You can only attend one event at a time. If you choose to attend an event, you must attend the entire event.
                Note that the end day is inclusive: that is, you cannot attend two events
                where one of them starts and the other ends on the same day.

            Return the maximum sum of values that you can receive by attending events.

        Example:
            Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
            Output: 7
            Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.""";

    public MaximumNumberOfEventsThatCanBeAttendedII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.events = new int[len][3];
        for (int i = 0; i < len; i++) {
            int day1 = random.nextInt(1, VALUE + 1);
            int day2 = random.nextInt(1, VALUE + 1);
            events[i] = new int[] {
                Math.min(day1, day2),
                Math.max(day1, day2),
                random.nextInt(1, VALUE + 1)
            };
        }
        this.attendance = random.nextInt(1, len + 1);

        log.info("Events: {}", Arrays.deepToString(events));
        log.info("Attendance K: {}", attendance);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 276171 ms
    @Override
    protected Integer original() {
        var original = new Original(events.clone(), attendance);
        return original.process();
    }

    // time = 241390 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(events.clone(), attendance);
        return practice.process();
    }

    // time = 7478 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(events.clone(), attendance);
        return solution.process();
    }
}
