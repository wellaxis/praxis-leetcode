package com.witalis.praxis.leetcode.task.h16.p1507;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1507.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1507,
    description = "Reformat Date",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class ReformatDate extends LeetCodeTask<String> {
    public static final  String[] DAYS = new String[] {
        "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th",
        "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"
    };
    public static final  String[] MONTHS = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final int YEAR_START = 1900;
    public static final int YEAR_END = 2100;

    private String date;

    public static final String INFORMATION = """

        Description:
            Given a date string in the form Day Month Year, where:
                * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
                * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
                * Year is in the range [1900, 2100].

            Convert the date string to the format YYYY-MM-DD, where:
                * YYYY denotes the 4 digit year.
                * MM denotes the 2 digit month.
                * DD denotes the 2 digit day.

        Example:
            Input: date = "26th May 1960"
            Output: "1960-05-26" """;

    public ReformatDate(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final var builder = new StringBuilder();

        builder.append(DAYS[random.nextInt(0, DAYS.length)]);
        builder.append(' ');
        builder.append(MONTHS[random.nextInt(0, MONTHS.length)]);
        builder.append(' ');
        builder.append(random.nextInt(YEAR_START, YEAR_END + 1));

        this.date = builder.toString();

        log.info("Date: '{}'", date);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 688 ms
    @Override
    protected String original() {
        var original = new Original(date);
        return original.process();
    }

    // time = 556 ms
    @Override
    protected String practice() {
        var practice = new Practice(date);
        return practice.process();
    }

    // time = 492 ms
    @Override
    protected String solution() {
        var solution = new Solution(date);
        return solution.process();
    }
}
