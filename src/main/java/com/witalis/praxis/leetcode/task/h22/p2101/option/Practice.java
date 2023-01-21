package com.witalis.praxis.leetcode.task.h22.p2101.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2101
 * Name: Detonate the Maximum Bombs
 * URL: <a href="https://leetcode.com/problems/detonate-the-maximum-bombs/">Detonate the Maximum Bombs</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] bombs;

    public Integer process() {
        return maximumDetonation(bombs);
    }

    private final Map<Integer, List<Bomb>> ranges = new HashMap<>();

    record Bomb(int id, int x, int y, int radius) {

        public boolean inRange(Bomb bomb) {
            return (long) (bomb.x - x) * (bomb.x - x) + (long) (bomb.y - y) * (bomb.y - y) <= (long) radius * radius;
        }
    }

    public int maximumDetonation(int[][] bombs) {
        if (bombs == null || bombs.length == 0) return 0;

        int len = bombs.length;
        final Bomb[] allBombs = new Bomb[len];
        for (int i = 0; i < len; i++) {
            allBombs[i] = new Bomb(i, bombs[i][0], bombs[i][1], bombs[i][2]);
            ranges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (allBombs[i].inRange(allBombs[j])) ranges.get(i).add(allBombs[j]);
                if (allBombs[j].inRange(allBombs[i])) ranges.get(j).add(allBombs[i]);
            }
        }

        int max = 0;
        for (final Bomb bomb : allBombs) {
            max = Math.max(max, dfs(bomb, new boolean[len]));
        }

        return max;
    }

    private int dfs(Bomb bomb, boolean[] visit) {
        if (visit[bomb.id]) return 0;

        visit[bomb.id] = true;
        int count = 1;
        for (final Bomb bombInRange : ranges.get(bomb.id)) {
            count += dfs(bombInRange, visit);
        }
        return count;
    }
}
