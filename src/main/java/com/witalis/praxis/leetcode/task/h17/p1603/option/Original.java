package com.witalis.praxis.leetcode.task.h17.p1603.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1603
 * Name: Design Parking System
 * URL: <a href="https://leetcode.com/problems/design-parking-system/">Design Parking System</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int big;
    private int medium;
    private int small;
    private int[] attempts;

    public boolean[] process() {
        ParkingSystem parkingSystem = new ParkingSystem(big, medium, small);
        return parkingScenario(parkingSystem, attempts);
    }

    class ParkingSystem {
        private int[] slots;

        public ParkingSystem(int big, int medium, int small) {
            this.slots = new int[] {big, medium, small};
        }

        public boolean addCar(int carType) {
            if (carType < 1 || carType > 3) return false;

            if (slots[carType - 1] > 0) {
                slots[carType - 1]--;
                return true;
            }
            return false;
        }
    }

    public boolean[] parkingScenario(ParkingSystem parkingSystem, int[] attempts) {
        if (parkingSystem == null || attempts == null) return new boolean[0];

        boolean[] result = new boolean[attempts.length];
        for (int i = 0; i < attempts.length; i++) {
            result[i] = parkingSystem.addCar(attempts[i]);
        }

        return result;
    }
}
