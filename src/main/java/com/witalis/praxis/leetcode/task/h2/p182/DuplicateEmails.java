package com.witalis.praxis.leetcode.task.h2.p182;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p182.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 182,
    description = "Duplicate Emails",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class DuplicateEmails extends LeetCodeTask<String> {
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

        Write an SQL query to report all the duplicate emails.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Person table:
                +----+---------+
                | id | email   |
                +----+---------+
                | 1  | a@b.com |
                | 2  | c@d.com |
                | 3  | a@b.com |
                +----+---------+
            Output:
                +---------+
                | Email   |
                +---------+
                | a@b.com |
                +---------+
            Explanation: a@b.com is repeated two times.""";

    public DuplicateEmails(int id, String description, TaskRevision revision) {
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

    // time = 353 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 407 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 467 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
