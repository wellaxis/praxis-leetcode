package com.witalis.praxis.leetcode.task.h14.p1396.content;

/**
 * Desc: Underground system interface.
 * User: Wellaxis
 * Date: 05/31/2023
 */
public interface IUndergroundSystem {
    void checkIn(int id, String stationName, int t);
    void checkOut(int id, String stationName, int t);
    double getAverageTime(String startStation, String endStation);
}
