class Solution {
    HashMap<Pair<Integer, Integer>, Boolean> memo;
    int n;
    int m;
    String s;
    String p;

    public boolean isMatch(String s, String p) {
        this.n = s.length();
        this.m = p.length();
        this.s = s;
        this.p = p;
        this.memo = new HashMap<>();
        return dp(0, 0);
    }

    public boolean dp(int i, int j) {
        Pair<Integer, Integer> key = new Pair<>(i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (i >= n) {
            // Check if there are remaining characters in the regular expression
            while (j + 1 < m && p.charAt(j + 1) == '*') {
                j += 2;
            }
            // If there are no remaining characters, it's a match; otherwise, return false
            return j == m;
        }
        if (j >= m) return false; // we finished the regular expression and there is no match
        boolean f = i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < m && p.charAt(j + 1) == '*') {
            boolean t = dp(i, j + 2) || (f && dp(i + 1, j));
            memo.put(key, t);
            return t;
        } else if (f) {
            boolean t = dp(i + 1, j + 1);
            memo.put(key, t);
            return t;
        }
        memo.put(key, false);
        return false;
    }
}
