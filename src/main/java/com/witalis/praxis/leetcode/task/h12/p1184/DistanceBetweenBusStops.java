package com.witalis.praxis.leetcode.task.h12.p1184;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1184.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1184,
    description = "Distance Between Bus Stops",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, DYNAMIC_PROGRAMMING, GAME_THEORY}
)
public class DistanceBetweenBusStops extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] distance;
    private int start;
    private int destination;

    public static final String INFORMATION = """

        Description:
            A bus has n stops numbered from 0 to n - 1 that form a circle.
                We know the distance between all pairs of neighboring stops where
                distance[i] is the distance between the stops number i and (i + 1) % n.

            The bus goes along both directions i.e. clockwise and counterclockwise.

            Return the shortest distance between the given start and destination stops.

        Example:
            Input: distance = [1,2,3,4], start = 0, destination = 2
            Output: 3
            Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.""";

    public DistanceBetweenBusStops(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.distance = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();
        this.start = random.nextInt(0, distance.length);
        this.destination = random.nextInt(0, distance.length);

        log.info("Distance: {}", Arrays.toString(distance));
        log.info("Start: {}", start);
        log.info("Destination: {}", destination);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1883 ms
    @Override
    protected Integer original() {
        var original = new Original(distance, start, destination);
        return original.process();
    }

    // time = 715 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(distance, start, destination);
        return practice.process();
    }

    // time = 623 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(distance, start, destination);
        return solution.process();
    }
}
