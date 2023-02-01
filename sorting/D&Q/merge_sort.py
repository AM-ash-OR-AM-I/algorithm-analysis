from typing import List


def merge_sort(arr: List[int], low: int, high: int):
    def merge():
        p1 = p2 = 0
        temp1 = arr[low : mid + 1]
        temp2 = arr[mid + 1 : high + 1]
        n1 = len(temp1)
        n2 = len(temp2)
        p_arr = low
        while True:
            if p1 >= n1 and p2 >= n2:
                break
            else:
                if p1 < n1 and p2 < n2:
                    x = temp1[p1]
                    y = temp2[p2]
                    if x >= y:
                        arr[p_arr] = x
                        p1 += 1
                    else:
                        arr[p_arr] = y
                        p2 += 1
                elif p1 < n1:
                    arr[p_arr] = temp1[p1]
                    p1 += 1
                elif p2 < n2:
                    arr[p_arr] = temp2[p2]
                    p2 += 1
                p_arr += 1

    if low >= high:
        return
    mid = (low + high) // 2
    merge_sort(arr, low, mid)
    merge_sort(arr, mid + 1, high)
    merge()


a = [43, 32, 4, 234, 423, 4234, 234, 234]
merge_sort(a, 0, len(a) - 1)
print(a)
