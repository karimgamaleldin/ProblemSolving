class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hashset = set(nums)
        ans = 0
        for num in hashset:
            if not num - 1 in hashset:
                length = 1
                while(length + num in hashset):
                    length += 1  
                ans = max(ans, length)
        return ans 
                