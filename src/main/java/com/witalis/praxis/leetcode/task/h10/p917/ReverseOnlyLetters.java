package com.witalis.praxis.leetcode.task.h10.p917;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p917.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 917,
    description = "Reverse Only Letters",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, TWO_POINTERS}
)
public class ReverseOnlyLetters extends LeetCodeTask<String> {
    public static final int LEN = 100;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, reverse the string according to the following rules:
                * All the characters that are not English letters remain in the same position.
                * All the English letters (lowercase or uppercase) should be reversed.

            Return s after reversing it.

        Example:
            Input: s = "Test1ng-Leet=code-Q!"
            Output: "Qedo1ct-eeLg=ntse-T!".""";

    public ReverseOnlyLetters(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt(33, 123));
        }
        this.string = builder.toString();

        log.info("String 's': {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 564 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 521 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 484 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
