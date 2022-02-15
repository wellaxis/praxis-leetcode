package com.witalis.praxis.leetcode.task.h2.p171;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p171.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 171,
    description = "Excel Sheet Column Number",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING}
)
public class ExcelSheetColumnNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 7;
    private String columnTitle;

    public static final String INFORMATION = """

        Given a string columnTitle that represents the column title
            as appear in an Excel sheet, return its corresponding column number.

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
            Input: columnTitle = "ZY"
            Output: 701""";

    public ExcelSheetColumnNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final String MAX_VALUE = "FXSHRXW";

        var random = ThreadLocalRandom.current();
        int length = random.nextInt(1, LEN + 1);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int letter = random.nextInt(65, 90 + 1);
            builder.append((char) letter);
        }

        this.columnTitle = builder.toString();
        if (columnTitle.compareTo(MAX_VALUE) > 0) columnTitle = MAX_VALUE;

        log.info("Column title is '{}'", columnTitle);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 746 ms
    @Override
    protected Integer original() {
        var original = new Original(columnTitle);
        return original.process();
    }

    // time = 399 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(columnTitle);
        return practice.process();
    }

    // time = 457 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(columnTitle);
        return solution.process();
    }
}
