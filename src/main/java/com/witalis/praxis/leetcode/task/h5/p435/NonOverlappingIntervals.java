package com.witalis.praxis.leetcode.task.h5.p435;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p435.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 435,
    description = "Non-overlapping Intervals",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GREEDY, SORTING}
)
public class NonOverlappingIntervals extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 50_000;

    private int[][] intervals;

    public static final String INFORMATION = """

        Description:
            Given an array of intervals intervals where intervals[i] = [starti, endi],
                return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

        Example:
            Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
            Output: 1
            Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.""";

    public NonOverlappingIntervals(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.intervals = new int[len][2];
        for (int i = 0; i < len; i++) {
            int start = random.nextInt(-VALUE, VALUE + 1);
            int end = random.nextInt(-VALUE, VALUE + 1);
            intervals[i] = new int[] {
                Math.min(start, end),
                Math.max(start, end)
            };
        }

        log.info("Intervals: {}", Arrays.deepToString(intervals));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 22741 ms
    @Override
    protected Integer original() {
        var original = new Original(intervals.clone());
        return original.process();
    }

    // time = 21596 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(intervals.clone());
        return practice.process();
    }

    // time = 23732 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(intervals.clone());
        return solution.process();
    }
}
