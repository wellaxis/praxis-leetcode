package com.witalis.praxis.leetcode.task.h21.p2024;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h21.p2024.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2024,
    description = "Maximize the Confusion of an Exam",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, BINARY_SEARCH, SLIDING_WINDOW, PREFIX_SUM}
)
public class MaximizeConfusionOfExam extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;

    private String answerKey;
    private int times;

    public static final String INFORMATION = """

        Description:
            A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false.
                He wants to confuse the students by maximizing the number of consecutive questions with the same answer
                (multiple trues or multiple falses in a row).

            You are given a string answerKey, where answerKey[i] is the original answer to the ith question.
                In addition, you are given an integer k, the maximum number of times you may perform the following operation:
                * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').

            Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.

        Example:
            Input: answerKey = "TTFTTFTT", k = 1
            Output: 5
            Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
                Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT".\s
                In both cases, there are five consecutive 'T's.""";

    public MaximizeConfusionOfExam(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(random.nextBoolean() ? 'T' : 'F');
        }
        this.answerKey = builder.toString();
        this.times = random.nextInt(1, len + 1);

        log.info("Answer Key: '{}'", answerKey);
        log.info("Operation Times: {}", times);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4303 ms
    @Override
    protected Integer original() {
        var original = new Original(answerKey, times);
        return original.process();
    }

    // time = 2947 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(answerKey, times);
        return practice.process();
    }

    // time = 14147 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(answerKey, times);
        return solution.process();
    }
}
