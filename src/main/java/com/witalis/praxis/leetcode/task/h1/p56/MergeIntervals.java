package com.witalis.praxis.leetcode.task.h1.p56;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p56.option.*;
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
    id = 56,
    description = "Merge Intervals",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SORTING}
)
public class MergeIntervals extends LeetCodeTask<int[][]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[][] intervals;

    public static final String INFORMATION = """

        Given an array of intervals where intervals[i] = [starti, endi],
            merge all overlapping intervals, and return an array
            of the non-overlapping intervals that cover all the intervals in the input.

        Example:
            Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
            Output: [[1,6],[8,10],[15,18]]
            Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].""";

    public MergeIntervals(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.intervals = generate();

        var builder = new StringBuilder();
        for (int[] interval: intervals) {
            builder.append(Arrays.toString(interval)).append(' ');
        }
        log.info("Intervals are {}", builder);
    }

    private int[][] generate() {
        var random = ThreadLocalRandom.current();

        List<int[]> intervalsList = new ArrayList<>();

        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            var start = random.nextInt(0, VALUE + 1);
            var end = random.nextInt(0, VALUE + 1);
            intervalsList.add(new int[] {Math.min(start, end), Math.max(start, end)});
        }

        int[][] intervalsArray = new int[intervalsList.size()][];
        for (int i = 0; i < intervalsList.size(); i++) {
            intervalsArray[i] = intervalsList.get(i);
        }
        return intervalsArray;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2984 ms
    @Override
    protected int[][] original() {
        var original = new Original(intervals.clone());
        return original.process();
    }

    // time = 1862 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(intervals.clone());
        return practice.process();
    }

    // time = 1737 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(intervals.clone());
        return solution.process();
    }
}
