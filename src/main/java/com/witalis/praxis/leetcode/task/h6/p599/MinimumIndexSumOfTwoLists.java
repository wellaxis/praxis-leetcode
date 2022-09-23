package com.witalis.praxis.leetcode.task.h6.p599;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p599.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 599,
    description = "Minimum Index Sum of Two Lists",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class MinimumIndexSumOfTwoLists extends LeetCodeTask<String[]> {
    public static final int SIZE = 1_000;
    public static final int LEN = 30;
    private String[] list1;
    private String[] list2;

    public static final String INFORMATION = """

        Given two arrays of strings list1 and list2, find the common strings with the least index sum.

        A common string is a string that appeared in both list1 and list2.

        A common string with the least index sum is a common string such that
            if it appeared at list1[i] and list2[j] then i + j should be the minimum value
            among all the other common strings.

        Return all the common strings with the least index sum. Return the answer in any order.

        Example:
            Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
            Output: ["sad","happy"]
            Explanation: There are three common strings:
                "happy" with index sum = (0 + 1) = 1.
                "sad" with index sum = (1 + 0) = 1.
                "good" with index sum = (2 + 2) = 4.
                The strings with the least index sum are "sad" and "happy".""";

    public MinimumIndexSumOfTwoLists(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size1 = random.nextInt(1, SIZE + 1);
        int size2 = random.nextInt(1, SIZE + 1);

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        StringBuilder builder;
        while (l1.size() < size1 || l2.size() < size2) {
            var len = random.nextInt(1, LEN + 1);
            builder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (random.nextBoolean()) {
                    builder.append((char) random.nextInt('A', 'Z' + 1));
                } else {
                    builder.append((char) random.nextInt('a', 'z' + 1));
                }
            }
            if (random.nextBoolean() && l1.size() < size1) {
                l1.add(builder.toString());
            }
            if (random.nextBoolean() && l2.size() < size2) {
                l2.add(builder.toString());
            }
        }

        Collections.shuffle(l1);
        Collections.shuffle(l2);

        this.list1 = new HashSet<>(l1).toArray(String[]::new);
        this.list2 = new HashSet<>(l2).toArray(String[]::new);

        log.info("List N1 is '{}'", Arrays.toString(list1));
        log.info("List N2 is '{}'", Arrays.toString(list2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 840 ms
    @Override
    protected String[] original() {
        var original = new Original(list1, list2);
        return original.process();
    }

    // time = 550 ms
    @Override
    protected String[] practice() {
        var practice = new Practice(list1, list2);
        return practice.process();
    }

    // time = 500 ms
    @Override
    protected String[] solution() {
        var solution = new Solution(list1, list2);
        return solution.process();
    }
}
