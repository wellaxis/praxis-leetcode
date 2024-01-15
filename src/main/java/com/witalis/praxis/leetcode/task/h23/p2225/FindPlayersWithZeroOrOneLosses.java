package com.witalis.praxis.leetcode.task.h23.p2225;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2225.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2225,
    description = "Find Players With Zero or One Losses",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, SORTING, COUNTING}
)
public class FindPlayersWithZeroOrOneLosses extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[][] matches;

    public static final String INFORMATION = """

        Description:
            You are given an integer array matches where matches[i] = [winneri, loseri]
                indicates that the player winneri defeated player loseri in a match.

            Return a list answer of size 2 where:
                * answer[0] is a list of all players that have not lost any matches.
                * answer[1] is a list of all players that have lost exactly one match.

            The values in the two lists should be returned in increasing order.

            Note:
                * You should only consider the players that have played at least one match.
                * The testcases will be generated such that no two matches will have the same outcome.

        Example:
            Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
            Output: [[1,2,10],[4,5,7,8]]
            Explanation:
                Players 1, 2, and 10 have not lost any matches.
                Players 4, 5, 7, and 8 each have lost one match.
                Players 3, 6, and 9 each have lost two matches.
                Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].""";

    public FindPlayersWithZeroOrOneLosses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int n = random.nextInt(1, LEN + 1);
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < VALUE; i++) {
            if (random.nextInt(0, 10) == 0) continue;
            for (int j = 0; j < VALUE; j++) {
                if (i == j) continue;
                if (random.nextInt(0, 10) == 0) continue;
                pairs.add(new int[] {i, j});
                if (random.nextInt(0, 10) == 0) break;
            }
            if (pairs.size() > n) break;
        }
        this.matches = pairs.toArray(int[][]::new);

        log.info("Matches: {}", Arrays.deepToString(matches));
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        if (matrix == null) return new int[0][0];

        return Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 45607 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(cloneMatrix(matches));
        return original.process();
    }

    // time = 35755 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(cloneMatrix(matches));
        return practice.process();
    }

    // time = 22235 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(cloneMatrix(matches));
        return solution.process();
    }
}
