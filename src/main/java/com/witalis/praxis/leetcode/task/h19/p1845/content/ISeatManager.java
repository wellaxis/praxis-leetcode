package com.witalis.praxis.leetcode.task.h19.p1845.content;

/**
 * Desc: Seat manager interface.
 * User: Wellaxis
 * Date: 6/11/2023
 */
public interface ISeatManager {
    int reserve();
    void unreserve(int seatNumber);
}
