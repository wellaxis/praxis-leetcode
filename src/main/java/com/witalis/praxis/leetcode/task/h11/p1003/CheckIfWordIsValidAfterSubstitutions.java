package com.witalis.praxis.leetcode.task.h11.p1003;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1003.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1003,
    description = "Check If Word Is Valid After Substitutions",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, STACK}
)
public class CheckIfWordIsValidAfterSubstitutions extends LeetCodeTask<Boolean> {
    public static final int LEN = 20_000;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, determine if it is valid.

            A string s is valid if, starting with an empty string t = "", you can transform t into s
                after performing the following operation any number of times:
                * Insert string "abc" into any position in t.
                  More formally, t becomes tleft + "abc" + tright,
                  where t == tleft + tright.
                  Note that tleft and tright may be empty.

            Return true if s is a valid string, otherwise, return false.

        Example:
            Input: s = "abcabcababcc"
            Output: true
            Explanation:
                "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
                Thus, "abcabcababcc" is valid.""";

    public CheckIfWordIsValidAfterSubstitutions(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < len; i++) {
            int offset = i == 0 ? 0 : random.nextInt(0, builder.length() - 1);
            builder.insert(offset, "abc");
        }
        this.string = builder.substring(0);

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 642 ms
    @Override
    protected Boolean original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 831 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1477 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
