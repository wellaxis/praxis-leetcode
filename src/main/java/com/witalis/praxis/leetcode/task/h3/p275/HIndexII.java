package com.witalis.praxis.leetcode.task.h3.p275;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p275.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 275,
    description = "H-Index II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class HIndexII extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000;
    private int[] citations;

    public static final String INFORMATION = """

        Given an array of integers citations where citations[i] is the number of citations
            a researcher received for their ith paper and citations is sorted in an ascending order,
            return compute the researcher's h-index.

        According to the definition of h-index on Wikipedia:
            A scientist has an index h if h of their n papers have at least h citations each,
            and the other n − h papers have no more than h citations each.

        If there are several possible values for h, the maximum one is taken as the h-index.

        You must write an algorithm that runs in logarithmic time.

        Example:
            Input: citations = [0,1,3,5,6]
            Output: 3
            Explanation: [0,1,3,5,6] means the researcher has 5 papers in total
                and each of them had received 0, 1, 3, 5, 6 citations respectively.
                Since the researcher has 3 papers with at least 3 citations each
                and the remaining two with no more than 3 citations each, their h-index is 3.""";

    public HIndexII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.citations = random.ints(len, 0, VALUE + 1).sorted().toArray();

        log.info("Citations are {}", Arrays.toString(citations));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 823 ms
    @Override
    protected Integer original() {
        var original = new Original(citations);
        return original.process();
    }

    // time = 668 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(citations);
        return practice.process();
    }

    // time = 483 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(citations);
        return solution.process();
    }
}
