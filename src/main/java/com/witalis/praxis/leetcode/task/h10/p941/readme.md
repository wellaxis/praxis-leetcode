# [LeetCode][leetcode] task # 941: [Valid Mountain Array][task]

Description
-----------

> Given an array of integers `arr`, return _`true` if and only if it is a valid **mountain** array_.
> 
> Recall that `arr` is a **mountain** array if and only if:
> * `arr.length >= 3`
> * There exists some `i` with `0 < i < arr.length - 1` such that:
>   * `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
>   * `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

![array.png](image/array.png)

Example
-------

```sh
Input: arr = [0,3,2,1]
Output: true
```

Solution
--------

| Task | Solution                         |
|:----:|:---------------------------------|
| 941  | [Valid Mountain Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/valid-mountain-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h10/p941/option/Practice.java>
