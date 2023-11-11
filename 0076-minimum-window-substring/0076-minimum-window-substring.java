class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for(int i = 0; i < t.length() ; i++) countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        String res = null;
        int count = 0;
        int left = 0;
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            countS.put(c, countS.getOrDefault(c, 0) + 1);
            if(countT.getOrDefault(c, Integer.MIN_VALUE) >= countS.get(c)) count++;
            while(count == t.length()){
                char d = s.charAt(left);
                int x = res == null ? Integer.MAX_VALUE : res.length();
                if(i - left + 1 < x)res = s.substring(left , i + 1);
                countS.put(d, countS.get(d) - 1);
                if(countT.getOrDefault(d, Integer.MIN_VALUE) > countS.get(d)) count--;
                if(countS.get(d) == 0) countS.remove(d);
                left++;
                // System.out.println(res);
            }
        }
        // System.out.println(countT);
        // System.out.println(countS);
        // System.out.println(count);
        return res == null ? "" : res;
    }
}