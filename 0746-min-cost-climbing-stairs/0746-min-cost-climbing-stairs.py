class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        if(len(cost) <= 2):
            return min(cost[1], cost[0])
        lc = len(cost)
        two = cost[lc - 1]
        one = cost[lc - 2]
        for i in range(lc - 3, -1, -1):
            temp = min(two, one) + cost[i]
            two = one
            one = temp
        return min(one, two)
        
        