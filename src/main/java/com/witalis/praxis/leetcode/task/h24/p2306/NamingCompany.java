package com.witalis.praxis.leetcode.task.h24.p2306;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2306.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2306,
    description = "Naming a Company",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE, STRING, BIT_MANIPULATION, ENUMERATION}
)
public class NamingCompany extends LeetCodeTask<Long> {
    public static final int SIZE = 50_000;
    public static final int LEN = 10;

    private String[] ideas;

    public static final String INFORMATION = """

        Description:
            You are given an array of strings ideas that represents a list of names to be used in the process of naming a company.
                The process of naming a company is as follows:
                * Choose 2 distinct names from ideas, call them ideaA and ideaB.
                * Swap the first letters of ideaA and ideaB with each other.
                * If both of the new names are not found in the original ideas, then the name ideaA ideaB
                  (the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
                  Otherwise, it is not a valid name.

            Return the number of distinct valid names for the company.

        Example:
            Input: ideas = ["coffee","donuts","time","toffee"]
            Output: 6
            Explanation:
                The following selections are valid:
                - ("coffee", "donuts"): The company name created is "doffee conuts".
                - ("donuts", "coffee"): The company name created is "conuts doffee".
                - ("donuts", "time"): The company name created is "tonuts dime".
                - ("donuts", "toffee"): The company name created is "tonuts doffee".
                - ("time", "donuts"): The company name created is "dime tonuts".
                - ("toffee", "donuts"): The company name created is "doffee tonuts".
                Therefore, there are a total of 6 distinct company names.
                The following are some examples of invalid selections:
                - ("coffee", "time"): The name "toffee" formed after swapping already exists in the original array.
                - ("time", "toffee"): Both names are still the same after swapping and exist in the original array.
                - ("coffee", "toffee"): Both names formed after swapping already exist in the original array.""";

    public NamingCompany(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var size = random.nextInt(2, SIZE + 1);
        Set<String> candidates = new HashSet<>();
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder();
            var len = random.nextInt(1, LEN + 1);
            for (int j = 0; j < len; j++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            candidates.add(builder.toString());
        }
        this.ideas = candidates.stream().distinct().toArray(String[]::new);

        log.info("Ideas: {}", Arrays.toString(ideas));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1590 ms
    @Override
    protected Long original() {
        var original = new Original(ideas);
        return original.process();
    }

    // time = 1504 ms
    @Override
    protected Long practice() {
        var practice = new Practice(ideas);
        return practice.process();
    }

    // time = 1469 ms
    @Override
    protected Long solution() {
        var solution = new Solution(ideas);
        return solution.process();
    }
}
