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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    class CheckIn {
        public String stationName;
        public int time;

        public CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    class CheckOut {
        public int numTrips;
        public int totalTime;

        public CheckOut(int numTrips, int totalTime) {
            this.numTrips = numTrips;
            this.totalTime = totalTime;
        }
    }

    public class UndergroundSystem implements IUndergroundSystem {
        private Map<Integer, CheckIn> checkIns;
        private Map<String, CheckOut> checkOuts;

        public UndergroundSystem() {
            this.checkIns = new HashMap<>();
            this.checkOuts = new HashMap<>();
        }

        @Override
        public void checkIn(int id, String stationName, int t) {
            checkIns.put(id, new CheckIn(stationName, t));
        }

        @Override
        public void checkOut(int id, String stationName, int t) {
            final CheckIn checkIn = checkIns.get(id);
            checkIns.remove(id);
            final String route = checkIn.stationName + "->" + stationName;
            checkOuts.putIfAbsent(route, new CheckOut(0, 0));
            ++checkOuts.get(route).numTrips;
            checkOuts.get(route).totalTime += t - checkIn.time;
        }

        @Override
        public double getAverageTime(String startStation, String endStation) {
            final CheckOut checkOut = checkOuts.get(startStation + "->" + endStation);
            return checkOut.totalTime / (double) checkOut.numTrips;
        }
    }

    public List<Double> process() {
        return UndergroundSystemHandler.process(operations, new UndergroundSystem());
    }
}
