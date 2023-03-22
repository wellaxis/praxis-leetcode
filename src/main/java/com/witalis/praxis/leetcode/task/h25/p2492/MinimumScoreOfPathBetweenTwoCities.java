package com.witalis.praxis.leetcode.task.h25.p2492;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2492.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2492,
    description = "Minimum Score of a Path Between Two Cities",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, GRAPH}
)
public class MinimumScoreOfPathBetweenTwoCities extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int cities;
    private int[][] roads;

    public static final String INFORMATION = """

        Description:
            You are given a positive integer n representing n cities numbered from 1 to n.
                You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that
                there is a bidirectional road between cities ai and bi with a distance equal to distancei.
                The cities graph is not necessarily connected.

            The score of a path between two cities is defined as the minimum distance of a road in this path.

            Return the minimum possible score of a path between cities 1 and n.

            Note:
                * A path is a sequence of roads between two cities.
                * It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
                * The test cases are generated such that there is at least one path between 1 and n.

        Example:
            Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
            Output: 2
            Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.""";

    public MinimumScoreOfPathBetweenTwoCities(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.cities = random.nextInt(2, LEN + 1);

        final int len = random.nextInt(1, LEN + 1);
        final List<int[]> directions = new ArrayList<>();
        final Set<String> relations = new HashSet<>();
        final Queue<Integer> queue = new ArrayDeque<>();

        int city = 1;
        queue.offer(city);
        int quantity = 1;
        directions.add(new int[] {city, cities, random.nextInt(1, VALUE + 1)});
        relations.addAll(List.of(city + "|" + cities, cities + "|" + city));
        while (!queue.isEmpty() && quantity < len) {
            int source = queue.poll();
            int neighbours = random.nextInt(1, 11);
            for (int i = 0; i < neighbours; i++) {
                int target = random.nextInt(1, cities + 1);
                String forward = source + "|" + target;
                String backward = target + "|" + source;
                if (target != source && !relations.contains(forward) && !relations.contains(backward)) {
                    int distance = random.nextInt(1, VALUE + 1);
                    directions.add(new int[] {source, target, distance});
                    quantity++;
                    relations.add(forward);
                    relations.add(backward);
                    queue.offer(target);
                }
            }
        }
        Collections.shuffle(directions);
        roads = directions.toArray(int[][]::new);

        log.info("Cities: {}", cities);
        log.info("Roads: {}", Arrays.deepToString(roads));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 35394 ms
    @Override
    protected Integer original() {
        var original = new Original(cities, roads);
        return original.process();
    }

    // time = 29771 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cities, roads);
        return practice.process();
    }

    // time = 25323 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cities, roads);
        return solution.process();
    }
}
