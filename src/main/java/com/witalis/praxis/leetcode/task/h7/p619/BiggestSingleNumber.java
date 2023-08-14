package com.witalis.praxis.leetcode.task.h7.p619;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p619.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.DATABASE;

@Slf4j
@LeetCode(
    id = 619,
    description = "Biggest Single Number",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class BiggestSingleNumber extends LeetCodeTask<String> {
    private List<String> numbers;

    public static final String INFORMATION = """

        Description:
            Table: MyNumbers
            +-------------+------+
            | Column Name | Type |
            +-------------+------+
            | num         | int  |
            +-------------+------+

            This table may contain duplicates (In other words, there is no primary key for this table in SQL).
                Each row of this table contains an integer.

            A single number is a number that appeared only once in the MyNumbers table.

            Find the largest single number. If there is no single number, report null.

            The result format is in the following example.

        Example:
            Input:
                MyNumbers table:
                +-----+
                | num |
                +-----+
                | 8   |
                | 8   |
                | 3   |
                | 3   |
                | 1   |
                | 4   |
                | 5   |
                | 6   |
                +-----+
            Output:
                +-----+
                | num |
                +-----+
                | 6   |
                +-----+
            Explanation: The single numbers are 1, 4, 5, and 6.
                Since 6 is the largest single number, we return it.""";

    public BiggestSingleNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = Collections.emptyList();

        log.info("Numbers: {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1037 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 921 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 1098 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
