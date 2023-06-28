import math
from random import randint
from timeit import timeit
from typing import List

import numpy as np


def select_randomised(s: List[int], k: int) -> int:
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
        return select_randomised(s2, k - l - 1)
    elif len(s1) == k - 1:
        return pivot
    elif len(s1) > k - 1:
        return select_randomised(s1, k)


def optimized_select_randomised(s: List[int], k: int) -> int:
    """
    Returns the kth smallest element in s.
    """
    global iterations
    n = len(s)

    """
    If the size of the partition is less than n/4, then central splitter is not found.
    
    The expected number of trials before a central splitter is found is 2.
    """
    if len(s) <= 4:
        return s[0]
    while True:
        s1 = []
        s2 = []
        pivot = s[randint(0, n - 1)]
        for x in s:
            iterations += 1
            if x < pivot:
                s1.append(x)
            elif x > pivot:
                s2.append(x)
        if len(s1) > n / 4 and len(s2) > n / 4:
            break

    n1, n2 = len(s1), len(s2)

    if n1 < k - 1:
        return optimized_select_randomised(s2, k - n1 - 1)
    elif n1 == k - 1:
        return pivot
    elif n1 > k - 1:
        return optimized_select_randomised(s1, k)


def select_largest(s: List[int], k: int) -> int:
    """
    Returns the kth largest element in s.
    """
    return select_randomised(s, len(s) - k + 1)


def quick_select_randomised(arr: List[int], begin: int, end: int, k: int) -> int:
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
            return quick_select_randomised(arr, index + 1, end, k)
        else:
            return quick_select_randomised(arr, begin, index - 1, k)
    else:
        return arr[begin]


def run_all_testcases():
    """
    NOTE: From my observations, the `select_randomised()` function even though technically,
    less efficient than the `optimized_select_randomised()` function, it seems that worst case
    scenarios are very rare. Hence, the `optimized_select_randomised()` function is not showing
    any significant improvement over the `select_randomised()` function.
    """
    global iterations
    for _ in range(1000):
        a = np.random.randint(0, 10**6, size=200)
        a = list(set(a))
        n = len(a)
        for _ in range(20):
            k = randint(1, n)

            optimized_time = timeit(lambda: optimized_select_randomised(a, k), number=2)
            optimized_select_times.append(optimized_time)

            select_time = timeit(lambda: select_randomised(a, k), number=2)
            select_times.append(select_time)

            quick_select_time = timeit(
                lambda: quick_select_randomised(a, 0, n - 1, k), number=2
            )
            quick_select_times.append(quick_select_time)

    # print(f"{select_ratio = }")
    # print(f"{optimized_select_ratio = }")
    # print(f"{quick_select_ratio = }")
    # print(f"{np.mean(select_ratio) = }")
    # print(f"{np.mean(optimized_select_ratio) = }")
    # print(f"{np.mean(quick_select_ratio) = }")
    # print(f"{np.min(select_ratio) = }")
    print(f"{np.max(select_times) = }")
    print(f"{np.max(optimized_select_times) = }")
    print(f"{np.max(quick_select_times) = }")
    print(f"{np.max(select_times)-np.min(select_times) = }")
    print(f"{np.max(optimized_select_times)-np.min(optimized_select_times) = }")
    print(f"{np.max(quick_select_times)-np.min(quick_select_times) = }")
    # print(f"{np.min(optimized_select_ratio) = }")
    # print(f"{np.min(quick_select_ratio) = }")


select_times = []
optimized_select_times = []
quick_select_times = []

if __name__ == "__main__":
    iterations = 0
    run_all_testcases()
