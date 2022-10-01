package com.witalis.praxis.leetcode.task.h3.p274;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p274.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 274,
    description = "H-Index",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING, COUNTING_SORT}
)
public class HIndex extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 1_000;
    private int[] citations;

    public static final String INFORMATION = """

        Description:
            Given an array of integers citations where citations[i] is the number of citations
                a researcher received for their ith paper, return compute the researcher's h-index.

        According to the definition of h-index on Wikipedia:
            A scientist has an index h if h of their n papers have at least h citations each,
            and the other n − h papers have no more than h citations each.

        If there are several possible values for h, the maximum one is taken as the h-index.

        Example:
            Input: citations = [3,0,6,1,5]
            Output: 3
            Explanation: [3,0,6,1,5] means the researcher has 5 papers in total
                and each of them had received 3, 0, 6, 1, 5 citations respectively.
                Since the researcher has 3 papers with at least 3 citations each
                and the remaining two with no more than 3 citations each, their h-index is 3.""";

    public HIndex(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.citations = random.ints(len, 0, VALUE + 1).toArray();

        log.info("Citations are {}", Arrays.toString(citations));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2481 ms
    @Override
    protected Integer original() {
        var original = new Original(citations.clone());
        return original.process();
    }

    // time = 1417 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(citations.clone());
        return practice.process();
    }

    // time = 691 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(citations.clone());
        return solution.process();
    }
}
