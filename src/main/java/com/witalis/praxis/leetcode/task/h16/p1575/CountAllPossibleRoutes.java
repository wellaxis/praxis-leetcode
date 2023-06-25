package com.witalis.praxis.leetcode.task.h16.p1575;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1575.option.Original;
import com.witalis.praxis.leetcode.task.h16.p1575.option.Practice;
import com.witalis.praxis.leetcode.task.h16.p1575.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1575,
    description = "Count All Possible Routes",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, MEMOIZATION}
)
public class CountAllPossibleRoutes extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 1_000_000_000;
    public static final int FUEL = 200;

    private int[] locations;
    private int start;
    private int finish;
    private int fuel;

    public static final String INFORMATION = """

        Description:
            You are given an array of distinct positive integers locations where locations[i] represents the position of city i.
                You are also given integers start, finish and fuel representing the starting city, ending city,
                and the initial amount of fuel you have, respectively.

            At each step, if you are at city i, you can pick any city j such that j != i and 0 <= j < locations.length and move to city j.
                Moving from city i to city j reduces the amount of fuel you have by |locations[i] - locations[j]|.
                Please notice that |x| denotes the absolute value of x.

            Notice that fuel cannot become negative at any point in time,
                and that you are allowed to visit any city more than once (including start and finish).

            Return the count of all possible routes from start to finish. Since the answer may be too large, return it modulo 109 + 7.

        Example:
            Input: locations = [4,3,1], start = 1, finish = 0, fuel = 6
            Output: 5
            Explanation: The following are all possible routes:
                1 -> 0, used fuel = 1
                1 -> 2 -> 0, used fuel = 5
                1 -> 2 -> 1 -> 0, used fuel = 5
                1 -> 0 -> 1 -> 0, used fuel = 3
                1 -> 0 -> 1 -> 0 -> 1 -> 0, used fuel = 5""";

    public CountAllPossibleRoutes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.locations = random.ints(
            random.nextInt(2, LEN + 1),
            1, VALUE + 1
        ).distinct().toArray();
        this.start = random.nextInt(0, locations.length - 1);
        this.finish = random.nextInt(0, locations.length - 1);
        this.fuel = random.nextInt(1, FUEL + 1);

        log.info("Locations: {}", Arrays.toString(locations));
        log.info("Start: {}", start);
        log.info("Finish: {}", finish);
        log.info("Fuel: {}", fuel);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1556 ms
    @Override
    protected Integer original() {
        var original = new Original(locations, start, finish, fuel);
        return original.process();
    }

    // time = 1521 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(locations, start, finish, fuel);
        return practice.process();
    }

    // time = 1606 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(locations, start, finish, fuel);
        return solution.process();
    }
}
