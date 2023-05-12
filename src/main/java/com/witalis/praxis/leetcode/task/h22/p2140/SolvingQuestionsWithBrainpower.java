package com.witalis.praxis.leetcode.task.h22.p2140;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2140.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2140,
    description = "Solving Questions With Brainpower",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class SolvingQuestionsWithBrainpower extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[][] questions;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed 2D integer array questions where questions[i] = [points[i], brainpower[i]].

            The array describes the questions of an exam, where you have to process the questions in order
                (i.e., starting from question 0) and make a decision whether to solve or skip each question.
                Solving question i will earn you points[i] points but you will be unable to solve each of the next brainpower[i] questions.
                If you skip question i, you get to make the decision on the next question.

            For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
                * If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
                * If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.

            Return the maximum points you can earn for the exam.

        Example:
            Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
            Output: 7
            Explanation: The maximum points can be earned by solving questions 1 and 4.
                - Skip question 0
                - Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
                - Unable to solve questions 2 and 3
                - Solve question 4: Earn 5 points
                Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.""";

    public SolvingQuestionsWithBrainpower(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.questions = new int[len][2];
        for (int i = 0; i < len; i++) {
            questions[i] = new int[] {
                random.nextInt(1, VALUE + 1),
                random.nextInt(1, VALUE + 1)
            };
        }

        log.info("Questions: {}", Arrays.deepToString(questions));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5525 ms
    @Override
    protected Long original() {
        var original = new Original(questions);
        return original.process();
    }

    // time = 2670 ms
    @Override
    protected Long practice() {
        var practice = new Practice(questions);
        return practice.process();
    }

    // time = 1426 ms
    @Override
    protected Long solution() {
        var solution = new Solution(questions);
        return solution.process();
    }
}
