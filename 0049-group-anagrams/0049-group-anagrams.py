class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        s = strs[0]
        hashmap = {}
        for s in strs:
            chars = [0] * 26
            for c in s:
                chars[ord(c) - ord('a')] += 1
            arr = hashmap.setdefault(tuple(chars), [])
            arr.append(s)
        return list(hashmap.values())
        