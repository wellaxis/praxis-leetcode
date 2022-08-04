package com.witalis.praxis.leetcode.task.h2.p178;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p178.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 178,
    description = "Rank Scores",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DATABASE}
)
public class RankScores extends LeetCodeTask<String> {
    private List<String> scores;

    public static final String INFORMATION = """

        Table: Scores
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | score       | decimal |
        +-------------+---------+
        id is the primary key for this table.
            Each row of this table contains the score of a game.
            Score is a floating point value with two decimal places.

        Write an SQL query to rank the scores. The ranking should be calculated according to the following rules:
            * The scores should be ranked from the highest to the lowest.
            * If there is a tie between two scores, both should have the same ranking.
            * After a tie, the next ranking number should be the next consecutive integer value.
              In other words, there should be no holes between ranks.

        Return the result table ordered by score in descending order.

        The query result format is in the following example.

        Example:
            Input:
            Scores table:
                +----+-------+
                | id | score |
                +----+-------+
                | 1  | 3.50  |
                | 2  | 3.65  |
                | 3  | 4.00  |
                | 4  | 3.85  |
                | 5  | 4.00  |
                | 6  | 3.65  |
                +----+-------+
            Output:
                +-------+------+
                | score | rank |
                +-------+------+
                | 4.00  | 1    |
                | 4.00  | 1    |
                | 3.85  | 2    |
                | 3.65  | 3    |
                | 3.65  | 3    |
                | 3.50  | 4    |
                +-------+------+""";

    public RankScores(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.scores = Collections.emptyList();

        log.info("Scores are {}", scores);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 553 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 427 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 557 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
