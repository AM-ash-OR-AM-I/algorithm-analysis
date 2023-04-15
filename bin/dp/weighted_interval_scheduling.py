"""
Maximize total weight of the intervals.
"""
from typing import List


class WeightedIntervalScheduling:
    intervals: List[int]
    optimal_sol: List[int]
    closest_interval: List[int] = []
    n: int

    def __init__(self, intervals, n) -> None:
        self.optimal_sol = [0] * n
        self.intervals = intervals
        self.n = n

    def bin_search(self, finish_times: List[int], low: int, high: int, x: int) -> int:
        """Finds the max possible end time that is less than x, `T(n) = O(logn)`"""
        mid = (low + high) // 2
        if low >= high:
            if finish_times[mid] <= x:
                return mid
            else:
                return mid - 1

        if finish_times[mid] == x:
            return mid
        elif x > finish_times[mid]:
            return self.bin_search(finish_times, mid + 1, high, x)
        else:
            return self.bin_search(finish_times, low, mid - 1, x)

    def store_optimal(self, weights: List[int]):

        for i in range(self.n):
            self.optimal_sol[i] = max(
                weights[i] + self.optimal_sol[self.closest_interval[i]],
                self.optimal_sol[i - 1],
            )

    def find_interval_included(self):
        """
        Finds all the interval that are included in the final solution
        """
        includes = []
        pointer = self.n - 1
        prev = current = self.optimal_sol[pointer]
        while prev == current:
            prev = current
            pointer -= 1
            current = self.optimal_sol[pointer]
        pointer += 1
        while pointer != -1:
            includes.append(pointer)
            pointer = self.closest_interval[pointer]

        print(self.optimal_sol, includes)

    def maximize_weight(self) -> int:
        """Returns the max. weight of non-overlapping intervals, `T(n) = O(nlogn)`"""

        sorted_intervals: List[tuple[int, int, int]] = sorted(
            [
                (
                    intervals[0][i],
                    intervals[1][i],
                    intervals[2][i],
                )
                for i in range(self.n)
            ],
            key=lambda x: x[1],
        )
        sorted_finish_times = [sorted_intervals[i][1] for i in range(self.n)]
        weights = [sorted_intervals[i][2] for i in range(self.n)]

        # Stores maximum possible (non-overlapping) interval for each interval [T(n) = O(nlogn)]
        for start, _, __ in sorted_intervals:
            max_non_overlap_interval = self.bin_search(
                sorted_finish_times, 0, self.n - 1, start
            )
            self.closest_interval.append(max_non_overlap_interval)

        self.store_optimal(weights)

        self.find_interval_included()

        return self.optimal_sol[-1]


intervals: List[List[int]] = [
    [0, 1, 3, 3, 4, 5, 6, 8],
    [6, 4, 5, 8, 7, 9, 10, 11],
    [8, 5, 3, 4, 4, 7, 5, 3],
]

w = WeightedIntervalScheduling(intervals, len(intervals[0]))
max_weight = w.maximize_weight()
print(max_weight)
