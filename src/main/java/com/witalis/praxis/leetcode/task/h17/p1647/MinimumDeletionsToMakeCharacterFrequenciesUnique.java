package com.witalis.praxis.leetcode.task.h17.p1647;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1647.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1647,
    description = "Minimum Deletions to Make Character Frequencies Unique",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, GREEDY, SORTING}
)
public class MinimumDeletionsToMakeCharacterFrequenciesUnique extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            A string s is called good if there are no two different characters in s that have the same frequency.

            Given a string s, return the minimum number of characters you need to delete to make s good.

            The frequency of a character in a string is the number of times it appears in the string.
                For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

        Example:
            Input: s = "aaabbbcc"
            Output: 2
            Explanation: You can delete two 'b's resulting in the good string "aaabcc".
                Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".""";

    public MinimumDeletionsToMakeCharacterFrequenciesUnique(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String s: '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 25291 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 3645 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 3532 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
