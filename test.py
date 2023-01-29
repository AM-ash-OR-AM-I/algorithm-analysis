"""
Remove One (Public Contest: CodeRush-X)
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Consider the integer sequence A = {1, 2, 3, ...., N} i.e. the first N natural numbers in order.

You are now given two integers, L and S. Determine whether there exists a subarray with length L and sum S after removing at most one element from A.

A subarray of an array is a non-empty sequence obtained by removing zero or more elements from the front of the array, and zero or more elements from the back of the array.
Input
The first line contains a single integer T, the number of test cases.
T lines follow. Each line describes a single test case and contains three integers: N, L, and S.

INPUT:
3
5 3 11
5 3 5
5 3 6

OUTPUT:
YES
NO
YES

1 <= T <= 100
2 <= N <= 10^9
1 <= L <= N-1
1 <= S <= 10^18 (Note that S will not fit in a 32-bit integer)
"""

# Your code here
for _ in range(int(input())):
    n, l, s = map(int, input().split())
    sum1 = int(l * ((l + 1) / 2))
    max_poss = l * (n - l) + sum1 
    diff = s - sum1
    if s <= max_poss and diff >= 0 and diff % l in (0, l - 1):
        print("YES")
    else:
        print("NO")
