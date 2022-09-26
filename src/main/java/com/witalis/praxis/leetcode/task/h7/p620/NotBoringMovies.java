package com.witalis.praxis.leetcode.task.h7.p620;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p620.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 620,
    description = "Not Boring Movies",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class NotBoringMovies extends LeetCodeTask<String> {
    private List<String> movies;

    public static final String INFORMATION = """

        Table: Cinema
        +----------------+----------+
        | Column Name    | Type     |
        +----------------+----------+
        | id             | int      |
        | movie          | varchar  |
        | description    | varchar  |
        | rating         | float    |
        +----------------+----------+
        id is the primary key for this table.
        Each row contains information about the name of a movie, its genre, and its rating.
        rating is a 2 decimal places float in the range [0, 10]

        Write an SQL query to report the movies with an odd-numbered ID and a description that is not "boring".

        Return the result table ordered by rating in descending order.

        The query result format is in the following example.

        Example:
            Input:
                Cinema table:
                +----+------------+-------------+--------+
                | id | movie      | description | rating |
                +----+------------+-------------+--------+
                | 1  | War        | great 3D    | 8.9    |
                | 2  | Science    | fiction     | 8.5    |
                | 3  | irish      | boring      | 6.2    |
                | 4  | Ice song   | Fantacy     | 8.6    |
                | 5  | House card | Interesting | 9.1    |
                +----+------------+-------------+--------+
            Output:
                +----+------------+-------------+--------+
                | id | movie      | description | rating |
                +----+------------+-------------+--------+
                | 5  | House card | Interesting | 9.1    |
                | 1  | War        | great 3D    | 8.9    |
                +----+------------+-------------+--------+
            Explanation:
                We have three movies with odd-numbered IDs: 1, 3, and 5.
                The movie with ID = 3 is boring so we do not include it in the answer.""";

    public NotBoringMovies(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.movies = Collections.emptyList();

        log.info("Movies are {}", movies);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 726 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 560 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 501 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
