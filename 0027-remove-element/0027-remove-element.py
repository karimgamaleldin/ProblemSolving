class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        i, ptr = 0, len(nums) - 1
        while i <= ptr:
            num = nums[i]
            if num == val:
                while nums[ptr] == val:
                    if i == ptr:
                        return ptr
                    ptr -= 1
                nums[i], nums[ptr] = nums[ptr], nums[i]
            i += 1
        return i
            
        