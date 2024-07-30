class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        prefixes = [1] * n
        suffixes = [1] * n
        for i in range(n - 1):
            prefixes[i + 1] *= prefixes[i] * nums[i]
            suffixes[n - 2 - i] *= suffixes[n - 1 - i] * nums[n - 1 - i]
        ans[0], ans[n - 1] = suffixes[0], prefixes[n - 1]
        for i in range(1, n - 1):
            ans[i] = prefixes[i] * suffixes[i]
        return ans
        