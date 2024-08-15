class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums = sorted(nums)
        for i, num in enumerate(nums):
            if i > 0 and num == nums[i - 1]:
                continue
            target = -num
            left, right = i + 1, len(nums) - 1
            # print('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')
            while left < right:
                # print(num, nums[left], nums[right])
                if left > i + 1 and nums[left] == nums[left - 1]:
                    left += 1
                elif right < len(nums) - 1 and nums[right] == nums[right + 1]:
                    right -= 1
                else:
                    val = nums[left] + nums[right]
                    if val > target:
                        right -= 1
                    elif val < target:
                        left += 1
                    else:
                        ans.append([num, nums[left], nums[right]])
                        left += 1
                        right -= 1
        return ans
                    
        