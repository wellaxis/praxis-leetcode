package com.witalis.praxis.leetcode.task.h28.p2785;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h28.p2785.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2785,
    description = "Sort Vowels in a String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, SORTING}
)
public class SortVowelsInString extends LeetCodeTask<String> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a 0-indexed string s, permute s to get a new string t such that:
                * All consonants remain in their original places. More formally, if there is an index i
                  with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
                * The vowels must be sorted in the nondecreasing order of their ASCII values.
                  More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels,
                  then t[i] must not have a higher ASCII value than t[j].

            Return the resulting string.

            The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase.
                Consonants comprise all letters that are not vowels.

        Example:
            Input: s = "lEetcOde"
            Output: "lEOtcede"
            Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants.
                The vowels are sorted according to their ASCII values, and the consonants remain in the same places.""";

    public SortVowelsInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final var builder = new StringBuilder();
        var len = random.nextInt(1, LEN + 1);
        while (len-- > 0){
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            } else {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            }
        }
        this.string = builder.toString();

        log.info("String 's': {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7787 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 5428 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 3913 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
