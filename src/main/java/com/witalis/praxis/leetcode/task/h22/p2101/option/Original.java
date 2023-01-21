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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] bombs;

    public Integer process() {
        return maximumDetonation(bombs);
    }

    record Bomb(UUID id, int x, int y, int radius, List<Bomb> range) {
        public static final int X_COORDINATE = 0;
        public static final int Y_COORDINATE = 1;
        public static final int RADIUS = 2;

        public Bomb (int[] bomb) {
            this(UUID.randomUUID(), bomb[X_COORDINATE], bomb[Y_COORDINATE], bomb[RADIUS], new ArrayList<>());
        }

        public boolean inRange(Bomb bomb) {
            long distance = (long) (bomb.x - x) * (bomb.x - x) + (long) (bomb.y - y) * (bomb.y - y);

            return distance <= (long) radius * radius;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bomb bomb = (Bomb) o;
            return x == bomb.x && y == bomb.y && radius == bomb.radius && Objects.equals(id, bomb.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, x, y, radius);
        }
    }

    public int maximumDetonation(int[][] bombs) {
        if (bombs == null || bombs.length == 0) return 0;

        int len = bombs.length;
        final Bomb[] allBombs = new Bomb[len];
        for (int i = 0; i < len; i++) {
            allBombs[i] = new Bomb(bombs[i]);
        }

        Bomb bomb1;
        Bomb bomb2;
        for (int i = 0; i < len; i++) {
            bomb1 = allBombs[i];
            for (int j = i + 1; j < len; j++) {
                bomb2 = allBombs[j];
                if (bomb1.inRange(bomb2)) bomb1.range().add(bomb2);
                if (bomb2.inRange(bomb1)) bomb2.range().add(bomb1);
            }
        }

        int max = 0;
        for (final Bomb bomb : allBombs) {
            max = Math.max(max, dfs(bomb, new HashSet<>()));
        }

        return max;
    }

    private int dfs(Bomb bomb, Set<Bomb> visit) {
        if (visit.contains(bomb)) return 0;

        visit.add(bomb);
        int count = 1;
        for (final Bomb bombInRange : bomb.range()) {
            count += dfs(bombInRange, visit);
        }
        return count;
    }
}
