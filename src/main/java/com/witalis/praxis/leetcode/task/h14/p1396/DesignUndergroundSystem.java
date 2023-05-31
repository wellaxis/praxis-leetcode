package com.witalis.praxis.leetcode.task.h14.p1396;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1396.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.time.Month;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1396,
    description = "Design Underground System",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, DESIGN}
)
public class DesignUndergroundSystem extends LeetCodeTask<List<String>> {
    public static final int LEN = 10;
    public static final int CALLS = 20_000;
    public static final int VALUE = 1_000_000;

    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    public static final String INFORMATION = """

        Description:
            An underground railway system is keeping track of customer travel times between different stations.
                They are using this data to calculate the average time it takes to travel from one station to another.

            Implement the UndergroundSystem class:
                * void checkIn(int id, string stationName, int t)
                    * A customer with a card ID equal to id, checks in at the station stationName at time t.
                    * A customer can only be checked into one place at a time.
                * void checkOut(int id, string stationName, int t)
                    * A customer with a card ID equal to id, checks out from the station stationName at time t.
                * double getAverageTime(string startStation, string endStation)
                    * Returns the average time it takes to travel from startStation to endStation.
                    * The average time is computed from all the previous traveling times from startStation to endStation that happened directly,
                      meaning a check in at startStation followed by a check out from endStation.
                    * The time it takes to travel from startStation to endStation may be different from the time
                      it takes to travel from endStation to startStation.
                    * There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.

            You may assume all calls to the checkIn and checkOut methods are consistent.
                If a customer checks in at time t1 then checks out at time t2, then t1 < t2.
                All events happen in chronological order.

        Example:
            Input
                ["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
                [[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton","Paradise"]]
            Output
                [null,null,null,5.00000,null,null,5.50000,null,null,6.66667]
            Explanation
                UndergroundSystem undergroundSystem = new UndergroundSystem();
                undergroundSystem.checkIn(10, "Leyton", 3);
                undergroundSystem.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
                undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000, (5) / 1 = 5
                undergroundSystem.checkIn(5, "Leyton", 10);
                undergroundSystem.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
                undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000, (5 + 6) / 2 = 5.5
                undergroundSystem.checkIn(2, "Leyton", 21);
                undergroundSystem.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
                undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667, (5 + 6 + 9) / 3 = 6.66667""";

    public DesignUndergroundSystem(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("UndergroundSystem", null));

        int len = random.nextInt(1, LEN + 1);
        String[] stations = new String[len];
        for (int i = 0; i < len; i++) {
            stations[i] = Month.values()[i].name();
        }

        int calls = random.nextInt(1, CALLS + 1);
        for (int i = 0; i < calls; i++) {
            if (random.nextInt(0, 5) == 0) {
                Object[] path = new Object[] {
                    stations[random.nextInt(0, stations.length)],
                    stations[random.nextInt(0, stations.length)]
                };
                operations.add(new AbstractMap.SimpleEntry<>("getAverageTime", path));
            } else {
                int id = random.nextInt(1, VALUE + 1);
                Object[] checkIn = new Object[] {
                    id,
                    stations[random.nextInt(0, stations.length)],
                    random.nextInt(1, VALUE + 1)
                };
                operations.add(new AbstractMap.SimpleEntry<>("checkIn", checkIn));
                Object[] checkOut = new Object[] {
                    id,
                    stations[random.nextInt(0, stations.length)],
                    random.nextInt(1, VALUE + 1)
                };
                operations.add(new AbstractMap.SimpleEntry<>("checkOut", checkOut));
            }
        }

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 36289 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 30858 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 14489 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
