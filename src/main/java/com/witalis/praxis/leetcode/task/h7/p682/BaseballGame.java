package com.witalis.praxis.leetcode.task.h7.p682;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p682.option.*;
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
    id = 682,
    description = "Baseball Game",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, STACK, SIMULATION}
)
public class BaseballGame extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 30_000;
    private String[] operations;

    public static final String INFORMATION = """

        Description:
            You are keeping the scores for a baseball game with strange rules.
                At the beginning of the game, you start with an empty record.

            You are given a list of strings operations, where operations[i]
                is the ith operation you must apply to the record and is one of the following:
                * An integer x.
                    * Record a new score of x.
                * '+'.
                    * Record a new score that is the sum of the previous two scores.
                * 'D'.
                    * Record a new score that is the double of the previous score.
                * 'C'.
                    * Invalidate the previous score, removing it from the record.

            Return the sum of all the scores on the record after applying all the operations.

            The test cases are generated such that the answer and all intermediate calculations
                fit in a 32-bit integer and that all operations are valid.

        Example:
            Input: ops = ["5","2","C","D","+"]
            Output: 30
            Explanation:
                "5" - Add 5 to the record, record is now [5].
                "2" - Add 2 to the record, record is now [5, 2].
                "C" - Invalidate and remove the previous score, record is now [5].
                "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
                "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
                The total sum is 5 + 10 + 15 = 30.""";

    public BaseballGame(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<String> actions = new ArrayList<>();
        while (len-- > 0) {
            int mode = random.nextInt(0, 4);
            switch (mode) {
                case 0 -> actions.add(String.valueOf(random.nextInt(-VALUE, VALUE + 1)));
                case 1 -> {
                    actions.add(String.valueOf(random.nextInt(-VALUE, VALUE + 1)));
                    actions.add(String.valueOf(random.nextInt(-VALUE, VALUE + 1)));
                    len -= 2;
                    actions.add("+");
                }
                case 2 -> {
                    actions.add(String.valueOf(random.nextInt(-VALUE, VALUE + 1)));
                    len--;
                    actions.add("C");
                }
                case 3 -> {
                    actions.add(String.valueOf(random.nextInt(-VALUE, VALUE + 1)));
                    len--;
                    actions.add("D");
                }
            }
        }
        this.operations = actions.toArray(new String[0]);

        log.info("Operations are {}", Arrays.toString(operations));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2792 ms
    @Override
    protected Integer original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 1038 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 1510 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
