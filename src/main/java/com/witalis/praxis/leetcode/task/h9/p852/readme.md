# [LeetCode][leetcode] task # 852: [Peak Index in a Mountain Array][task]

Description
-----------

> An array `arr` a mountain if the following properties hold:
> * `arr.length >= 3`
> * There exists some `i` with `0 < i < arr.length - 1` such that:
>   * `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
>   * `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`
>
> Given a mountain array `arr`, return _the index `i` such that
> `arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`_.
> 
> You must solve it in `O(log(arr.length))` time complexity.

 Example
-------

```sh
Input: arr = [0,10,5,2]
Output: 1
```

Solution
--------

| Task | Solution                                   |
|:----:|:-------------------------------------------|
| 852  | [Peak Index in a Mountain Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/peak-index-in-a-mountain-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h9/p852/option/Practice.java>
