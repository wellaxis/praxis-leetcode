package com.witalis.praxis.leetcode.task.h14.p1312;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1312.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1312,
    description = "Minimum Insertion Steps to Make a String Palindrome",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class MinimumInsertionStepsToMakeStringPalindrome extends LeetCodeTask<Integer> {
    public static final int LEN = 500;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s. In one step you can insert any character at any index of the string.

            Return the minimum number of steps to make s palindrome.

            A Palindrome String is one that reads the same backward as well as forward.

        Example:
            Input: s = "leetcode"
            Output: 5
            Explanation: Inserting 5 characters the string becomes "leetcodocteel".""";

    public MinimumInsertionStepsToMakeStringPalindrome(int id, String description, TaskRevision revision) {
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

    // time = 3737 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 2940 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 2568 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
