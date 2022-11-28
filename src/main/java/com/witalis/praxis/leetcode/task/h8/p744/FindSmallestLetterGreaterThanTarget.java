package com.witalis.praxis.leetcode.task.h8.p744;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p744.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 744,
    description = "Find Smallest Letter Greater Than Target",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BINARY_SEARCH}
)
public class FindSmallestLetterGreaterThanTarget extends LeetCodeTask<Character> {
    public static final int LEN = 10_000;
    private char[] letters;
    private char target;

    public static final String INFORMATION = """

        Description:
            You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
                There are at least two different characters in letters.

            Return the smallest character in letters that is lexicographically greater than target.
                If such a character does not exist, return the first character in letters.

        Example:
            Input: letters = ["c","f","j"], target = "c"
            Output: "f"
            Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.""";

    public FindSmallestLetterGreaterThanTarget(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        this.letters = new char[len];
        for (int i = 0; i < len; i++) {
            letters[i] = (char) random.nextInt('a', 'z' + 1);
        }
        Arrays.sort(letters);
        this.target = letters[random.nextInt(0, len + 1)];

        log.info("Letters are {}", Arrays.toString(letters));
        log.info("Target is '{}'", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1122 ms
    @Override
    protected Character original() {
        var original = new Original(letters, target);
        return original.process();
    }

    // time = 522 ms
    @Override
    protected Character practice() {
        var practice = new Practice(letters, target);
        return practice.process();
    }

    // time = 473 ms
    @Override
    protected Character solution() {
        var solution = new Solution(letters, target);
        return solution.process();
    }
}
