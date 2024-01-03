package com.witalis.praxis.leetcode.task.h22.p2125;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2125.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2125,
    description = "Number of Laser Beams in a Bank",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, STRING, MATRIX}
)
public class NumberOfLaserBeamsInBank extends LeetCodeTask<Integer> {
    public static final int LEN = 500;

    private String[] bank;

    public static final String INFORMATION = """

        Description:
            Anti-theft security devices are activated inside a bank.
                You are given a 0-indexed binary string array bank representing the floor plan of the bank,
                which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's.
                '0' means the cell is empty, while'1' means the cell has a security device.

            There is one laser beam between any two security devices if both conditions are met:
                * The two devices are located on two different rows: r1 and r2, where r1 < r2.
                * For each row i where r1 < i < r2, there are no security devices in the ith row.

            Laser beams are independent, i.e., one beam does not interfere nor join with another.

            Return the total number of laser beams in the bank.

        Example:
            Input: bank = ["011001","000000","010100","001000"]
            Output: 8
            Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
                 * bank[0][1] -- bank[2][1]
                 * bank[0][1] -- bank[2][3]
                 * bank[0][2] -- bank[2][1]
                 * bank[0][2] -- bank[2][3]
                 * bank[0][5] -- bank[2][1]
                 * bank[0][5] -- bank[2][3]
                 * bank[2][1] -- bank[3][2]
                 * bank[2][3] -- bank[3][2]
                Note that there is no beam between any device on the 0th row with any on the 3rd row.
                This is because the 2nd row contains security devices, which breaks the second condition.""";

    public NumberOfLaserBeamsInBank(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int m = random.nextInt(1, LEN + 1);
        final int n = random.nextInt(1, LEN + 1);
        this.bank = new String[m];
        for (int i = 0; i < m; i++) {
            var builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (random.nextBoolean()) {
                    builder.append('1');
                } else {
                    builder.append('0');
                }
            }
            bank[i] = builder.toString();
        }

        log.info("Bank: {}", Arrays.toString(bank));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3642 ms
    @Override
    protected Integer original() {
        var original = new Original(bank);
        return original.process();
    }

    // time = 2310 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(bank);
        return practice.process();
    }

    // time = 3917 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(bank);
        return solution.process();
    }
}
