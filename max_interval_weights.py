# from typing import List


# def max_weight(s, f, w, n):
#     details = [0] * n
#     for i in range(n):
#         details[i] = [s[i], f[i], w[i]]
#     details.sort(reverse=True, key=lambda x: x[2])
#     for x in details:
#         ...

# n = 4
# s = [1, 2, 4, 6]
# f = [3, 5, 9, 10]
# w = [100, 20, 70, 60]
# max_weight(s, f, w, n)

from queue import PriorityQueue


def maxTwoNonOverLapping(interval):
    ## Sorting the given array
    ## on the basis of startTime
    interval.sort()
    print(interval)

    ## Initializing Priority Queue
    ## which stores endTime
    ## and value and sort
    ## on the basis of endTime
    pq = PriorityQueue()

    ## Initializing max
    ## and ans variables
    max_weight = 0
    ans = 0
    res = 0

    ## Traversing the given array
    for e in interval:
        start, finish, weight = e[0], e[1], e[2]
        while not pq.empty():
            ## If endTime from priority
            ## queue is greater
            ## than startTime of
            ## traversing interval
            ## then break the loop
            min_end_time = pq.queue[0][0]
            if min_end_time > start:
                break
            qu = pq.get()

            ## Updating max variable
            qu_weight = qu[1]
            max_weight = max(max_weight, qu_weight)

        print(f"{max_weight = }")
        print(pq.queue, start, finish)
        ## Updating ans variable
        ans = max(max_weight, weight)
        res += ans
        print(weight)
        pq.put([finish, weight])

    return res


## Driver code
if __name__ == "__main__":

    interval = [
        [6, 8, 80],
        [1, 2, 30],
        [3, 4, 40],
        [5, 7, 60],
    ]
    # interval = [
    #     [1, 2, 60],
    #     [2, 3, 80],
    #     [1, 4, 60],
    # ]

    maxValue = maxTwoNonOverLapping(interval)
    print(maxValue)
