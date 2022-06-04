package com.witalis.praxis.leetcode.task.h2.p134.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 134
 * Name: Gas Station
 * URL: <a href="https://leetcode.com/problems/gas-station/">Gas Station</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] gas;
    private int[] cost;

    public Integer process() {
        return canCompleteCircuit(gas, cost);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;
        if (gas.length != cost.length) throw new IllegalArgumentException("incorrect input data");

        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int check = checkCircuit(gas, cost, i);
            if (check < 0) return i;
            if (check < len - i) i += check;
        }

        return -1;
    }

    private int checkCircuit(int[] gas, int[] cost, int index) {
        gas = rotateArray(gas, index);
        cost = rotateArray(cost, index);

        int balance = 0;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            balance += gas[i] - cost[i];
            if (balance < 0) return i;
        }

        return -1;
    }

    private int[] rotateArray(int[] array, int index) {
        List<Integer> list = new ArrayList<>(IntStream.of(array).boxed().toList());
        Collections.rotate(list, -index);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
