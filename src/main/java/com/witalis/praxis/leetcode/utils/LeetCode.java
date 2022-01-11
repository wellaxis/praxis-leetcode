package com.witalis.praxis.leetcode.utils;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface LeetCode {
    int id() default 0;
    String description() default "The leetCode task";
    TaskDifficulty difficulty() default TaskDifficulty.EASY;
    TaskTag[] tags() default {};
}
