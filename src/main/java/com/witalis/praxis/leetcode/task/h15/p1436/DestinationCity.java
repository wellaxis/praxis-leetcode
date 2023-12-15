package com.witalis.praxis.leetcode.task.h15.p1436;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1436.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1436,
    description = "Destination City",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING}
)
public class DestinationCity extends LeetCodeTask<String> {
    public static final int LEN = 100;

    private List<List<String>> paths;

    public static final String INFORMATION = """

        Description:
            You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
                Return the destination city, that is, the city without any path outgoing to another city.

            It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

        Example:
            Input: paths = [["B","C"],["D","B"],["C","A"]]
            Output: "A"
            Explanation: All possible trips are:
                "D" -> "B" -> "C" -> "A".
                "B" -> "C" -> "A".
                "C" -> "A".
                "A".
                Clearly the destination city is "A".""";

    public DestinationCity(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN / 2);
        List<String> cities = new ArrayList<>();
        for (int i = 0; i < len; i++)
            cities.add(generate());

        this.paths = new ArrayList<>();
        var size = len * 2;
        for (int i = 0; i < len; i++) {
            String city1 = cities.get(random.nextInt(0, cities.size()));
            String city2 = cities.get(random.nextInt(0, cities.size()));

            if (!city1.equals(city2))
                paths.add(List.of(city1, city2));
        }

        log.info("Paths: {}", paths);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, 11);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 806 ms
    @Override
    protected String original() {
        var original = new Original(paths);
        return original.process();
    }

    // time = 527 ms
    @Override
    protected String practice() {
        var practice = new Practice(paths);
        return practice.process();
    }

    // time = 476 ms
    @Override
    protected String solution() {
        var solution = new Solution(paths);
        return solution.process();
    }
}
