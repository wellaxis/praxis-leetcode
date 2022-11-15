package com.witalis.praxis.leetcode.task.h8.p717;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p717.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 717,
    description = "1-bit and 2-bit Characters",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class Characters1BitAnd2Bit extends LeetCodeTask<Boolean> {
    public static final int LEN = 1000;
    private int[] bits;

    public static final String INFORMATION = """

        Description:
            We have two special characters:
            * The first character can be represented by one bit 0.
            * The second character can be represented by two bits (10 or 11).

            Given a binary array bits that ends with 0,
                return true if the last character must be a one-bit character.

        Example:
            Input: bits = [1,1,1,0]
            Output: false
            Explanation: The only way to decode it is two-bit character and two-bit character.
                So the last character is not one-bit character.""";

    public Characters1BitAnd2Bit(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.bits = random.ints(
            random.nextInt(1, LEN + 1),
            0, 2
        ).toArray();

        log.info("Bits are {}", Arrays.toString(bits));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 903 ms
    @Override
    protected Boolean original() {
        var original = new Original(bits);
        return original.process();
    }

    // time = 713 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(bits);
        return practice.process();
    }

    // time = 675 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(bits);
        return solution.process();
    }
}
