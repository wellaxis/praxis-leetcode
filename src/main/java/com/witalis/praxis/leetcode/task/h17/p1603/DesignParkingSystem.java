package com.witalis.praxis.leetcode.task.h17.p1603;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1603.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1603,
    description = "Design Parking System",
    difficulty = TaskDifficulty.EASY,
    tags = {DESIGN, SIMULATION, COUNTING}
)
public class DesignParkingSystem extends LeetCodeTask<boolean[]> {
    public static final int LEN = 1_000;

    private int big;
    private int medium;
    private int small;
    private int[] attempts;

    public static final String INFORMATION = """

        Design a parking system for a parking lot.
            The parking lot has three kinds of parking spaces: big, medium, and small,
            with a fixed number of slots for each size.

        Implement the ParkingSystem class:
        * ParkingSystem(int big, int medium, int small) Initializes object
            of the ParkingSystem class. The number of slots for each parking space
            are given as part of the constructor.
        * bool addCar(int carType) Checks whether there is a parking space
            of carType for the car that wants to get into the parking lot.
            carType can be of three kinds: big, medium, or small,
            which are represented by 1, 2, and 3 respectively.
            A car can only park in a parking space of its carType.
            If there is no space available, return false,
            else park the car in that size space and return true.

        Example:
            Input
                ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
                [[1, 1, 0], [1], [2], [3], [1]]
            Output
                [null, true, true, false, false]
            Explanation
                ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
                parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
                parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
                parkingSystem.addCar(3); // return false because there is no available slot for a small car
                parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.""";

    public DesignParkingSystem(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.big = random.nextInt(0, LEN + 1);
        this.medium = random.nextInt(0, LEN + 1);
        this.small = random.nextInt(0, LEN + 1);
        this.attempts = random.ints(
            random.nextInt(1_000, 3_000),
            1, 4
        ).toArray();

        log.info("Slots: big {}, medium {}, small {}", big, medium, small);
        log.info("Attempts are {}", attempts);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 929 ms
    @Override
    protected boolean[] original() {
        var original = new Original(big, medium, small, attempts);
        return original.process();
    }

    // time = 930 ms
    @Override
    protected boolean[] practice() {
        var practice = new Practice(big, medium, small, attempts);
        return practice.process();
    }

    // time = 861 ms
    @Override
    protected boolean[] solution() {
        var solution = new Solution(big, medium, small, attempts);
        return solution.process();
    }
}
