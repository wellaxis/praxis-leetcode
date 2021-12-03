package com.witalis.praxis.leetcode.utils;

import com.witalis.praxis.leetcode.task.ITask;
import com.witalis.praxis.leetcode.task.LeetCodeTask;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

/**
 * Desc: The task utilities
 * User: Wellaxis
 * Date: 30.03.2021
 */
@Slf4j
@Data
@NoArgsConstructor
public class TaskUtils {
    private Environment environment;

    @Value("${task.type:leetcode}")
    private String type;

    @Value("${task.code:0}")
    private int code;

    @Value("${task.mode:S}")
    private String mode;

    public TaskUtils(Environment environment) {
        setEnvironment(environment);
    }

    /**
     * It searches the required task in repository and invokes it.
     * <p/>
     * @return true, if task has been finished successfully, otherwise - false
     */
    public boolean invokeTask() {
        // step #1 - verify
        var check = verification();
        if (check) {
            // step #2 - resolve
            var task = resolve();
            // step #3 - invoke
            if (Objects.nonNull(task)) {
                task.invoke();
                return true;
            }
        }
        return false;
    }

    private boolean verification() {
        assert !ObjectUtils.isEmpty(type) : "type of task should be specified";
        assert !ObjectUtils.isEmpty(code) : "code of task should be specified";
        assert !ObjectUtils.isEmpty(mode) : "mode of task should be specified";
        return true;
    }

    @SneakyThrows
    private ITask resolve() {
        final var packageName = "com.witalis.praxis.leetcode.task.p" + code;
        final var filter = new AnnotationTypeFilter(LeetCode.class);
        final var provider = new ClassPathScanningCandidateComponentProvider(
            true,
            environment
        );

        try {
            provider.addIncludeFilter(filter);
            for (BeanDefinition beanDefinition : provider.findCandidateComponents(packageName)) {
                Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());
                var marker = clazz.getAnnotation(LeetCode.class);
                if (!ObjectUtils.isEmpty(marker)) {
                    var markerId = marker.id();
                    if (code == markerId) {
                        var description = marker.description();
                        return (LeetCodeTask<?>) clazz.getDeclaredConstructor(
                            int.class, String.class, TaskRevision.class
                        ).newInstance(
                            code, description, TaskRevision.valueOf(mode)
                        );
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            log.error("Unable to resolve the task {}", type + '/' + code);
        }
        log.info("Task #{} has not been found. Maybe it's not implemented yet. Check code and try again.", code);
        return null;
    }
}
