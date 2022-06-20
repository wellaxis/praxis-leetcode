package com.witalis.praxis.leetcode.task.h5.p401.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 401
 * Name: Binary Watch
 * URL: <a href="https://leetcode.com/problems/binary-watch/">Binary Watch</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int turnedOn;

    public List<String> process() {
        return readBinaryWatch(turnedOn);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0) return Collections.emptyList();

        Set<String> times = new HashSet<>();

        for (int hours = 0; hours < 12; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (Integer.bitCount(hours) + Integer.bitCount(minutes) == turnedOn) {
                    times.add(String.format("%d:%02d", hours, minutes));
                }
            }
        }

        return new ArrayList<>(times);
    }
}
