class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        hashmap_s, hashmap_t = {}, {}
        for c, d in zip(s, t):
            if d in hashmap_t and hashmap_t[d] != c:
                return False
            if c in hashmap_s and hashmap_s[c] != d:
                return False
            hashmap_s[c], hashmap_t[d] = d, c
        return True