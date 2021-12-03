package com.witalis.praxis.leetcode.task.p0.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: Identifier of task
 * Name: Name of task
 * URL: URL of task
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Object object;

    public Object process() {
        return processing(object);
    }

    private Object processing(Object object) {
        return object;
    }
}
