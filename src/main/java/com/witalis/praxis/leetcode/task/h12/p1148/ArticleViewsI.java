package com.witalis.praxis.leetcode.task.h12.p1148;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1141.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1148,
    description = "Article Views I",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class ArticleViewsI extends LeetCodeTask<String> {
    private List<String> views;

    public static final String INFORMATION = """

        Description:
            Table: Views
            +---------------+---------+
            | Column Name   | Type    |
            +---------------+---------+
            | article_id    | int     |
            | author_id     | int     |
            | viewer_id     | int     |
            | view_date     | date    |
            +---------------+---------+
            There is no primary key (column with unique values) for this table, the table may have duplicate rows.
            Each row of this table indicates that some viewer viewed an article (written by some author) on some date.
            Note that equal author_id and viewer_id indicate the same person.

            Write a solution to find all the authors that viewed at least one of their own articles.

            Return the result table sorted by id in ascending order.

            The result format is in the following example.

        Example:
            Input:
                Views table:
                +------------+-----------+-----------+------------+
                | article_id | author_id | viewer_id | view_date  |
                +------------+-----------+-----------+------------+
                | 1          | 3         | 5         | 2019-08-01 |
                | 1          | 3         | 6         | 2019-08-02 |
                | 2          | 7         | 7         | 2019-08-01 |
                | 2          | 7         | 6         | 2019-08-02 |
                | 4          | 7         | 1         | 2019-07-22 |
                | 3          | 4         | 4         | 2019-07-21 |
                | 3          | 4         | 4         | 2019-07-21 |
                +------------+-----------+-----------+------------+
            Output:
                +------+
                | id   |
                +------+
                | 4    |
                | 7    |
                +------+""";

    public ArticleViewsI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.views = Collections.emptyList();

        log.info("Views: {}", views);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1245 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 891 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 997 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
