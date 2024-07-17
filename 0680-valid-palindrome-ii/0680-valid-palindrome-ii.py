class Solution:
    def validPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s)- 1
        while left < right:
            if s[left] != s[right]:
                return self.checkPalindromeItr(s, left+1, right) or self.checkPalindromeItr(s, left, right-1)
            left += 1
            right -= 1
        return True
        
                
    def checkPalindromeItr(self, s:str, left:int, right:int) -> bool:
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
    
    def checkPalindrome(self, s:str, left:int, right: int) -> int:
        if left >= right:
            return 0
        c = s[left]
        d = s[right]
        if c == d:
            return self.checkPalindrome(s, left+1, right-1)
        return 1 + min(self.checkPalindrome(s, left+1, right), self.checkPalindrome(s, left, right-1))
        
        