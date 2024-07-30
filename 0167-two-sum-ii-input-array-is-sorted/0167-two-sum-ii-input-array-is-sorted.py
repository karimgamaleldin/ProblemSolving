class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        numMap = {}
        for i, num in enumerate(numbers):
            tar = target - num
            if tar in numMap:
                return [numMap[tar] + 1, i + 1]
            numMap[num] = i
            