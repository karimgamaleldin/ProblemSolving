class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ptr_t = 0
        for c in s:
            while ptr_t < len(t) and t[ptr_t] != c:
                ptr_t += 1
            if ptr_t == len(t):
                return False
            ptr_t += 1
        return True
        