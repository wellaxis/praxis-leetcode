package com.witalis.praxis.leetcode.task.h12.p1108;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1108.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1108,
    description = "Defanging an IP Address",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class DefangingIPAddress extends LeetCodeTask<String> {
    public static final int VALUE = 256;

    private String address;

    public static final String INFORMATION = """

        Description:
            Given a valid (IPv4) IP address, return a defanged version of that IP address.

            A defanged IP address replaces every period "." with "[.]".

        Example:
            Input: address = "255.100.50.0"
            Output: "255[.]100[.]50[.]0" """;

    public DefangingIPAddress(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.address =String.join(
            ".",
            String.valueOf(random.nextInt(0, VALUE)),
            String.valueOf(random.nextInt(0, VALUE)),
            String.valueOf(random.nextInt(0, VALUE)),
            String.valueOf(random.nextInt(0, VALUE))
        );

        log.info("IPv4 address: {}", address);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 790 ms
    @Override
    protected String original() {
        var original = new Original(address);
        return original.process();
    }

    // time = 494 ms
    @Override
    protected String practice() {
        var practice = new Practice(address);
        return practice.process();
    }

    // time = 534 ms
    @Override
    protected String solution() {
        var solution = new Solution(address);
        return solution.process();
    }
}
