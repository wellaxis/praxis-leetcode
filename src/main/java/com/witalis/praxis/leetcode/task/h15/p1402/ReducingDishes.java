package com.witalis.praxis.leetcode.task.h15.p1402;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1402.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1402,
    description = "Reducing Dishes",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GREEDY, SORTING}
)
public class ReducingDishes extends LeetCodeTask<Integer> {
    public static final int LEN = 500;
    public static final int VALUE = 1_000;

    private int[] satisfaction;

    public static final String INFORMATION = """

        Description:
            A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

            Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes
                multiplied by its satisfaction level i.e. time[i] * satisfaction[i].

            Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.

            Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.

        Example:
            Input: satisfaction = [-1,-8,0,5,-9]
            Output: 14
            Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
            Each dish is prepared in one unit of time.""";

    public ReducingDishes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.satisfaction = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Satisfaction: {}", Arrays.toString(satisfaction));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1770 ms
    @Override
    protected Integer original() {
        var original = new Original(satisfaction.clone());
        return original.process();
    }

    // time = 1712 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(satisfaction.clone());
        return practice.process();
    }

    // time = 742 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(satisfaction.clone());
        return solution.process();
    }
}
