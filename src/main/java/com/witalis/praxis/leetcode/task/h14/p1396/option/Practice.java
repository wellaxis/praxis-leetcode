package com.witalis.praxis.leetcode.task.h14.p1396.option;

import com.witalis.praxis.leetcode.task.h14.p1396.content.IUndergroundSystem;
import com.witalis.praxis.leetcode.task.h14.p1396.content.UndergroundSystemHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 1396
 * Name: Design Underground System
 * URL: <a href="https://leetcode.com/problems/design-underground-system/">Design Underground System</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    record Moving(String stationName, int duration) {}
    record Path(String startStation, String endStation) {}

    public class UndergroundSystem implements IUndergroundSystem {
        private final Map<Integer, Moving> checkIns;
        private final Map<Path, int[]> times;

        public UndergroundSystem() {
            this.checkIns = new HashMap<>();
            this.times = new HashMap<>();
        }

        @Override
        public void checkIn(int id, String stationName, int t) {
            checkIns.put(id, new Moving(stationName, t));
        }

        @Override
        public void checkOut(int id, String stationName, int t) {
            var startStation = checkIns.get(id).stationName();
            var startTime = checkIns.get(id).duration();
            checkIns.remove(id);

            var path = new Path(startStation, stationName);
            var totalTime = times.containsKey(path) ? times.get(path)[0] : 0;
            var dataPoints = times.containsKey(path) ? times.get(path)[1] : 0;

            times.put(path, new int[] {totalTime + t - startTime, dataPoints + 1});
        }

        @Override
        public double getAverageTime(String startStation, String endStation) {
            var path = new Path(startStation, endStation);

            return (double) times.get(path)[0] / times.get(path)[1];
        }
    }

    public List<Double> process() {
        return UndergroundSystemHandler.process(operations, new UndergroundSystem());
    }
}
