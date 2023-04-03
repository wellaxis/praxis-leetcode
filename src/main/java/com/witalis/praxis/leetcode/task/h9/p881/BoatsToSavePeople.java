package com.witalis.praxis.leetcode.task.h9.p881;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p881.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 881,
    description = "Boats to Save People",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, GREEDY, SORTING}
)
public class BoatsToSavePeople extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 30_000;

    private int[] people;
    private int limit;

    public static final String INFORMATION = """

        Description:
            You are given an array people where people[i] is the weight of the ith person,
                and an infinite number of boats where each boat can carry a maximum weight of limit.
                Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

            Return the minimum number of boats to carry every given person.

        Example:
            Input: people = [3,2,2,1], limit = 3
            Output: 3
            Explanation: 3 boats (1, 2), (2) and (3)""";

    public BoatsToSavePeople(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.people = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.limit = random.nextInt(Arrays.stream(people).max().orElse(VALUE), VALUE + 1);

        log.info("People: {}", Arrays.toString(people));
        log.info("Limit: {}", limit);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3560 ms
    @Override
    protected Integer original() {
        var original = new Original(people.clone(), limit);
        return original.process();
    }

    // time = 3144 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(people.clone(), limit);
        return practice.process();
    }

    // time = 3058 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(people.clone(), limit);
        return solution.process();
    }
}
