class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        ans = [-1]
        right = arr[-1]
        for i in range(len(arr) - 1, 0, -1):
            right = right if right >= arr[i] else arr[i]
            ans.append(right)
        return ans[::-1]