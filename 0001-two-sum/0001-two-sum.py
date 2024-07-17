class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i, num in enumerate(nums):
            sol = target - num
            if sol in hashmap:
                return [hashmap[sol], i]
            hashmap[num] = i
        return None
        