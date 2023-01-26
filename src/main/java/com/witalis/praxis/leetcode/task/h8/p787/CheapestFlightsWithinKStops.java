package com.witalis.praxis.leetcode.task.h8.p787;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p787.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 787,
    description = "Cheapest Flights Within K Stops",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, GRAPH, HEAP, SHORTEST_PATH}
)
public class CheapestFlightsWithinKStops extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int PRICE = 10_000;

    private int number;
    private int[][] flights;
    private int source;
    private int destination;
    private int transplants;

    public static final String INFORMATION = """

        Description:
            There are n cities connected by some number of flights.
                You are given an array flights where flights[i] = [fromi, toi, pricei] indicates
                that there is a flight from city fromi to city toi with cost pricei.

            You are also given three integers src, dst, and k,
                return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

        Example:
            Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
            Output: 700
            Explanation:
                The graph is shown above.
                The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
                Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.""";

    public CheapestFlightsWithinKStops(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        int len = random.nextInt(0, (number * (number - 1) / 2));
        this.flights = new int[len][3];

        Map<Integer, Set<Integer>> directions = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int from = random.nextInt(0, number);
            int to = random.nextInt(0, number);
            int price = random.nextInt(1, PRICE + 1);

            while (to == from ||
                (directions.containsKey(to) && directions.get(to).contains(from)) ||
                (directions.containsKey(from) && directions.get(from).contains(to))
            ) {
                to = random.nextInt(0, number);
            }
            directions.putIfAbsent(from, new HashSet<>());
            directions.get(from).add(to);

            flights[i] = new int[] {from, to, price};
        }

        this.source = random.nextInt(0, number);
        this.destination = random.nextInt(0, number);
        while (source == destination) destination = random.nextInt(0, number);

        this.transplants = random.nextInt(0, number);

        log.info("Number: {}", number);
        log.info("Flights: {}", Arrays.deepToString(flights));
        log.info("Source: {}", source);
        log.info("Destination: {}", destination);
        log.info("Transplants: {}", transplants);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 11023067 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(number, flights, source, destination, transplants);
        return original.process();
    }

    // time = 9523221 ms, time limit exceeded
    @Override
    protected Integer practice() {
        var practice = new Practice(number, flights, source, destination, transplants);
        return practice.process();
    }

    // time = 2316 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number, flights, source, destination, transplants);
        return solution.process();
    }
}
