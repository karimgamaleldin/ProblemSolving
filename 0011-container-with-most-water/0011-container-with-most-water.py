class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        area = 0
        while left < right:
            w = right - left
            if height[left] <= height[right]:
                h = height[left] 
                left += 1
            else:
                h = height[right]
                right -= 1
            area = max(area, w * h)
        return area