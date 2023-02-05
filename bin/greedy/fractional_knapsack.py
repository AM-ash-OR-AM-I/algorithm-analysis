from typing import List


class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key = lambda x: x[1], reverse=True)
        units_gained = 0
        for boxes, unit_val in boxTypes:
            if truckSize<=0:
                break
            if boxes<truckSize:
                units_gained += unit_val* boxes
            else:
                units_gained += unit_val*truckSize
            truckSize -= boxes
        return units_gained