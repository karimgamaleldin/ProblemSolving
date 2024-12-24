class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        tab = [[0] * (len(word2) + 1) for _ in range(len(word1) + 1)]
        for i in range(len(word1) + 1):
            tab[i][0] = i
        for j in range(len(word2) + 1):
            tab[0][j] = j
        for i, c in enumerate(word1, 1):
            for j, d in enumerate(word2, 1):
                if c == d:
                    tab[i][j] = tab[i - 1][j - 1]
                else:
                    tab[i][j] = min(tab[i - 1][j - 1], tab[i - 1][j], tab[i][j - 1]) + 1
        return tab[-1][-1]
