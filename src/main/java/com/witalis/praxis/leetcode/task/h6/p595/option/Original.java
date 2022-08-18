package com.witalis.praxis.leetcode.task.h6.p595.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 595
 * Name: Big Countries
 * URL: <a href="https://leetcode.com/problems/big-countries/">Big Countries</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return bigCountries();
    }

    public String bigCountries() {
        return
            """
            SELECT w.name AS "name",
                   w.population AS "population",
                   w.area AS "area"
            FROM   world w
            WHERE  NVL(w.area, 0) >= 3000000
            OR     NVL(w.population, 0) >= 25000000

            """;
    }
}
