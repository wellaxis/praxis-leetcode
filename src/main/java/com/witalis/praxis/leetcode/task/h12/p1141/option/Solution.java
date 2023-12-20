package com.witalis.praxis.leetcode.task.h12.p1141.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1141
 * Name: User Activity for the Past 30 Days I
 * URL: <a href="https://leetcode.com/problems/user-activity-for-the-past-30-days-i/">User Activity for the Past 30 Days I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return pastUserActivities();
    }

    public String pastUserActivities() {
        return
            """

            SELECT TO_CHAR(activity_date, 'YYYY-MM-DD') AS day,
                   COUNT(DISTINCT user_id) AS active_users
            FROM   activity
            GROUP BY activity_date
            HAVING MIN(activity_date)>= '2019-06-28' AND MAX(activity_date)<= '2019-07-27'

            """;
    }
}
