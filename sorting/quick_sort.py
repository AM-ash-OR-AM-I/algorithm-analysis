from typing import List


def quick_sort(arr: List[int], low, high):
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
        pivot = arr[high]
        i = low-1
        for j in range(low, high):
            if arr[j]<pivot:
                i+=1
                swap(i, j)
        swap(i+1, high)
        return i+1
    if low<high:
        index = partition()
        quick_sort(arr, low, index-1)
        quick_sort(arr, index+1, high)
    
a = [43, 32, 4, 453, 423, 6547, 234, 76]
quick_sort(a, 0, len(a)-1)
print(a)