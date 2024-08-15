class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = deque()
        ans = [0] * len(temperatures)
        for i, t in enumerate(temperatures):
            val = 1
            while len(stack) > 0 and stack[-1][0] < t:
                _, idx = stack.pop()
                ans[idx] = i - idx
            stack.append((t, i))                    
        return ans
            