package com.witalis.praxis.leetcode.task.h1.p57;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p57.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 57,
    description = "Insert Interval",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY}
)
public class InsertInterval extends LeetCodeTask<int[][]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;

    private int[][] intervals;
    private int[] newInterval;

    public static final String INFORMATION = """

        You are given an array of non-overlapping intervals 'intervals'
            where intervals[i] = [starti, endi] represent the start and the end
            of the ith interval and intervals is sorted in ascending order by starti.
            You are also given an interval newInterval = [start, end]
            that represents the start and end of another interval.

        Insert newInterval into intervals such that intervals is still sorted
            in ascending order by starti and intervals still does not have
            any overlapping intervals (merge overlapping intervals if necessary).

        Return intervals after the insertion.

        Example:
            Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
            Output: [[1,2],[3,10],[12,16]]
            Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].""";

    public InsertInterval(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.intervals = generateFlux();
        this.newInterval = generateMono(1);

        var builder = new StringBuilder();
        for (int[] interval: intervals) {
            builder.append(Arrays.toString(interval)).append(' ');
        }
        log.info("Intervals are {}", builder);
        log.info("New interval is {}", Arrays.toString(newInterval));
    }

    private int[][] generateFlux() {
        var random = ThreadLocalRandom.current();

        List<int[]> intervalsList = new ArrayList<>();

        int coefficient = random.nextInt(1, 1000);
        int counter = 0;
        int border = 0;
        while (counter < LEN && border < VALUE) {
            int[] interval = generateMono(coefficient);
            if (interval[0] + border > VALUE) {
                break;
            } else if (interval[1] + border > VALUE) {
                interval[1] = VALUE;
                break;
            }

            interval[0] += border;
            interval[1] += border;

            counter++;
            border = interval[1] + random.nextInt(1, 100);
            intervalsList.add(interval);
        }

        int[][] intervalsArray = new int[intervalsList.size()][];
        for (int i = 0; i < intervalsList.size(); i++) {
            intervalsArray[i] = intervalsList.get(i);
        }
        return intervalsArray;
    }

    private int[] generateMono(int coefficient) {
        var random = ThreadLocalRandom.current();

        var start = random.nextInt(0, (VALUE + 1) / coefficient);
        var end = random.nextInt(0, (VALUE + 1) / coefficient);
        return new int[] {Math.min(start, end), Math.max(start, end)};
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 584 ms
    @Override
    protected int[][] original() {
        var original = new Original(intervals.clone(), newInterval.clone());
        return original.process();
    }

    // time = 519 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(intervals.clone(), newInterval.clone());
        return practice.process();
    }

    // time = 1985 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(intervals.clone(), newInterval.clone());
        return solution.process();
    }
}
