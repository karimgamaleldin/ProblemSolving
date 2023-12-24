class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1: 
            return 1
        last = 1
        beforelast = 2
        for i in range(n, 2, -1):
            temp = beforelast + last
            last = beforelast
            beforelast = temp
        return beforelast
            
        