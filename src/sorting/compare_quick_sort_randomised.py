"""
Here we compare the quick sort and randomised quick sort algorithms.

Randomised quick sort eliminates the worst case scenario of quick sort, which is when the array is sorted in reverse or normal order and so the pivot is the smallest or largest element in the array. This results in a partition of size 1 and a partition of size n - 1, which is the worst case scenario for quick sort.
"""
import numpy as np
from quick_sort import quick_sort
from quick_sort_randomised import quick_sort_randomised

if __name__ == "__main__":
    from timeit import timeit

    test_cases = [
        [i for i in range(900, 0, -1)],  # Worst case scenario for quick sort.
        [i for i in range(900)],  # Worst case scenario for quick sort.
        np.random.permutation(900),  # Average case scenario for quick sort.
    ]
    # When array is sorted in reverse order, randomised quick sort is orders of magnitude faster than quick sort.
    for a in test_cases:
        b = a.copy()
        print("Randomised quick sort:")
        print(timeit(lambda: quick_sort_randomised(b, 0, len(b) - 1), number=1))
        print("Quick sort:")
        print(timeit(lambda: quick_sort(a, 0, len(a) - 1), number=1))
