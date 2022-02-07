package com.witalis.praxis.leetcode.task.h2.p196;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p196.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.DATABASE;

@Slf4j
@LeetCode(
    id = 196,
    description = "Delete Duplicate Emails",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class DeleteDuplicateEmails extends LeetCodeTask<String> {
    private List<String> persons;

    public static final String INFORMATION = """

        Table: Person
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | email       | varchar |
        +-------------+---------+
        id is the primary key column for this table.
        Each row of this table contains an email.
        The emails will not contain uppercase letters.

        Write an SQL query to delete all the duplicate emails,
            keeping only one unique email with the smallest id.
            Note that you are supposed to write a DELETE statement
            and not a SELECT one.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Person table:
                +----+------------------+
                | id | email            |
                +----+------------------+
                | 1  | john@example.com |
                | 2  | bob@example.com  |
                | 3  | john@example.com |
                +----+------------------+
            Output:
                +----+------------------+
                | id | email            |
                +----+------------------+
                | 1  | john@example.com |
                | 2  | bob@example.com  |
                +----+------------------+
            Explanation:
                john@example.com is repeated two times.
                We keep the row with the smallest Id = 1.""";

    public DeleteDuplicateEmails(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.persons = Collections.emptyList();

        log.info("Persons are {}", persons);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 420 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 293 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 302 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
