from collections import defaultdict
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = defaultdict(int)
        for num in nums:
            hashmap[num] +=  1
        keys = list(hashmap.keys())
        keys = sorted(keys, key=lambda k: hashmap[k], reverse=True)
        
        return keys[:k]