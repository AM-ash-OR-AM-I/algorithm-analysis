from typing import *

"""Maximize the number of non-overlapping intervals."""

n = 6
s = [1, 2, 3, 4, 5, 6]
f = [5, 2, 4, 7, 6, 8]


def earliest_finish_time(
    start_times: List[int],
    finish_times: List[int],
    n: int,
) -> int:
    """Returns the max. no. of non-overlapping jobs."""
    intervals = sorted(
        [(start_times[i], finish_times[i]) for i in range(n)],
        key=lambda x: x[1],
    )
    current_finish = intervals[0][1]
    jobs = 0
    for start, finish in intervals:
        if start >= current_finish:
            current_finish = finish
            jobs += 1
    return jobs


jobs = earliest_finish_time(s, f, n)
print(jobs)
