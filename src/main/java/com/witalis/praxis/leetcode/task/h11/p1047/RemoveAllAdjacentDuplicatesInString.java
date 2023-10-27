package com.witalis.praxis.leetcode.task.h11.p1047;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1047.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1047,
    description = "Remove All Adjacent Duplicates In String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, STACK}
)
public class RemoveAllAdjacentDuplicatesInString extends LeetCodeTask<String> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            You are given a string s consisting of lowercase English letters.
                A duplicate removal consists of choosing two adjacent and equal letters and removing them.

            We repeatedly make duplicate removals on s until we no longer can.

            Return the final string after all such duplicate removals have been made.
                It can be proven that the answer is unique.

        Example:
            Input: s = "abbaca"
            Output: "ca"
            Explanation:
                For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
                The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".""";

    public RemoveAllAdjacentDuplicatesInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 17726 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 14530 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1966 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
