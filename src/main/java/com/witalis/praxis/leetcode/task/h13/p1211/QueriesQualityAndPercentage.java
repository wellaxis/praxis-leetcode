package com.witalis.praxis.leetcode.task.h13.p1211;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1211.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1211,
    description = "Queries Quality and Percentage",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class QueriesQualityAndPercentage extends LeetCodeTask<String> {
    private List<String> queries;

    public static final String INFORMATION = """

        Description:
            Table: Queries
            +-------------+---------+
            | Column Name | Type    |
            +-------------+---------+
            | query_name  | varchar |
            | result      | varchar |
            | position    | int     |
            | rating      | int     |
            +-------------+---------+
            This table may have duplicate rows.
            This table contains information collected from some queries on a database.
            The position column has a value from 1 to 500.
            The rating column has a value from 1 to 5. Query with rating less than 3 is a poor query.

            We define query quality as:
                * The average of the ratio between query rating and its position.

            We also define poor query percentage as:
                * The percentage of all queries with rating less than 3.

            Write a solution to find each query_name, the quality and poor_query_percentage.

            Both quality and poor_query_percentage should be rounded to 2 decimal places.

            Return the result table in any order.

            The result format is in the following example.

        Example:
            Input:
                Queries table:
                +------------+-------------------+----------+--------+
                | query_name | result            | position | rating |
                +------------+-------------------+----------+--------+
                | Dog        | Golden Retriever  | 1        | 5      |
                | Dog        | German Shepherd   | 2        | 5      |
                | Dog        | Mule              | 200      | 1      |
                | Cat        | Shirazi           | 5        | 2      |
                | Cat        | Siamese           | 3        | 3      |
                | Cat        | Sphynx            | 7        | 4      |
                +------------+-------------------+----------+--------+
            Output:
                +------------+---------+-----------------------+
                | query_name | quality | poor_query_percentage |
                +------------+---------+-----------------------+
                | Dog        | 2.50    | 33.33                 |
                | Cat        | 0.66    | 33.33                 |
                +------------+---------+-----------------------+
            Explanation:
                Dog queries quality is ((5 / 1) + (5 / 2) + (1 / 200)) / 3 = 2.50
                Dog queries poor_ query_percentage is (1 / 3) * 100 = 33.33
                Cat queries quality equals ((2 / 5) + (3 / 3) + (4 / 7)) / 3 = 0.66
                Cat queries poor_ query_percentage is (1 / 3) * 100 = 33.33""";

    public QueriesQualityAndPercentage(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.queries = Collections.emptyList();

        log.info("Queries: {}", queries);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1441 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 874 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 1034 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
