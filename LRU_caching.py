
class Queue:
    ...
class LRUCache:
    stack = []
    def __init__(self, capacity: int):
        self.capacity = capacity        

    def get(self, key: int) -> int:
        ... 

    def put(self, key: int, value: int) -> None:
        ...