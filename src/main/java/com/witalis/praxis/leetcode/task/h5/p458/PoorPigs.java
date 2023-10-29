package com.witalis.praxis.leetcode.task.h5.p458;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p458.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 458,
    description = "Poor Pigs",
    difficulty = TaskDifficulty.HARD,
    tags = {MATH, DYNAMIC_PROGRAMMING, COMBINATORICS}
)
public class PoorPigs extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int TIME = 100;

    private int buckets;
    private int minutesToDie;
    private int minutesToTest;

    public static final String INFORMATION = """

        Description:
            There are buckets buckets of liquid, where exactly one of the buckets is poisonous.
                To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not.
                Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.

            You can feed the pigs according to these steps:
                1. Choose some live pigs to feed.
                2. For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time.
                   Each pig can feed from any number of buckets, and each bucket can be fed from by any number of pigs.
                3. Wait for minutesToDie minutes. You may not feed any other pigs during this time.
                4. After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.
                5. Repeat this process until you run out of time.

            Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs
                needed to figure out which bucket is poisonous within the allotted time.

        Example:
            Input: buckets = 4, minutesToDie = 15, minutesToTest = 15
            Output: 2
            Explanation: We can determine the poisonous bucket as follows:
                At time 0, feed the first pig buckets 1 and 2, and feed the second pig buckets 2 and 3.
                At time 15, there are 4 possible outcomes:
                - If only the first pig dies, then bucket 1 must be poisonous.
                - If only the second pig dies, then bucket 3 must be poisonous.
                - If both pigs die, then bucket 2 must be poisonous.
                - If neither pig dies, then bucket 4 must be poisonous.""";

    public PoorPigs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.buckets = random.nextInt(1, LEN + 1);
        this.minutesToTest = random.nextInt(1, TIME + 1);
        this.minutesToDie = random.nextInt(1, minutesToTest);

        log.info("Buckets: {}", buckets);
        log.info("Minutes To Die: {}", minutesToDie);
        log.info("Minutes To Test: {}", minutesToTest);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 469 ms
    @Override
    protected Integer original() {
        var original = new Original(buckets, minutesToDie, minutesToTest);
        return original.process();
    }

    // time = 437 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(buckets, minutesToDie, minutesToTest);
        return practice.process();
    }

    // time = 428 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(buckets, minutesToDie, minutesToTest);
        return solution.process();
    }
}
