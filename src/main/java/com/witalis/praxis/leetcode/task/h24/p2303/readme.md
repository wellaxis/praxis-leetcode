# [LeetCode][leetcode] task # 2303: [Calculate Amount Paid in Taxes][task]

Description
-----------

> You are given a **0-indexed** 2D integer array `brackets` where `brackets[i] = [upper[i], percent[i]]` means
> that the `i^th` tax bracket has an upper bound of `upper[i]` and is taxed at a rate of `percent[i]`.
> The brackets are **sorted** by upper bound (i.e. `upper[i-1] < upper[i]` for `0 < i < brackets.length)`.
> 
> Tax is calculated as follows:
> * The first `upper[0]` dollars earned are taxed at a rate of `percent[0]`.
> * The next `upper[1] - upper[0]` dollars earned are taxed at a rate of `percent[1]`.
> * The next `upper[2] - upper[1]` dollars earned are taxed at a rate of `percent[2]`.
> * And so on.
>
> You are given an integer `income` representing the amount of money you earned.
> Return _the amount of money that you have to pay in taxes_.
> Answers within `10^-5` of the actual answer will be accepted.

 Example
-------

```sh
Input: brackets = [[3,50],[7,10],[12,25]], income = 10
Output: 2.65000
Explanation:
    Based on your income, you have 3 dollars in the 1st tax bracket, 4 dollars in the 2nd tax bracket, and 3 dollars in the 3rd tax bracket.
    The tax rate for the three tax brackets is 50%, 10%, and 25%, respectively.
    In total, you pay $3 * 50% + $4 * 10% + $3 * 25% = $2.65 in taxes.
```

Solution
--------

| Task | Solution                                   |
|:----:|:-------------------------------------------|
| 2303 | [Calculate Amount Paid in Taxes][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/calculate-amount-paid-in-taxes/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h24/p2303/option/Practice.java>
