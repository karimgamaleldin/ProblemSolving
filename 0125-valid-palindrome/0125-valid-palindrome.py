class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        left = 0
        right = len(s) - 1
        while left < right:
            c = s[left]
            d = s[right]
            if not c.isalnum():
                left += 1
            elif not d.isalnum():
                right -= 1
            elif c == d:
                left += 1
                right -= 1
            else:
                return False
        return True