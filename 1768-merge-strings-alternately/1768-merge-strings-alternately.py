class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        ans = ''
        for c, d in zip(word1, word2):
            ans += c + d
        i = len(ans) // 2
        ans += word1[i:] + word2[i:]
        return ans