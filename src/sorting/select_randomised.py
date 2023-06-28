import math
from random import randint
from typing import List

import numpy as np


def optimized_select(s: List[int], k: int) -> int:
    """
    Returns the kth smallest element in s.
    """
    global iterations
    pivot = s[randint(0, len(s) - 1)]
    s1 = []
    s2 = []
    for x in s:
        iterations += 1
        if x < pivot:
            s1.append(x)
        elif x > pivot:
            s2.append(x)
    if (l := len(s1)) < k - 1:
        return optimized_select(s2, k - l - 1)
    elif len(s1) == k - 1:
        return pivot
    elif len(s1) > k - 1:
        return optimized_select(s1, k)


def optimized_select_largest(s: List[int], k: int) -> int:
    """
    Returns the kth largest element in s.
    """
    return optimized_select(s, len(s) - k + 1)


def quick_select(arr: List[int], begin: int, end: int, k: int) -> int:
    def swap(i, j):
        arr[i], arr[j] = arr[j], arr[i]

    def partition() -> int:
        global iterations
        rand_index = randint(begin, end)
        swap(rand_index, end)
        pivot = arr[end]
        i = begin - 1
        for j in range(begin, end):
            iterations += 1
            if arr[j] < pivot:
                i += 1
                swap(i, j)
        i += 1
        swap(i, end)
        return i

    if begin < end:
        index = partition()
        if index == k - 1:
            return arr[index]
        elif index < k - 1:
            return quick_select(arr, index + 1, end, k)
        else:
            return quick_select(arr, begin, index - 1, k)
    else:
        return arr[begin]


def run_all_testcases():
    global iterations
    for _ in range(1):
        a = np.random.permutation(10**5)
        n = len(a)
        print(f"{n = }")
        for _ in range(3):
            k = randint(1, n)
            iterations = 0
            element1 = optimized_select(a, k)
            ratio1 = iterations / n
            optimized_select_ratio.append(ratio1)
            iterations = 0
            element2 = quick_select(a, 0, n - 1, k)
            ratio2 = iterations / n
            quick_select_ratio.append(ratio2)
            assert element1 == element2
    print(f"{optimized_select_ratio = }")
    print(f"{quick_select_ratio = }")
    print(f"{np.mean(optimized_select_ratio) = }")
    print(f"{np.mean(quick_select_ratio) = }")
    # print(f"{np.std(coefficent_arr) = }")
    # print(f"{np.std(log_ratio) = }")
    print(f"{np.min(optimized_select_ratio) = }")
    print(f"{np.max(optimized_select_ratio) = }")
    print(f"{np.min(quick_select_ratio) = }")
    print(f"{np.max(quick_select_ratio) = }")


optimized_select_ratio = []
quick_select_ratio = []

if __name__ == "__main__":
    iterations = 0
    # run_all_testcases()
    a = np.random.permutation(10**5)
    print(a)
    print(optimized_select_largest(a, 11000))
