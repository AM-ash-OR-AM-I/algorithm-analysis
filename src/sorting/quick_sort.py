import random
from typing import List


def quick_sort(arr: List[int], begin, end):
    def swap(i, j):
        arr[i], arr[j] = arr[j], arr[i]

    """
    [0, 1, 3, 4, {2}]
           |______|
             swap
    [0, 1 | 2 | 4, 3]
     lo  hi    lo  hi
     
    [0, 1 | 2 | 3, 4]
                |__|
                swap
    """

    def partition() -> int:
        # Choosing the middle element as pivot
        # mid = (begin + end) // 2
        # swap(mid, end)
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


a = [43, 32, 4, 453, 423, 6547, 234, 76]
quick_sort(a, 0, len(a) - 1)
print(a)
