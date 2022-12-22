package com.witalis.praxis.leetcode.task.h9.p886;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p886.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 886,
    description = "Possible Bipartition",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND}
)
public class PossibleBipartition extends LeetCodeTask<Boolean> {
    public static final int LEN = 2_000;
    public static final int SIZE = 10_000;
    private int number;
    private int[][] dislikes;

    public static final String INFORMATION = """

        Description:
            We want to split a group of n people (labeled from 1 to n) into two groups of any size.
                Each person may dislike some other people, and they should not go into the same group.

            Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates
                that the person labeled ai does not like the person labeled bi,
                return true if it is possible to split everyone into two groups in this way.

        Example:
            Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
            Output: true
            Explanation: group1 [1,4] and group2 [2,3].""";

    public PossibleBipartition(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        int size = random.nextInt(0, SIZE + 1);
        List<int[]> dislikeList = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int[] candidates = random.ints(
                random.nextInt(0, (size / number) + 1),
                1, number + 1
            ).distinct().toArray();
            for (int candidate : candidates) {
                dislikeList.add(new int[] {i, candidate});
            }
        }
        Collections.shuffle(dislikeList);
        this.dislikes = dislikeList.toArray(int [][]::new);

        log.info("Number: {}", number);
        log.info("Dislikes: {}", Arrays.deepToString(dislikes));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4263 ms
    @Override
    protected Boolean original() {
        var original = new Original(number, dislikes);
        return original.process();
    }

    // time = 4088 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number, dislikes);
        return practice.process();
    }

    // time = 2544 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number, dislikes);
        return solution.process();
    }
}
