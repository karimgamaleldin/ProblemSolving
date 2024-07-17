class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        ans = ""
        flag = True
        idx = 0
        while flag:
            c = strs[0][idx] if idx < len(strs[0]) else None
            for s in strs:
                if not (idx < len(s) and s[idx] == c):
                    flag = False
            if flag:
                idx += 1
                ans += c
        return ans
                
                
        