class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        smallest = float('inf')
        for price in prices:
            if price < smallest:
                smallest = price
            else: 
                max_profit = max(max_profit, price - smallest)
        return max_profit