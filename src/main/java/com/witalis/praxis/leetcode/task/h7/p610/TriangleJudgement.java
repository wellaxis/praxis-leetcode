package com.witalis.praxis.leetcode.task.h7.p610;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p610.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 610,
    description = "Triangle Judgement",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class TriangleJudgement extends LeetCodeTask<String> {
    private List<String> triangles;

    public static final String INFORMATION = """

        Description:
            Table: Triangle
            +-------------+------+
            | Column Name | Type |
            +-------------+------+
            | x           | int  |
            | y           | int  |
            | z           | int  |
            +-------------+------+
            (x, y, z) is the primary key column for this table.
            Each row of this table contains the lengths of three line segments.

            Write an SQL query to report for every three line segments whether they can form a triangle.

            Return the result table in any order.

            The query result format is in the following example.

        Example:
            Input:
                Triangle table:
                +----+----+----+
                | x  | y  | z  |
                +----+----+----+
                | 13 | 15 | 30 |
                | 10 | 20 | 15 |
                +----+----+----+
            Output:
                +----+----+----+----------+
                | x  | y  | z  | triangle |
                +----+----+----+----------+
                | 13 | 15 | 30 | No       |
                | 10 | 20 | 15 | Yes      |
                +----+----+----+----------+""";

    public TriangleJudgement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.triangles = Collections.emptyList();

        log.info("Triangles: {}", triangles);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 753 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 695 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 732 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
