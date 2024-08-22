class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = right = 0
        hashset = set()
        longest = 0
        while right < len(s):
            l, r = s[left], s[right]
            if r in hashset:
                hashset.remove(l)
                left += 1
            else:
                hashset.add(r)
                right += 1
                longest = max(longest, right - left)
        return longest
            