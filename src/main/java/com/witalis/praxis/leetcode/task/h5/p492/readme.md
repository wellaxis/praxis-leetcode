# [LeetCode][leetcode] task # 492: [Construct the Rectangle][task]

Description
-----------

> A web developer needs to know how to design a web page's size.
> So, given a specific rectangular web page's area,
> your job by now is to design a rectangular web page,
> whose length `L` and width `W` satisfy the following requirements:
> 
> 1. The area of the rectangular web page you designed must equal to the given target area.
> 2. The width `W` should not be larger than the length `L`, which means `L >= W`.
> 3. The difference between length `L` and width `W` should be as small as possible.
> 
> Return _an array `[L, W]` where `L` and `W` are the length and width of the web page you designed in sequence_.

 Example
-------

```sh
Input: area = 4
Output: [2,2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
    But according to requirement 2, [1,4] is illegal;
    according to requirement 3, [4,1] is not optimal compared to [2,2].
    So the length L is 2, and the width W is 2.
```

Solution
--------

| Task | Solution                            |
|:----:|:------------------------------------|
| 492  | [Construct the Rectangle][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/construct-the-rectangle/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h5/p492/option/Practice.java>
