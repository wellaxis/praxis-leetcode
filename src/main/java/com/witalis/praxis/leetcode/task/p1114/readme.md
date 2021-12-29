# [LeetCode][leetcode] task # 1114: [Print in Order][task]

Description
-----------

> Suppose we have a class:
> ```sh
> public class Foo {
>     public void first() { print("first"); }
>     public void second() { print("second"); }
>     public void third() { print("third"); }
> }
> ```
> 
> The same instance of `Foo` will be passed to three different threads.
> Thread A will call `first()`, thread B will call `second()`,
> and thread C will call `third()`. Design a mechanism and modify
> the program to ensure that `second()` is executed after `first()`,
> and `third()` is executed after `second()`.
> 
> **Note:**
> 
> We do not know how the threads will be scheduled in the operating system,
> even though the numbers in the input seem to imply the ordering.
> The input format you see is mainly to ensure our tests' comprehensiveness.

Example
-------

```sh
Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously.
    The input [1,2,3] means thread A calls first(),
    thread B calls second(), and thread C calls third().
    "firstsecondthird" is the correct output.
```

Solution
--------

| Task | Solution                   |
|:----:|:---------------------------|
| 1114 | [Print in Order][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/print-in-order>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/p1114/option/Practice.java>
