class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        ans = ""
        for idx, c in enumerate(strs[0]):
            for s in strs:
                if not (idx < len(s) and s[idx] == c):
                    return ans
            ans += c
        return ans
                
                
        