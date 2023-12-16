package com.witalis.praxis.leetcode.task.h12.p1154;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1154.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1154,
    description = "Day of the Year",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING}
)
public class DayOfYear extends LeetCodeTask<Integer> {
    public static final int LEN = 10;

    private String date;

    public static final String INFORMATION = """

        Description:
            Given a string date representing a Gregorian calendar date
                formatted as YYYY-MM-DD, return the day number of the year.

        Example:
            Input: date = "2019-01-09"
            Output: 9
            Explanation: Given date is the 9th day of the year in 2019.""";

    public DayOfYear(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int year = random.nextInt(1, 10_000);
        int month = random.nextInt(1, 13);
        int day = random.nextInt(1, 29);

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%04d", year));
        builder.append("-");
        builder.append(String.format("%02d", month));
        builder.append("-");
        builder.append(String.format("%02d", day));
        this.date = builder.toString();

        log.info("Date: {}", date);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 585 ms
    @Override
    protected Integer original() {
        var original = new Original(date);
        return original.process();
    }

    // time = 600 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(date);
        return practice.process();
    }

    // time = 506 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(date);
        return solution.process();
    }
}
