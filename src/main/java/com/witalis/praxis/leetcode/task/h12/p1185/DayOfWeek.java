package com.witalis.praxis.leetcode.task.h12.p1185;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1185.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1185,
    description = "Day of the Week",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class DayOfWeek extends LeetCodeTask<String> {
    public static final int MIN_YEAR = 1971;
    public static final int MAX_YEAR = 2100;

    private int day;
    private int month;
    private int year;

    public static final String INFORMATION = """

        Description:
            Given a date, return the corresponding day of the week for that date.

            The input is given as three integers representing the day, month and year respectively.

            Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

        Example:
            Input: day = 31, month = 8, year = 2019
            Output: "Saturday" """;

    public DayOfWeek(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.day = random.nextInt(1, 29);
        this.month = random.nextInt(1, 13);
        this.year = random.nextInt(MIN_YEAR, MAX_YEAR + 1);

        log.info("Day: {}", day);
        log.info("Month: {}", month);
        log.info("Year: {}", year);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 499 ms
    @Override
    protected String original() {
        var original = new Original(day, month, year);
        return original.process();
    }

    // time = 489 ms
    @Override
    protected String practice() {
        var practice = new Practice(day, month, year);
        return practice.process();
    }

    // time = 480 ms
    @Override
    protected String solution() {
        var solution = new Solution(day, month, year);
        return solution.process();
    }
}
