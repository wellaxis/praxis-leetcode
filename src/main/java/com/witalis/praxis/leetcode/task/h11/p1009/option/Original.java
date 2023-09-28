package com.witalis.praxis.leetcode.task.h11.p1009.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1009
 * Name: Complement of Base 10 Integer
 * URL: <a href="https://leetcode.com/problems/complement-of-base-10-integer/">Complement of Base 10 Integer</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return bitwiseComplement(number);
    }

    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        binary = binary
            .replaceAll("0", "2")
            .replaceAll("1", "0")
            .replaceAll("2", "1");
        return Integer.parseInt(binary, 2);
    }
}
