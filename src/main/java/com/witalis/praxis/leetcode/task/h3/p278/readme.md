# [LeetCode][leetcode] task # 278: [First Bad Version][task]

Description
-----------

> You are a product manager and currently leading a team to develop a new product.
> Unfortunately, the latest version of your product fails the quality check.
> Since each version is developed based on the previous version,
> all the versions after a bad version are also bad.
> 
> Suppose you have `n` versions `[1, 2, ..., n]` and you want to find out
> the first bad one, which causes all the following ones to be bad.
> 
> You are given an API `bool` `isBadVersion(version)` which returns
> whether version is bad. Implement a function to find the first bad version.
> You should minimize the number of calls to the API.

 Example
-------

```sh
Input: n = 5, bad = 4
Output: 4
Explanation:
    call isBadVersion(3) -> false
    call isBadVersion(5) -> true
    call isBadVersion(4) -> true
    Then 4 is the first bad version.
```

Solution
--------

| Task | Solution                      |
|:----:|:------------------------------|
| 278  | [First Bad Version][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/first-bad-version/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h3/p278/option/Practice.java>
