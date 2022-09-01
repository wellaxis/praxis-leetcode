package com.witalis.praxis.leetcode.task.h6.p596;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p596.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 596,
    description = "Classes More Than 5 Students",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class ClassesMoreThan5Students extends LeetCodeTask<String> {
    private List<String> courses;

    public static final String INFORMATION = """

        Table: World
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | student     | varchar |
        | class       | varchar |
        +-------------+---------+
        (student, class) is the primary key column for this table.
        Each row of this table indicates the name of a student and the class in which they are enrolled.

        Write an SQL query to report all the classes that have at least five students.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Courses table:
                +---------+----------+
                | student | class    |
                +---------+----------+
                | A       | Math     |
                | B       | English  |
                | C       | Math     |
                | D       | Biology  |
                | E       | Math     |
                | F       | Computer |
                | G       | Math     |
                | H       | Math     |
                | I       | Math     |
                +---------+----------+
            Output:
                +---------+
                | class   |
                +---------+
                | Math    |
                +---------+
            Explanation:
                - Math has 6 students, so we include it.
                - English has 1 student, so we do not include it.
                - Biology has 1 student, so we do not include it.
                - Computer has 1 student, so we do not include it.""";

    public ClassesMoreThan5Students(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.courses = Collections.emptyList();

        log.info("Courses are {}", courses);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 504 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 524 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 495 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
