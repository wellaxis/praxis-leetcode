package com.witalis.praxis.leetcode.task.h2.p168;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p168.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 168,
    description = "Excel Sheet Column Title",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING}
)
public class ExcelSheetColumnTitle extends LeetCodeTask<String> {
    private int columnNumber;

    public static final String INFORMATION = """

        Given an integer columnNumber, return its corresponding
            column title as it appears in an Excel sheet.

        For example:
            A -> 1
            B -> 2
            C -> 3
            ...
            Z -> 26
            AA -> 27
            AB -> 28
            ...

        Example:
            Input: columnNumber = 701
            Output: "ZY" """;

    public ExcelSheetColumnTitle(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.columnNumber = ThreadLocalRandom.current()
            .nextInt(1, Integer.MAX_VALUE);

        log.info("Column number is '{}'", columnNumber);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 782 ms
    @Override
    protected String original() {
        var original = new Original(columnNumber);
        return original.process();
    }

    // time = 433 ms
    @Override
    protected String practice() {
        var practice = new Practice(columnNumber);
        return practice.process();
    }

    // time = 429 ms
    @Override
    protected String solution() {
        var solution = new Solution(columnNumber);
        return solution.process();
    }
}
