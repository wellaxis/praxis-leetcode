package com.witalis.praxis.leetcode.task.h1.p49;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p49.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 49,
    description = "Group Anagrams",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, SORTING}
)
public class GroupAnagrams extends LeetCodeTask<List<List<String>>> {
    public static final int SIZE = 1_000;
    public static final int LEN = 5;
    private String[] strings;

    public static final String INFORMATION = """

        Given an array of strings strs, group the anagrams together.
            You can return the answer in any order.

        An Anagram is a word or phrase formed
            by rearranging the letters of a different word or phrase,
            typically using all the original letters exactly once.

        Example:
            Input: strs = ["eat","tea","tan","ate","nat","bat"]
            Output: [["bat"],["nat","tan"],["ate","eat","tea"]]""";

    public GroupAnagrams(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.strings = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            var builder = new StringBuilder();
            var length = random.nextInt(1, LEN + 1);
            while (length > 0) {
                char ch = (char) random.nextInt(97, 123);
                builder.append(ch);
                length--;
            }
            strings[i] = builder.toString();
        }

        log.info("Strings are {}", Arrays.toString(strings));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1460 ms
    @Override
    protected List<List<String>> original() {
        var original = new Original(strings.clone());
        return original.process();
    }

    // time = 3962 ms
    @Override
    protected List<List<String>> practice() {
        var practice = new Practice(strings.clone());
        return practice.process();
    }

    // time = 1960 ms
    @Override
    protected List<List<String>> solution() {
        var solution = new Solution(strings.clone());
        return solution.process();
    }
}
