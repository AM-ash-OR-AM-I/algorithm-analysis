"""
Find min. element in array in O(logn), using binary search
"""

from typing import List


def find_min(a: List[int]) -> int:
    n = len(a)
    lo = 0
    hi = n - 1
    mid = (lo + hi) // 2
    while mid < n - 1:
        mid = (lo + hi) // 2
        x = a[mid]
        if mid == n - 1 or (x < a[mid + 1] and x < a[mid - 1]):
            return x
        elif x < a[mid - 1] and x > a[mid + 1]:
            lo = mid + 1
        else:
            hi = mid - 1
    return a[n - 1]


def find_max(a: List[int]) -> int:
    n = len(a)
    lo = 0
    hi = n - 1
    mid = (lo + hi) // 2
    while mid < n - 1:
        mid = (lo + hi) // 2
        x = a[mid]
        if mid == n - 1 or (x > a[mid + 1] and x > a[mid - 1]):
            return x
        elif x > a[mid - 1] and x < a[mid + 1]:
            lo = mid + 1
        else:
            hi = mid - 1
    return a[n - 1]

a1 = [23432, 2343, 23, 10, 9, 2, 324231, 324234234, 23421342315432]
# Rotated Array
a2 = [20, 234, 2342, 1, 10]
print("min = ", find_min(a1))
print("max = ", find_max(a2))
