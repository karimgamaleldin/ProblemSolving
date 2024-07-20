class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        ans = ''
        for c, d in zip(word1, word2):
            ans += c + d
        ans_len = len(ans) // 2
        if len(word1) > ans_len:
            ans += word1[ans_len:]
        elif len(word2) > ans_len:
            ans += word2[ans_len:]
        return ans