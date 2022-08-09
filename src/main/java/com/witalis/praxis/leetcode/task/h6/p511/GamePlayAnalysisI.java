package com.witalis.praxis.leetcode.task.h6.p511;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p511.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 511,
    description = "Game Play Analysis I",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class GamePlayAnalysisI extends LeetCodeTask<String> {
    private List<String> players;

    public static final String INFORMATION = """

        Table: Activity
        +--------------+---------+
        | Column Name  | Type    |
        +--------------+---------+
        | player_id    | int     |
        | device_id    | int     |
        | event_date   | date    |
        | games_played | int     |
        +--------------+---------+
        (player_id, event_date) is the primary key of this table.
        This table shows the activity of players of some games.
        Each row is a record of a player who logged in and played a number of games
            (possibly 0) before logging out on someday using some device.

        Write an SQL query to report the first login date for each player.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Activity table:
                +-----------+-----------+------------+--------------+
                | player_id | device_id | event_date | games_played |
                +-----------+-----------+------------+--------------+
                | 1         | 2         | 2016-03-01 | 5            |
                | 1         | 2         | 2016-05-02 | 6            |
                | 2         | 3         | 2017-06-25 | 1            |
                | 3         | 1         | 2016-03-02 | 0            |
                | 3         | 4         | 2018-07-03 | 5            |
                +-----------+-----------+------------+--------------+
            Output:
                +-----------+-------------+
                | player_id | first_login |
                +-----------+-------------+
                | 1         | 2016-03-01  |
                | 2         | 2017-06-25  |
                | 3         | 2016-03-02  |
                +-----------+-------------+""";

    public GamePlayAnalysisI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.players = Collections.emptyList();

        log.info("Players are {}", players);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 651 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 585 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 705 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
