from random import randint
from typing import List


def quick_sort(arr: List[int], begin, end):
    def swap(i, j):
        arr[i], arr[j] = arr[j], arr[i]

    def partition() -> int:
        index = randint(begin, end)
        swap(index, end)
        pivot = arr[end]
        i = begin - 1
        for j in range(begin, end):
            if arr[j] < pivot:
                i += 1
                swap(i, j)
        i += 1
        swap(i, end)
        return i

    if begin < end:
        index = partition()
        quick_sort(arr, begin, index - 1)
        quick_sort(arr, index + 1, end)


def optimized_sort(s: List[int]) -> int:
    pivot = s[randint(0, len(s) - 1)]
    s1 = []
    s2 = []
    for x in s:
        if x < pivot:
            s1.append(x)
        elif x > pivot:
            s2.append(x)
    optimized_sort(s2)
    optimized_sort(s1)
    