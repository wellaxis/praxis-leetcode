package com.witalis.praxis.leetcode.task.h2.p134;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p134.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 134,
    description = "Gas Station",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY}
)
public class GasStation extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    private int[] gas;
    private int[] cost;

    public static final String INFORMATION = """

        There are n gas stations along a circular route,
            where the amount of gas at the ith station is gas[i].

        You have a car with an unlimited gas tank,
            and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
            You begin the journey with an empty tank at one of the gas stations.

        Given two integer arrays gas and cost, return the starting gas station's index
            if you can travel around the circuit once in the clockwise direction, otherwise return -1.
            If there exists a solution, it is guaranteed to be unique.

        Example:
            Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
            Output: 3
            Explanation:
                Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
                Travel to station 4. Your tank = 4 - 1 + 5 = 8
                Travel to station 0. Your tank = 8 - 2 + 1 = 7
                Travel to station 1. Your tank = 7 - 3 + 2 = 6
                Travel to station 2. Your tank = 6 - 4 + 3 = 5
                Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
                Therefore, return 3 as the starting index.""";

    public GasStation(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        this.gas = random.ints(len, 0, VALUE + 1).toArray();
        this.cost = random.ints(len, 0, VALUE + 1).toArray();

        log.info("Gas volumes are {}", Arrays.toString(gas));
        log.info("Cost values are {}", Arrays.toString(cost));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1220785 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(gas.clone(), cost.clone());
        return original.process();
    }

    // time = 2361 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(gas.clone(), cost.clone());
        return practice.process();
    }

    // time = 1962 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(gas.clone(), cost.clone());
        return solution.process();
    }
}
