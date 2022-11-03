# [LeetCode][leetcode] task # 65: [Valid Number][task]

Description
-----------

> A **valid number** can be split up into these components (in order):
> 1. A **decimal number** or an **integer**.
> 2. (Optional) An `'e'` or `'E'`, followed by an **integer**.
>
> A **decimal number** can be split up into these components (in order):
> 1. (Optional) A sign character (either `'+'` or `'-'`).
> 2. One of the following formats:
>> 1. One or more digits, followed by a dot `'.'`.
>> 2. One or more digits, followed by a dot `'.'`, followed by one or more digits.
>> 3. A dot `'.'`, followed by one or more digits.
>
> An integer can be split up into these components (in order):
> 1. (Optional) A sign character (either `'+'` or `'-'`).
> 2. One or more digits.
> 
> For example, all the following are valid numbers: 
> `["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]`,
> while the following are not valid numbers: `["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]`.
> 
> Given a string `s`, return `true` _if `s` is a **valid number**_.

Example
-------

```sh
Input: s = "0"
Output: true
```

Solution
--------

| Task | Solution                 |
|:----:|:-------------------------|
|  65  | [Valid Number][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/valid-number/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h1/p65/option/Practice.java>
