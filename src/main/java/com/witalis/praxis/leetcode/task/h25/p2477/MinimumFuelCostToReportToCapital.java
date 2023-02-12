package com.witalis.praxis.leetcode.task.h25.p2477;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2477.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2477,
    description = "Minimum Fuel Cost to Report to the Capital",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, MATRIX}
)
public class MinimumFuelCostToReportToCapital extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[][] roads;
    private int seats;

    public static final String INFORMATION = """

        Description:
            There is a tree (i.e., a connected, undirected graph with no cycles) structure country network
                consisting of n cities numbered from 0 to n - 1 and exactly n - 1 roads. The capital city is city 0.
                You are given a 2D integer array roads where roads[i] = [ai, bi] denotes
                that there exists a bidirectional road connecting cities ai and bi.

            There is a meeting for the representatives of each city. The meeting is in the capital city.

            There is a car in each city. You are given an integer seats that indicates the number of seats in each car.

            A representative can use the car in their city to travel or change the car and ride with another representative.
                The cost of traveling between two cities is one liter of fuel.

            Return the minimum number of liters of fuel to reach the capital city.

        Example:
            Input: roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
            Output: 7
            Explanation:
                - Representative2 goes directly to city 3 with 1 liter of fuel.
                - Representative2 and representative3 go together to city 1 with 1 liter of fuel.
                - Representative2 and representative3 go together to the capital with 1 liter of fuel.
                - Representative1 goes directly to the capital with 1 liter of fuel.
                - Representative5 goes directly to the capital with 1 liter of fuel.
                - Representative6 goes directly to city 4 with 1 liter of fuel.
                - Representative4 and representative6 go together to the capital with 1 liter of fuel.
                It costs 7 liters of fuel at minimum.
                It can be proven that 7 is the minimum number of liters of fuel needed.""";

    public MinimumFuelCostToReportToCapital(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int cities = random.nextInt(1, LEN + 1);
        int capital = random.nextInt(0, cities - 1);
        this.roads = new int[cities - 1][2];
        final List<int[]> directions = new ArrayList<>(cities - 1);
        final Queue<Integer> queue = new ArrayDeque<>();
        int city = 0;
        queue.offer(capital);
        while (!queue.isEmpty() && city < cities - 1) {
            int source = queue.poll();
            int mode = random.nextInt(1, 6);
            for (int m = 0; m < mode; m++) {
                if (city < cities - 1) {
                    int target = (++city == capital) ? 0 : city;
                    directions.add(new int[] {source, target});
                    queue.offer(target);
                }
            }
        }
        Collections.shuffle(directions);
        for (int i = 0; i < cities - 1; i++) {
            roads[i] = directions.get(i);
        }
        this.seats = random.nextInt(1, VALUE + 1);

        log.info("Roads: {}", Arrays.deepToString(roads));
        log.info("Seats: {}", seats);
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

    // time = 58074 ms
    @Override
    protected Long original() {
        var original = new Original(roads, seats);
        return original.process();
    }

    // time = 35511 ms
    @Override
    protected Long practice() {
        var practice = new Practice(roads, seats);
        return practice.process();
    }

    // time = 91260 ms
    @Override
    protected Long solution() {
        var solution = new Solution(roads, seats);
        return solution.process();
    }
}
