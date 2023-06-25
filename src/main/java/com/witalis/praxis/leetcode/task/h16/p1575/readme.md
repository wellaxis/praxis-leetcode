# [LeetCode][leetcode] task # 1575: [Count All Possible Routes][task]

Description
-----------

> You are given an array of **distinct** positive integers `locations`
> where `locations[i]` represents the position of city `i`.
> You are also given integers `start`, `finish` and `fuel`
> representing the starting city, ending city, and the initial amount of fuel you have, respectively.
> 
> At each step, if you are at city `i`, you can pick any city `j` such
> that `j != i` and `0 <= j < locations.length` and move to city `j`.
> Moving from city `i` to city `j` reduces the amount of fuel you have by `|locations[i] - locations[j]|`.
> Please notice that `|x|` denotes the absolute value of `x`.
> 
> Notice that `fuel` **cannot** become negative at any point in time,
> and that you are **allowed** to visit any city more than once (including `start` and `finish`).
> 
> Return _the count of all possible routes from `start` to `finish`_.
> Since the answer may be too large, return it **modulo** `10^9 + 7`.

Example
-------

```sh
Input: locations = [4,3,1], start = 1, finish = 0, fuel = 6
Output: 5
Explanation: The following are all possible routes:
    1 -> 0, used fuel = 1
    1 -> 2 -> 0, used fuel = 5
    1 -> 2 -> 1 -> 0, used fuel = 5
    1 -> 0 -> 1 -> 0, used fuel = 3
    1 -> 0 -> 1 -> 0 -> 1 -> 0, used fuel = 5
```

Solution
--------

| Task | Solution                              |
|:----:|:--------------------------------------|
| 1575 | [Count All Possible Routes][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/count-all-possible-routes/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h16/p1575/option/Practice.java>
