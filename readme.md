#                        Leetcode Tasks

Goal of project
---------------

> It is necessary to resolve and develop
> the different exercises (Java, SQL, Kotlin)
> under [LeetCode][leetcode] tasks.
***

Installation
------------

It's required to set up application environment variables:
```sh
$ JAVA_HOME = [path]\java\jdk{version}
$ LEETCODE_HOME = [path]\praxis-leetcode
```
***

Invocation
----------

To invoke the required Leetcode's task it's necessary to specify
task properties into `application.yml` configuration file:
```yml
task:
  type: leetcode
  code: 25
  mode: B
```
In this case we run LeetCode's task #25 in `B` mode.

> There are 4 modes:
* O: `Original` - the real test solution (code writing with timing)
* P: `Practice` - try to find the better solution (without timing)
* S: `Solution` - the best found solution (external programming)
* B: `Benchmark` - the benchmark mode (to compare O,P,S results)
***

## Leetcode
|   ID | Task                                                                                                                                                                    | Status |                                        Practice                                        |                                        Solution                                        |
|-----:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:------:|:--------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------:|
|    1 | [Two Sum](https://leetcode.com/problems/two-sum/)                                                                                                                       |  Easy  |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p1/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p1/option/Solution.java)   |
|    2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)                                                                                                       | Medium |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p2/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p2/option/Solution.java)   |
|    3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)                                         | Medium |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p3/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p3/option/Solution.java)   |
|    4 | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)                                                                               |  Hard  |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p4/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p4/option/Solution.java)   |
|    5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)                                                                           | Medium |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p5/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p5/option/Solution.java)   |
|    6 | [Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/)                                                                                                   | Medium |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p6/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p6/option/Solution.java)   |
|    7 | [Reverse Integer](https://leetcode.com/problems/reverse-integer/)                                                                                                       | Medium |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p7/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p7/option/Solution.java)   |
|    8 | [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)                                                                                       | Medium |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p8/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p8/option/Solution.java)   |
|    9 | [Palindrome Number](https://leetcode.com/problems/palindrome-number/)                                                                                                   |  Easy  |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p9/option/Practice.java)   |   [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p9/option/Solution.java)   |
|   10 | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)                                                                               |  Hard  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p10/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p10/option/Solution.java)   |
|   11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)                                                                                   | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p11/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p11/option/Solution.java)   |
|   12 | [Integer to Roman](https://leetcode.com/problems/integer-to-roman/)                                                                                                     | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p12/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p12/option/Solution.java)   |
|   13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/)                                                                                                     |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p13/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p13/option/Solution.java)   |
|   14 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)                                                                                           |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p14/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p14/option/Solution.java)   |
|   15 | [3Sum](https://leetcode.com/problems/3sum/)                                                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p15/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p15/option/Solution.java)   |
|   16 | [3Sum Closest](https://leetcode.com/problems/3sum-closest/)                                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p16/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p16/option/Solution.java)   |
|   17 | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)                                                           | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p17/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p17/option/Solution.java)   |
|   18 | [4Sum](https://leetcode.com/problems/4sum/)                                                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p18/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p18/option/Solution.java)   |
|   19 | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)                                                                     | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p19/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p19/option/Solution.java)   |
|   20 | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)                                                                                                   |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p20/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p20/option/Solution.java)   |
|   21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)                                                                                         |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p21/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p21/option/Solution.java)   |
|   22 | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p22/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p22/option/Solution.java)   |
|   23 | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)                                                                                             |  Hard  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p23/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p23/option/Solution.java)   |
|   24 | [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)                                                                                               | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p24/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p24/option/Solution.java)   |
|   25 | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)                                                                                     |  Hard  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p25/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p25/option/Solution.java)   |
|   26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)                                                               |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p26/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p26/option/Solution.java)   |
|   27 | [Remove Element](https://leetcode.com/problems/remove-element/)                                                                                                         |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p27/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p27/option/Solution.java)   |
|   28 | [Implement strStr()](https://leetcode.com/problems/implement-strstr/)                                                                                                   |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p28/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p28/option/Solution.java)   |
|   29 | [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)                                                                                               | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p29/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p29/option/Solution.java)   |
|   30 | [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)                                                   |  Hard  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p30/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p30/option/Solution.java)   |
|   31 | [Next Permutation](https://leetcode.com/problems/next-permutation/)                                                                                                     | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p31/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p31/option/Solution.java)   |
|   33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)                                                                         | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p33/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p33/option/Solution.java)   |
|   34 | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)                       | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p34/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p34/option/Solution.java)   |
|   35 | [Search Insert Position](https://leetcode.com/problems/search-insert-position/)                                                                                         |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p35/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p35/option/Solution.java)   |
|   36 | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)                                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p36/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p36/option/Solution.java)   |
|   38 | [Count and Say](https://leetcode.com/problems/count-and-say/)                                                                                                           | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p38/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p38/option/Solution.java)   |
|   39 | [Combination Sum](https://leetcode.com/problems/combination-sum/)                                                                                                       | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p39/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p39/option/Solution.java)   |
|   40 | [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)                                                                                                 | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p40/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p40/option/Solution.java)   |
|   43 | [Multiply Strings](https://leetcode.com/problems/multiply-strings/)                                                                                                     | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p43/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p43/option/Solution.java)   |
|   45 | [Jump Game II](https://leetcode.com/problems/jump-game-ii/)                                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p45/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p45/option/Solution.java)   |
|   46 | [Permutations](https://leetcode.com/problems/permutations/)                                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p46/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p46/option/Solution.java)   |
|   47 | [Permutations II](https://leetcode.com/problems/permutations-ii/)                                                                                                       | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p47/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p47/option/Solution.java)   |
|   48 | [Rotate Image](https://leetcode.com/problems/rotate-image/)                                                                                                             | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p48/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p48/option/Solution.java)   |
|   50 | [Pow(x, n)](https://leetcode.com/problems/powx-n/)                                                                                                                      | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p50/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p50/option/Solution.java)   |
|   53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)                                                                                                     |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p53/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p53/option/Solution.java)   |
|   55 | [Jump Game](https://leetcode.com/problems/jump-game/)                                                                                                                   | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p55/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p55/option/Solution.java)   |
|   57 | [Insert Interval](https://leetcode.com/problems/insert-interval/)                                                                                                       | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p57/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p57/option/Solution.java)   |
|   58 | [Length of Last Word](https://leetcode.com/problems/length-of-last-word/)                                                                                               |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p58/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p58/option/Solution.java)   |
|   66 | [Plus One](https://leetcode.com/problems/plus-one/)                                                                                                                     |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p66/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p66/option/Solution.java)   |
|   67 | [Add Binary](https://leetcode.com/problems/add-binary/)                                                                                                                 |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p67/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p67/option/Solution.java)   |
|   69 | [Sqrt(x)](https://leetcode.com/problems/sqrtx/)                                                                                                                         |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p69/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p69/option/Solution.java)   |
|   70 | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)                                                                                                       |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p70/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p70/option/Solution.java)   |
|   71 | [Simplify Path](https://leetcode.com/problems/simplify-path/)                                                                                                           | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p71/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p71/option/Solution.java)   |
|   75 | [Sort Colors](https://leetcode.com/problems/sort-colors/)                                                                                                               | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p75/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p75/option/Solution.java)   |
|   82 | [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)                                                           | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p82/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p82/option/Solution.java)   |
|   83 | [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)                                                                 |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p83/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p83/option/Solution.java)   |
|   88 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)                                                                                                 |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p88/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p88/option/Solution.java)   |
|   94 | [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)                                                                           |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p94/option/Practice.java)   |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h1/p94/option/Solution.java)   |
|  100 | [Same Tree](https://leetcode.com/problems/same-tree/)                                                                                                                   |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p100/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p100/option/Solution.java)  |
|  101 | [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)                                                                                                         |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p101/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p101/option/Solution.java)  |
|  104 | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)                                                                             |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p104/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p104/option/Solution.java)  |
|  108 | [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)                                                 |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p108/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p108/option/Solution.java)  |
|  110 | [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)                                                                                             |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p110/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p110/option/Solution.java)  |
|  118 | [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)                                                                                                    |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p118/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p118/option/Solution.java)  |
|  121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)                                                                       |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p121/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p121/option/Solution.java)  |
|  125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)                                                                                                     |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p125/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p125/option/Solution.java)  |
|  136 | [Single Number](https://leetcode.com/problems/single-number/)                                                                                                           |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p136/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p136/option/Solution.java)  |
|  144 | [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)                                                                         |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p144/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p144/option/Solution.java)  |
|  145 | [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)                                                                       |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p145/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p145/option/Solution.java)  |
|  155 | [Min Stack](https://leetcode.com/problems/min-stack/)                                                                                                                   |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p155/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h2/p155/option/Solution.java)  |
|  175 | [Combine Two Tables](https://leetcode.com/problems/combine-two-tables/)                                                                                                 |  Easy  |  [SQL](/src/main/java/com/witalis/praxis/leetcode/task/h2/p175/option/Practice.java)   |  [SQL](/src/main/java/com/witalis/praxis/leetcode/task/h2/p175/option/Solution.java)   |
|  181 | [Employees Earning More Than Their Managers](https://leetcode.com/problems/employees-earning-more-than-their-managers/)                                                 |  Easy  |  [SQL](/src/main/java/com/witalis/praxis/leetcode/task/h2/p181/option/Practice.java)   |  [SQL](/src/main/java/com/witalis/praxis/leetcode/task/h2/p181/option/Solution.java)   |
|  206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list)                                                                                                |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h3/p206/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h3/p206/option/Solution.java)  |
|  217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)                                                                                                 |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h3/p217/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h3/p217/option/Solution.java)  |
|  233 | [Number of Digit One](https://leetcode.com/problems/number-of-digit-one/)                                                                                               |  Hard  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h3/p233/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h3/p233/option/Solution.java)  |
|  504 | [Base 7](https://leetcode.com/problems/base-7/)                                                                                                                         | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h6/p504/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h6/p504/option/Solution.java)  |
|  526 | [Beautiful Arrangement](https://leetcode.com/problems/beautiful-arrangement/)                                                                                           | Medium |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h6/p526/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h6/p526/option/Solution.java)  |
|  703 | [Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)                                                                       |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h8/p703/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h8/p703/option/Solution.java)  |
|  746 | [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)                                                                                     |  Easy  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h8/p746/option/Practice.java)  |  [Java](/src/main/java/com/witalis/praxis/leetcode/task/h8/p746/option/Solution.java)  |
| 1103 | [Distribute Candies to People](https://leetcode.com/problems/distribute-candies-to-people/)                                                                             |  Easy  | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h12/p1103/option/Practice.java) | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h12/p1103/option/Solution.java) |
| 1114 | [Print in Order](https://leetcode.com/problems/print-in-order)                                                                                                          |  Easy  | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h12/p1114/option/Practice.java) | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h12/p1114/option/Solution.java) |
| 1379 | [Find a Corresponding Node of a Binary Tree in a Clone of That Tree](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/) | Medium | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h14/p1379/option/Practice.java) | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h14/p1379/option/Solution.java) |
| 1640 | [Check Array Formation Through Concatenation](https://leetcode.com/problems/check-array-formation-through-concatenation/)                                               |  Easy  | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h17/p1640/option/Practice.java) | [Java](/src/main/java/com/witalis/praxis/leetcode/task/h17/p1640/option/Solution.java) |
***

Structure
---------

- praxis-leetcode [root application directory]
    - bin [folder contains batch files]
    - log [folder contains module logs]
    - res [folder contains results of run]
    - src [folder contains source files]
    - configuration and documentation files
***

Framework
---------

Application uses a number of open source frameworks:
* [`slf4j`, `log4j`] - for application logging
* [`lombok`] - to generate class environment
* etc
***

[leetcode]: <https://leetcode.com/>
