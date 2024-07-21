class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = n - 1
        j = m - 1
        k = n + m - 1
        while i >= 0 or j >= 0:
            val1 = nums1[j] if j >= 0 else -float('inf')
            val2 = nums2[i] if i >= 0 else -float('inf')
            if val1 > val2:
                nums1[k] = nums1[j]
                j -= 1
            else:
                nums1[k] = nums2[i]
                i -= 1
            k -= 1