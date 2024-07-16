class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        arr_len = len(arr)
        sol = [-1] * arr_len
        right = arr[-1]
        for i in range(arr_len-2, -1, -1):
            sol[i] = right
            right = max(arr[i], right)
        return sol