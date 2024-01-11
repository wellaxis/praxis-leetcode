package com.witalis.praxis.leetcode.task.h12.p1179;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1179.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1179,
    description = "Reformat Department Table",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class ReformatDepartmentTable extends LeetCodeTask<String> {
    private List<String> departments;

    public static final String INFORMATION = """

        Description:
            Table: Department
            +-------------+---------+
            | Column Name | Type    |
            +-------------+---------+
            | id          | int     |
            | revenue     | int     |
            | month       | varchar |
            +-------------+---------+
            In SQL,(id, month) is the primary key of this table.
            The table has information about the revenue of each department per month.
            The month has values in ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"].

            Reformat the table such that there is a department id column and a revenue column for each month.

            Return the result table in any order.

            The result format is in the following example.

        Example:
            Input:
                Department table:
                +------+---------+-------+
                | id   | revenue | month |
                +------+---------+-------+
                | 1    | 8000    | Jan   |
                | 2    | 9000    | Jan   |
                | 3    | 10000   | Feb   |
                | 1    | 7000    | Feb   |
                | 1    | 6000    | Mar   |
                +------+---------+-------+
            Output:
                +------+-------------+-------------+-------------+-----+-------------+
                | id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
                +------+-------------+-------------+-------------+-----+-------------+
                | 1    | 8000        | 7000        | 6000        | ... | null        |
                | 2    | 9000        | null        | null        | ... | null        |
                | 3    | null        | 10000       | null        | ... | null        |
                +------+-------------+-------------+-------------+-----+-------------+
            Explanation: The revenue from Apr to Dec is null.
                Note that the result table has 13 columns (1 for the department id + 12 for the months).""";

    public ReformatDepartmentTable(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.departments = Collections.emptyList();

        log.info("Departments: {}", departments);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1527 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 1495 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 1087 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
