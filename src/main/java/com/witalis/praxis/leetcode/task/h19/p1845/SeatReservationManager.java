package com.witalis.praxis.leetcode.task.h19.p1845;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1845.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1845,
    description = "Seat Reservation Manager",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DESIGN, HEAP}
)
public class SeatReservationManager extends LeetCodeTask<List<String>> {
    public static final int LEN = 100_000;

    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Description:
            Design a system that manages the reservation state of n seats that are numbered from 1 to n.

            Implement the SeatManager class:
                * SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n.
                  All seats are initially available.
                * int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
                * void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.

        Example:
            Input
                ["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
                [[5], [], [], [2], [], [], [], [], [5]]
            Output
                [null, 1, 2, null, 2, 3, 4, 5, null]
            Explanation
                SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
                seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
                seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
                seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
                seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
                seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
                seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
                seatManager.reserve();    // The only available seat is seat 5, so return 5.
                seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].""";

    public SeatReservationManager(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int count = random.nextInt(1, LEN + 1);

        operations = new ArrayList<>(count);
        operations.add(new AbstractMap.SimpleEntry<>("SeatManager", count));

        int seats = 0;
        for (int i = 1; i < LEN; i++) {
            if (random.nextBoolean()) {
                operations.add(new AbstractMap.SimpleEntry<>("reserve", null));
                seats++;
            } else {
                if (seats > 0) {
                    int seat = random.nextInt(1, seats + 1);
                    operations.add(new AbstractMap.SimpleEntry<>("unreserve", seat));
                    seats--;
                }
            }
        }

        log.info("Browser History: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 50722 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 20352 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 13960 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
