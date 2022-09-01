package com.witalis.praxis.leetcode.task.h6.p596.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 596
 * Name: Classes More Than 5 Students
 * URL: <a href="https://leetcode.com/problems/classes-more-than-5-students/">Classes More Than 5 Students</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return classesMoreThanFiveStudents();
    }

    public String classesMoreThanFiveStudents() {
        return
            """

            SELECT c.class as "class"
            FROM   courses c
            GROUP BY c.class
            HAVING COUNT(*) >= 5

            """;
    }
}
