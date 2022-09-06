package com.witalis.praxis.leetcode.task.h3.p216;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p216.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 216,
    description = "Combination Sum III",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BACKTRACKING}
)
public class CombinationSumIII extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 60;
    private int qty;
    private int sum;

    public static final String INFORMATION = """

        Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
            * Only numbers 1 through 9 are used.
            * Each number is used at most once.

        Return a list of all possible valid combinations. The list must not contain
            the same combination twice, and the combinations may be returned in any order.

        Example:
            Input: k = 3, n = 9
            Output: [[1,2,6],[1,3,5],[2,3,4]]
            Explanation:
                1 + 2 + 6 = 9
                1 + 3 + 5 = 9
                2 + 3 + 4 = 9
                There are no other valid combinations.""";

    public CombinationSumIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.qty = random.nextInt(2, 10);
        this.sum = random.nextInt(1, LEN + 1);

        log.info("Qty is {}", qty);
        log.info("Sum is {}", sum);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1325 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(qty, sum);
        return original.process();
    }

    // time = 593 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(qty, sum);
        return practice.process();
    }

    // time = 552 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(qty, sum);
        return solution.process();
    }
}
