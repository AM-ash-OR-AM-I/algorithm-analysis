from typing import List


def merge_sort(arr: List[int]):
    n = len(arr)
    if n == 1:
        return
    mid = n // 2
    left_sub = arr[:mid]
    right_sub = arr[mid:]
    merge_sort(left_sub)
    merge_sort(right_sub)
    
    # Merge Operation
    p1 = p2 = 0
    p = 0  # array location
    while True:
        if p1 >= len(left_sub) and p2 >= len(right_sub):
            break
        else:
            if p1 < len(left_sub) and p2 < len(right_sub):
                x = left_sub[p1]
                y = right_sub[p2]
                if x >= y:
                    arr[p] = x
                    p1 += 1
                else:
                    arr[p] = y
                    p2 += 1
            elif p1 < len(left_sub):
                arr[p] = left_sub[p1]
                p1 += 1
            elif p2 < len(right_sub):
                arr[p] = right_sub[p2]
                p2 += 1
            p += 1

a = [43, 32, 4, 234, 423, 4234, 234, 234]
merge_sort(a)
print(a)