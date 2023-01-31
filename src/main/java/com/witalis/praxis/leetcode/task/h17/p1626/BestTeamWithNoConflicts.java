package com.witalis.praxis.leetcode.task.h17.p1626;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1626.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1626,
    description = "Best Team With No Conflicts",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, SORTING}
)
public class BestTeamWithNoConflicts extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int SCORE = 1_000_000;
    public static final int AGE = 1_000;

    private int[] scores;
    private int[] ages;

    public static final String INFORMATION = """

        Description:
            You are the manager of a basketball team. For the upcoming tournament,
                you want to choose the team with the highest overall score.
                The score of the team is the sum of scores of all the players in the team.

            However, the basketball team is not allowed to have conflicts.
                A conflict exists if a younger player has a strictly higher score than an older player.
                A conflict does not occur between players of the same age.

            Given two lists, scores and ages, where each scores[i] and ages[i] represents
                the score and age of the ith player, respectively,
                return the highest overall score of all possible basketball teams.

        Example:
            Input: scores = [4,5,6,5], ages = [2,1,2,1]
            Output: 16
            Explanation: It is best to choose the last 3 players.
                Notice that you are allowed to choose multiple people of the same age.""";

    public BestTeamWithNoConflicts(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.scores = random.ints(len, 1, SCORE + 1).toArray();
        this.ages = random.ints(len, 1, AGE + 1).toArray();

        log.info("Scores: {}", Arrays.toString(scores));
        log.info("Ages: {}", Arrays.toString(ages));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1158 ms
    @Override
    protected Integer original() {
        var original = new Original(scores, ages);
        return original.process();
    }

    // time = 1016 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(scores, ages);
        return practice.process();
    }

    // time = 1036 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(scores, ages);
        return solution.process();
    }
}
