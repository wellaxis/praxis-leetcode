package com.witalis.praxis.leetcode.task.h20.p1921;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1921.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1921,
    description = "Eliminate Maximum Number of Monsters",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY, SORTING}
)
public class EliminateMaximumNumberOfMonsters extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int[] distances;
    private int[] speeds;

    public static final String INFORMATION = """

        Description:
            You are playing a video game where you are defending your city from a group of n monsters.
                You are given a 0-indexed integer array dist of size n,
                where dist[i] is the initial distance in kilometers of the ith monster from the city.

            The monsters walk toward the city at a constant speed. The speed of each monster is given to you
                in an integer array speed of size n, where speed[i] is the speed of the ith monster in kilometers per minute.

            You have a weapon that, once fully charged, can eliminate a single monster.
                However, the weapon takes one minute to charge. The weapon is fully charged at the very start.

            You lose when any monster reaches your city. If a monster reaches the city at the exact moment
                the weapon is fully charged, it counts as a loss, and the game ends before you can use your weapon.

            Return the maximum number of monsters that you can eliminate before you lose,
                or n if you can eliminate all the monsters before they reach the city.

        Example:
            Input: dist = [1,3,4], speed = [1,1,1]
            Output: 3
            Explanation:
                In the beginning, the distances of the monsters are [1,3,4]. You eliminate the first monster.
                After a minute, the distances of the monsters are [X,2,3]. You eliminate the second monster.
                After a minute, the distances of the monsters are [X,X,2]. You eliminate the thrid monster.
                All 3 monsters can be eliminated.""";

    public EliminateMaximumNumberOfMonsters(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.distances = random.ints(
            len,
            1, VALUE + 1
        ).toArray();
        this.speeds = random.ints(
            len,
            1, VALUE + 1
        ).toArray();

        log.info("Distances: {}", Arrays.toString(distances));
        log.info("Speeds: {}", Arrays.toString(speeds));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7843 ms
    @Override
    protected Integer original() {
        var original = new Original(distances.clone(), speeds.clone());
        return original.process();
    }

    // time = 7625 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(distances.clone(), speeds.clone());
        return practice.process();
    }

    // time = 7152 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(distances.clone(), speeds.clone());
        return solution.process();
    }
}
