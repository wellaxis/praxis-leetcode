package com.witalis.praxis.leetcode.task.h10.p920;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p920.option.Original;
import com.witalis.praxis.leetcode.task.h10.p920.option.Practice;
import com.witalis.praxis.leetcode.task.h10.p920.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 920,
    description = "Number of Music Playlists",
    difficulty = TaskDifficulty.HARD,
    tags = {MATH, DYNAMIC_PROGRAMMING, COMBINATORICS}
)
public class NumberOfMusicPlaylists extends LeetCodeTask<Integer> {
    public static final int VALUE = 100;

    private int songs;
    private int goal;
    private int gap;

    public static final String INFORMATION = """

        Description:
            Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during your trip.
                To avoid boredom, you will create a playlist so that:
                * Every song is played at least once.
                * A song can only be played again only if k other songs have been played.

            Given n, goal, and k, return the number of possible playlists that you can create.
                Since the answer can be very large, return it modulo 109 + 7.

        Example:
            Input: n = 3, goal = 3, k = 1
            Output: 6
            Explanation: There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].""";

    public NumberOfMusicPlaylists(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.goal = random.nextInt(0, VALUE + 1);
        this.songs = random.nextInt(0, goal + 1);
        this.gap = random.nextInt(0, songs);

        log.info("Songs n: {}", songs);
        log.info("Goal: {}", goal);
        log.info("Gap k: {}", gap);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1228 ms
    @Override
    protected Integer original() {
        var original = new Original(songs, goal, gap);
        return original.process();
    }

    // time = 1053 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(songs, goal, gap);
        return practice.process();
    }

    // time = 553 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(songs, goal, gap);
        return solution.process();
    }
}
